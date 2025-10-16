package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Service.TruongDaiHocService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TruongDaiHocController {

    @Autowired
    private TruongDaiHocService truongService;

    @GetMapping("/truongdaihoc")
    public String showTruongDaiHocPage(Model model) {
        List<TruongDaiHoc> dsTruong = truongService.getDanhSachTruong();
        model.addAttribute("truongList", dsTruong);
        return "truongdaihoc";
    }
    @GetMapping("/truongdaihoc/{id}/cosovatchat")
public String xemChiTietCoSoVatChat(@PathVariable int id, Model model) {
    // TruongDaiHoc truong = truongService.findById(id);
    // model.addAttribute("truong", truong);
    // model.addAttribute("cosoVatChat", truong.getCoSoVatChat());
    return "cosovatchat-detail";
}
 

}
