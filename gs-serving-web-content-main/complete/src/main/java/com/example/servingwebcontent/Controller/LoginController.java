package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {
    
    @GetMapping("/dang-nhap")
    public String loginPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String message,
            Model model) {
        
        if ("true".equals(error)) {
            String errorMessage = (message != null && !message.isEmpty()) 
                ? message 
                : "Tên đăng nhập hoặc mật khẩu không đúng!";
            model.addAttribute("errorMessage", errorMessage);
            System.out.println("❌ Hiển thị lỗi đăng nhập: " + errorMessage);
        }
        
        return "login";
    }
}