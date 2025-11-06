package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat;
import com.example.servingwebcontent.Service.CoSoVatChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cosovatchat")
public class CoSoVatChatController {

    @Autowired
    private CoSoVatChatService coSoVatChatService;

    //  Hiển thị danh sách cho cả user và admin
    @GetMapping
    public String hienThiDanhSach(Model model) {
        model.addAttribute("danhSachCSVatChat", coSoVatChatService.layTatCaCoSoVatChat());
        return "cosovatchat/list"; // view: templates/cosovatchat/list.html
    }

    //  Xem chi tiết — ai cũng xem được
    @GetMapping("/{id}")
    public String xemChiTiet(@PathVariable int id, Model model) {
        model.addAttribute("csvc", coSoVatChatService.timTheoId(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cơ sở vật chất")));
        return "cosovatchat/detail";
    }

    //  Thêm mới — chỉ admin
    @GetMapping("/add")
    public String hienThiFormThem(Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        return "cosovatchat/add";
    }

    @PostMapping("/add")
    public String xuLyThem(@ModelAttribute CoSoVatChat csvc, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        coSoVatChatService.themCoSoVatChat(csvc);
        return "redirect:/cosovatchat";
    }

    // Sửa — chỉ admin
    @GetMapping("/edit/{id}")
    public String hienThiFormSua(@PathVariable int id, Model model, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        model.addAttribute("csvc", coSoVatChatService.timTheoId(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cơ sở vật chất")));
        return "cosovatchat/edit";
    }

    @PostMapping("/edit")
    public String xuLySua(@ModelAttribute CoSoVatChat csvc, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        coSoVatChatService.capNhatCoSoVatChat(csvc.getId(), csvc);
        return "redirect:/cosovatchat";
    }

    //  Xóa — chỉ admin
    @GetMapping("/delete/{id}")
    public String xoa(@PathVariable int id, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        coSoVatChatService.xoaCoSoVatChat(id);
        return "redirect:/cosovatchat";
    }
}
