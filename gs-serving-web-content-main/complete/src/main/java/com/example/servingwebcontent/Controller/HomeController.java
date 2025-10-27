package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model, Principal principal) {
        System.out.println("===== HOME PAGE =====");
        if (principal != null) {
            System.out.println("Logged in user: " + principal.getName());
            model.addAttribute("username", principal.getName());
        } else {
            System.out.println("No user logged in");
        }
        System.out.println("====================");
        
        return "index"; // hoặc tên template trang chủ của bạn
    }
}