package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Service.TruongDaiHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/truongdaihoc")
public class TruongDaiHocController {

    @Autowired
    private TruongDaiHocService truongService;

    // Hiển thị danh sách trường cho trang riêng
    @GetMapping
    public String hienThiDanhSach(Model model) {
        List<TruongDaiHoc> dsTruong = truongService.getDanhSachTruongSapXepTheoDiem();
        model.addAttribute("truongList", dsTruong);
        return "/truongdaihoc"; // view riêng
    }

    @GetMapping("/{id}")
    public String xemChiTiet(@PathVariable int id, Model model) {
        model.addAttribute("truong", truongService.getTruongById(id).orElse(null));
        return "/truongdaihoc";
    }

    // Chỉnh sửa / xóa / thêm theo URL riêng
    @GetMapping("/edit/{id}")
    public String hienThiFormSua(@PathVariable int id, Model model, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        model.addAttribute("truong", truongService.getTruongById(id).orElse(null));
        return "/truongdaihoc";
    }

    @PostMapping("/edit")
    public String xuLySua(@ModelAttribute TruongDaiHoc truong, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        truongService.saveTruong(truong);
        return "redirect:/truongdaihoc";
    }

    @GetMapping("/delete/{id}")
    public String xoaTruong(@PathVariable int id, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        truongService.deleteTruong(id);
        return "redirect:/truongdaihoc";
    }
}
