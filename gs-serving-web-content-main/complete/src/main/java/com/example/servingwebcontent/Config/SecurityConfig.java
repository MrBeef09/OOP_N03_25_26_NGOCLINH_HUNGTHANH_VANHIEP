package com.example.servingwebcontent.Config;

import com.example.servingwebcontent.Service.TaiKhoanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                .requestMatchers(
                    "/", 
                    "/dang-nhap", 
                    "/dang-ky", 
                    "/register",
                    "/forgot-password",
                    "/login-process", 
                    "/css/**", 
                    "/js/**", 
                    "/images/**", 
                    "/webjars/**"
                ).permitAll()
                .requestMatchers("/truongdaihoc", "/tuvan", "/danhgia", "/profile-page")
                    .hasAnyAuthority("HOCSINH", "ADMIN")
                .requestMatchers("/api/admin/**").hasAuthority("ADMIN")
                .requestMatchers("/api/hocsinh/**").hasAnyAuthority("HOCSINH", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/dang-nhap")
                .loginProcessingUrl("/login-process")
                .usernameParameter("username")  // ← Thêm dòng này
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)  // ← true = luôn redirect về "/"
                .failureUrl("/dang-nhap?error=true")
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