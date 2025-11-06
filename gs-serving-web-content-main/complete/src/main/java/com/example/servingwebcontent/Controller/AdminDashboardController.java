package com.example.servingwebcontent.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
    
    @GetMapping("/home")
    public String adminHome(Model model) {
        System.out.println("\n===== 🏠 ADMIN HOME CONTROLLER =====");
        
        // Lấy thông tin user đang đăng nhập
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        System.out.println("✅ Username: " + username);
        System.out.println("✅ Authorities: " + auth.getAuthorities());
        
        // Truyền username vào model để hiển thị trong view
        model.addAttribute("username", username);
        
        System.out.println("✅ Returning view: admin/home");
        System.out.println("=====================================\n");
        
        return "admin/home";
    }
    
    @GetMapping("/users")
    public String manageUsers(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/users";
    }
    
    @GetMapping("/universities")
    public String manageUniversities(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/universities";
    }
    
    @GetMapping("/majors")
    public String manageMajors(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/majors";
    }
    
    @GetMapping("/consultations")
    public String manageConsultations(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/consultations";
    }
    
    @GetMapping("/reviews")
    public String manageReviews(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/reviews";
    }
    
    @GetMapping("/reports")
    public String viewReports(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/reports";
    }
    
    @GetMapping("/settings")
    public String settings(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/settings";
    }
    
    @GetMapping("/notifications")
    public String notifications(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/notifications";
    }
    
    @GetMapping("/users/add")
    public String addUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/users-add";
    }
    
    @GetMapping("/universities/add")
    public String addUniversity(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/universities-add";
    }
}

