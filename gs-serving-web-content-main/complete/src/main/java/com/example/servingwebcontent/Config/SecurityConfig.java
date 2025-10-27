// src/main/java/com/example/servingwebcontent/Config/SecurityConfig.java
package com.example.servingwebcontent.Config;

import com.example.servingwebcontent.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private TaiKhoanService taiKhoanService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                // cho phép truy cập trang chính, trang đăng nhập/đăng ký và tài nguyên tĩnh
                .requestMatchers("/", "/dang-nhap", "/dang-ky", "/login-process", "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                .requestMatchers("/truongdaihoc", "/tuvan", "/danhgia", "/profile-page")
                .hasAnyRole("HOCSINH", "ADMIN")
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/hocsinh/**").hasAnyRole("HOCSINH", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/dang-nhap")               // phải khớp với template hiện tại
                .loginProcessingUrl("/login-process")  // khớp với th:action trong form
                .defaultSuccessUrl("/", true)
                .failureUrl("/dang-nhap?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // POST /logout
                .logoutSuccessUrl("/") // về trang chính
                .permitAll()
            )
            .userDetailsService(taiKhoanService);

        return http.build();
    }
}