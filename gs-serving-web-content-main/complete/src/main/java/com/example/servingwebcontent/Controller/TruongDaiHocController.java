package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TruongDaiHocController {

    @GetMapping("/truongdaihoc")
    public String showTruongDaiHocPage() {
        return "truongdaihoc"; // trả về file truongdaihoc.html (trong templates)
    }
}
