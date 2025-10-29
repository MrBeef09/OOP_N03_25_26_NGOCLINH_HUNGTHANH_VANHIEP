package com.example.servingwebcontent.Config; // Hoặc một package riêng cho security

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // Đánh dấu là một Bean để có thể @Autowired
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        
        System.out.println("=== DEBUG AUTH SUCCESS ===");
        System.out.println("User: " + authentication.getName());
        System.out.println("Roles: " + authentication.getAuthorities());
        
        String redirectUrl = "/"; // Trang mặc định

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            redirectUrl = "/admin/dashboard";
            System.out.println("Redirecting to ADMIN: " + redirectUrl);
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_HOCSINH"))) {
            redirectUrl = "/user/home";
            System.out.println("Redirecting to HOCSINH: " + redirectUrl);
        } else {
            System.out.println("No specific role matched, using default: " + redirectUrl);
        }

        response.sendRedirect(redirectUrl);
    }
}