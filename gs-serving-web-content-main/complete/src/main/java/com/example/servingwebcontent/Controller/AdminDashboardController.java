package com.example.servingwebcontent.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
    
    /**
     * Trang Dashboard của Admin
     * URL: /admin/dashboard
     */
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        System.out.println("=== ADMIN DASHBOARD ===");
        System.out.println("Admin: " + username);
        System.out.println("Roles: " + auth.getAuthorities());
        
        model.addAttribute("username", username);
        model.addAttribute("roles", auth.getAuthorities());
        
        return "admin/dashboard";  // Trả về templates/admin/dashboard.html
    }
}