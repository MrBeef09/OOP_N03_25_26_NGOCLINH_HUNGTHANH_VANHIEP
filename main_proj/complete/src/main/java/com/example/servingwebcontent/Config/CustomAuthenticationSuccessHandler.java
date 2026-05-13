package com.example.servingwebcontent.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
                                        HttpServletResponse response, 
                                        Authentication authentication) throws IOException, ServletException {
        
        System.out.println("\n===== ✅ ĐĂNG NHẬP THÀNH CÔNG =====");
        System.out.println("Username: " + authentication.getName());
        System.out.println("Principal: " + authentication.getPrincipal());
        
        // In ra tất cả authorities
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("Authorities count: " + authorities.size());
        
        for (GrantedAuthority authority : authorities) {
            System.out.println("  - Authority: [" + authority.getAuthority() + "]");
        }
        
        // Lấy role đầu tiên
        String role = "";
        if (!authorities.isEmpty()) {
            role = authorities.iterator().next().getAuthority();
            System.out.println("Role được chọn để redirect: [" + role + "]");
        }
        
        String redirectUrl = "";
        
        // Kiểm tra role và redirect
        if (role.equals("ROLE_HOCSINH")) {
            redirectUrl = "/user/home";
            System.out.println("✅ Match ROLE_HOCSINH -> Redirect đến: " + redirectUrl);
        } else if (role.equals("ROLE_ADMIN")) {
            redirectUrl = "/admin/home";
            System.out.println("✅ Match ROLE_ADMIN -> Redirect đến: " + redirectUrl);
        } else {
            redirectUrl = "/";
            System.out.println("⚠️ Không match role nào -> Redirect đến: " + redirectUrl);
        }
        
        System.out.println("URL sẽ redirect: " + redirectUrl);
        System.out.println("Context Path: " + request.getContextPath());
        System.out.println("Full redirect URL: " + request.getContextPath() + redirectUrl);
        System.out.println("=====================================\n");
        
        // Thực hiện redirect
        response.sendRedirect(redirectUrl);
    }
}