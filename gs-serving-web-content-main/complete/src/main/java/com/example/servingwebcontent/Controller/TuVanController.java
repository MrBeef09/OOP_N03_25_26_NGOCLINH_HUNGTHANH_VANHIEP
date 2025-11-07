package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.NganhHoc;
import com.example.servingwebcontent.Service.TuvanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/tuvan")
public class TuVanController {

    @Autowired
    private TuvanService tuvanService;

    @GetMapping
    public String hienThiFormTuVan() {
        return "tuvan";
    }

    @PostMapping("/ketqua")
    public String xuLyTuVan(@RequestParam("diemThi") double diemThi,
                            @RequestParam("toHop") String toHop,
                            @RequestParam("soThich") String soThich,
                            Model model) {

        List<String> dsSoThich = Arrays.asList(soThich.split(","));
        List<NganhHoc> top5 = tuvanService.tuVanTatCaNganh(diemThi, toHop, dsSoThich);

        model.addAttribute("dsKetQua", top5);
        model.addAttribute("diemThi", diemThi);
        model.addAttribute("toHop", toHop);
        model.addAttribute("soThich", soThich);

        return "tuvan";
    }
}