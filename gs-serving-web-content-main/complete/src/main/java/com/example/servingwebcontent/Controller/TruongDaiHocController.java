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

    // 📌 1. Hiển thị danh sách trường đại học (cho cả user & admin)
    @GetMapping
    public String hienThiDanhSach(Model model) {
        List<TruongDaiHoc> dsTruong = truongService.getDanhSachTruongSapXepTheoDiem();

        if (dsTruong == null || dsTruong.isEmpty()) {
            model.addAttribute("message", "Chưa có dữ liệu trường đại học trong hệ thống!");
        } else {
            model.addAttribute("truongList", dsTruong);
        }

        return "admin/home"; // view hiển thị danh sách
    }

    // 📌 2. Xem chi tiết trường — ai cũng xem được
    @GetMapping("/{id}")
    public String xemChiTiet(@PathVariable int id, Model model) {
        model.addAttribute("truong", truongService.getTruongById(id).orElse(null));
        return "truongdaihoc/detail";
    }

    // 📌 3. Hiển thị form thêm mới — chỉ Admin được thêm
    @GetMapping("/add")
    public String hienThiFormThem(Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403"; // nếu không phải admin → trang lỗi
        }
        return "admin/home"; // Dù bạn dùng modal, đây là phương thức GET
    }

    @PostMapping("/add")
    public String xuLyThemTruong(@ModelAttribute TruongDaiHoc truong, Authentication auth) {
        
        // 1. Kiểm tra quyền Admin
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        
        // 2. @ModelAttribute "truong" sẽ tự động nhận dữ liệu từ form
        //    (miễn là các thẻ <input> có 'name="tenTruong"', 'name="diaChi"')
        System.out.println("Đang xử lý thêm trường: " + truong.getTenTruong());
        
        // 3. Gọi Service để lưu vào cơ sở dữ liệu
        truongService.saveTruong(truong);
        
        // 4. Chuyển hướng trình duyệt về trang /admin/universities
        //    để AdminDashboardController tải lại danh sách mới
        return "redirect:/admin/universities";
    }



    // 📌 5. Sửa thông tin trường — chỉ Admin
    @GetMapping("/edit/{id}")
    public String hienThiFormSua(@PathVariable int id, Model model, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        model.addAttribute("truong", truongService.getTruongById(id).orElse(null));
        return "truongdaihoc/edit";
    }

    @PostMapping("/edit")
    public String xuLySua(@ModelAttribute TruongDaiHoc truong, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        truongService.saveTruong(truong);
        return "redirect:/truongdaihoc";
    }

    // 📌 6. Xóa trường — chỉ Admin
    @GetMapping("/delete/{id}")
    public String xoaTruong(@PathVariable int id, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        truongService.deleteTruong(id);
        return "redirect:/truongdaihoc";
    }
}
