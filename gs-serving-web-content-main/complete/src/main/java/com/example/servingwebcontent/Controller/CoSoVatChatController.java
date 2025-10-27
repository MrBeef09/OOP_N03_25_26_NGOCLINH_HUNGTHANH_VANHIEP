package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.CoSoVatChat;
import com.example.servingwebcontent.Repository.CoSoVatChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CoSoVatChatController {

    @Autowired
    private CoSoVatChatRepository coSoVatChatRepository;

    @GetMapping("/cosovatchat")
    public String hienThiCoSoVatChat(Model model) {
        List<CoSoVatChat> dsCoSo = coSoVatChatRepository.findAll();
        model.addAttribute("dsCoSo", dsCoSo);
        return "cosovatchat"; // trỏ đến file templates/cosovatchat.html
    }
}
