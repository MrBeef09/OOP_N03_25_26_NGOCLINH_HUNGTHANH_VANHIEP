package com.example.servingwebcontent.Config;

import com.example.servingwebcontent.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, TaiKhoanService taiKhoanService) throws Exception {
        http
            .authorizeHttpRequests(authz -> {
                System.out.println("🔧 Configuring authorization rules...");
                authz
                    // Các trang công khai
                    .requestMatchers(
                        "/", 
                        "/dang-nhap",
                        "/forgot-password",
                        "/login-process",
                        "/test-password",
                        "/encode-password",
                        "/compare-password",
                        "/init-accounts",
                        "/create-account",
                        "/list-accounts",
                        "/css/**", 
                        "/js/**", 
                        "/images/**", 
                        "/webjars/**"
                    ).permitAll()
                    
                    // Các trang của Học sinh (sử dụng hasAnyRole)
                    .requestMatchers("/user/**", "/truongdaihoc", "/tuvan", "/danhgia", "/profile-page")
                        .hasAnyRole("HOCSINH", "ADMIN")
                    
                    // Các trang của Admin
                    .requestMatchers("/admin/**", "/api/admin/**")
                        .hasRole("ADMIN")
                    
                    // Các API của Học sinh
                    .requestMatchers("/api/hocsinh/**")
                        .hasAnyRole("HOCSINH", "ADMIN")
                    
                    // Mọi yêu cầu khác đều cần đăng nhập
                    .anyRequest().authenticated();
                System.out.println("✅ Authorization rules configured!");
            })
            .formLogin(form -> form
                .loginPage("/dang-nhap")
                .loginProcessingUrl("/login-process")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler())
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            )
            .userDetailsService(taiKhoanService);
            
        return http.build();
    }
    
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (request, response, exception) -> {
            System.out.println("\n===== ❌ ĐĂNG NHẬP THẤT BẠI =====");
            System.out.println("Username: [" + request.getParameter("username") + "]");
            System.out.println("Password length: " + 
                (request.getParameter("password") != null ? request.getParameter("password").length() : "null"));
            System.out.println("Exception type: " + exception.getClass().getSimpleName());
            System.out.println("Exception message: " + exception.getMessage());
            System.out.println("=====================================\n");
            
            String errorMessage = "Sai tên đăng nhập hoặc mật khẩu!";
            response.sendRedirect("/dang-nhap?error=true&message=" + 
                java.net.URLEncoder.encode(errorMessage, "UTF-8"));
        };
    }
}