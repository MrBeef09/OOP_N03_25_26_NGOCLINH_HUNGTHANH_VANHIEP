package com.example.servingwebcontent.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    
    public UserController() {
        System.out.println("🔧 UserController đã được khởi tạo!");
    }
    
    @GetMapping("/test")
@ResponseBody
public String testEndpoint(Authentication authentication) {
    System.out.println("🧪 TEST ENDPOINT CALLED - User: " + authentication.getName());
    return "UserController is working! User: " + authentication.getName();
}
    
    
    @GetMapping("/home")
    public String userHome(Model model, Authentication authentication) {
        System.out.println("\n===== 🏠 TRUY CẬP /user/home =====");
        System.out.println("Method: GET /user/home");
        
        if (authentication != null) {
            System.out.println("✅ Authentication exists");
            System.out.println("  - Username: " + authentication.getName());
            System.out.println("  - Authorities: " + authentication.getAuthorities());
            System.out.println("  - Principal: " + authentication.getPrincipal());
            System.out.println("  - Is Authenticated: " + authentication.isAuthenticated());
            model.addAttribute("username", authentication.getName());
        } else {
            System.out.println("❌ Authentication is NULL");
        }
        
        System.out.println("Returning view: user/home");
        System.out.println("=====================================\n");
        
        return "user/home"; // Trả về file templates/user/home.html
    }
}