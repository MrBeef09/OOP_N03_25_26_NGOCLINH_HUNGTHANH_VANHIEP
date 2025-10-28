package com.example.servingwebcontent.Config;

import com.example.servingwebcontent.Service.TaiKhoanService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, TaiKhoanService taiKhoanService) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                // Các trang công khai
                .requestMatchers(
                    "/", 
                    "/dang-nhap", 
                    "/dang-ky", 
                    "/register", // Cho phép POST đến /register
                    "/forgot-password",
                    "/login-process", 
                    "/css/**", 
                    "/js/**", 
                    "/images/**", 
                    "/webjars/**"
                ).permitAll()
                // Các trang của Học sinh (và Admin cũng có thể vào)
                .requestMatchers("/user/home", "/truongdaihoc", "/tuvan", "/danhgia", "/profile-page")
                    .hasAnyRole("HOCSINH", "ADMIN") // Tự động thêm tiền tố "ROLE_"
                // Các trang của Admin
                .requestMatchers("/admin/**", "/api/admin/**").hasRole("ADMIN")
                // Các API của Học sinh
                .requestMatchers("/api/hocsinh/**").hasAnyRole("HOCSINH", "ADMIN")
                // Mọi yêu cầu khác đều cần đăng nhập
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/dang-nhap") // Trang đăng nhập của bạn
                .loginProcessingUrl("/login-process") // Địa chỉ mà form login.html submit đến
                .usernameParameter("username")
                .passwordParameter("password")
                // Cấu hình chuyển hướng sau khi đăng nhập thành công
                .successHandler((request, response, authentication) -> {
                    String redirectUrl = "/"; // Trang mặc định
                    if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
                        redirectUrl = "/admin/dashboard"; // Admin đến trang dashboard
                    } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_HOCSINH"))) {
                        redirectUrl = "/user/home"; // Học sinh đến trang home
                    }
                    response.sendRedirect(redirectUrl);
                })
                .failureUrl("/dang-nhap?error=true") // Nếu đăng nhập thất bại
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
}
