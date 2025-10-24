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

    //  Trang hiển thị danh sách trường đại học, tự động tính và cập nhật điểm
    @GetMapping("/truongdaihoc")
    public String showTruongDaiHocPage(Model model) {
        // Lấy danh sách trường đã tính điểm và sắp xếp
        List<TruongDaiHoc> dsTruong = truongService.getDanhSachTruongSapXepTheoDiem();

        // Đảm bảo không null
        if (dsTruong == null || dsTruong.isEmpty()) {
            model.addAttribute("message", "Chưa có dữ liệu trường đại học trong hệ thống!");
        } else {
            model.addAttribute("truongList", dsTruong);
        }

        // Trả về tên file HTML (resources/templates/truongdaihoc.html)
        return "truongdaihoc";
    }
}
