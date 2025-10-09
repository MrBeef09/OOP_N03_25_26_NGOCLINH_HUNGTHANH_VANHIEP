package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Trả về tên file index.html trong thư mục templates
        return "index";
    }
}
