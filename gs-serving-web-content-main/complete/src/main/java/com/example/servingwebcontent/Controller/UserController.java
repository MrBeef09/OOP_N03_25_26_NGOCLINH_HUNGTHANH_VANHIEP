package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;

@Controller
public class UserController {

    @GetMapping("/user/home")
    public String userHome(Model model, Authentication authentication) {
        // Thêm thông tin user vào model nếu cần
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("username", authentication.getName());
        }
        return "user-home"; // Trả về template user-home.html
    }
}