package com.example.servingwebcontent.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.servingwebcontent.service.CoSoVatChatService;

@Controller
public class CoSoVatChatController {

    @Autowired
    private CoSoVatChatService coSoVatChatService;

    @GetMapping("/cosovatchat")
    public String hienThiThongTinCSVC(Model model) {
        model.addAttribute("coSoVatChat", coSoVatChatService.layDanhSachCSVC());
        return "cosovatchat"; // file cosovatchat.html trong templates
    }
}