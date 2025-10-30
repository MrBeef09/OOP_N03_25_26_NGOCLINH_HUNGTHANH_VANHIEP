package com.example.servingwebcontent.Config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        System.out.println("\n🔍 ===== REQUEST FILTER =====");
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("Method: " + req.getMethod());
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            System.out.println("✅ User: " + auth.getName());
            System.out.println("✅ Authorities: " + auth.getAuthorities());
        } else {
            System.out.println("❌ No authentication");
        }
        
        chain.doFilter(request, response);
        
        System.out.println("Response Status: " + res.getStatus());
        System.out.println("=============================\n");
    }
}