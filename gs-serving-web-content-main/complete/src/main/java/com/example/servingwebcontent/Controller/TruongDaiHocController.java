package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Service.TruongDaiHocService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TruongDaiHocController {

    @Autowired
    private TruongDaiHocService truongService;

    @GetMapping("/truongdaihoc")
    public String showTruongDaiHocPage(Model model) {
        List<TruongDaiHoc> dsTruong = truongService.getDanhSachTruongSapXepTheoDiem();
        model.addAttribute("truongList", dsTruong);
        return "truongdaihoc"; 
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/truongdaihoc";
    }
}
