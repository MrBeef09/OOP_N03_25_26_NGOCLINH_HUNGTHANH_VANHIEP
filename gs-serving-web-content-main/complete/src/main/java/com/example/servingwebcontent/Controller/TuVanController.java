package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.NganhHoc;
import com.example.servingwebcontent.Service.TuvanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/tuvan")
public class TuVanController {

    @Autowired
    private TuvanService tuvanService;

    // Hiển thị form tư vấn
    @GetMapping
    public String hienThiFormTuVan() {
        return "tuvan";  // trang tuvan.html trong /templates
    }

    // Xử lý khi người dùng bấm "Tư vấn"
    @PostMapping("/ketqua")
    public String xuLyTuVan(@RequestParam("diemThi") double diemThi,
                            @RequestParam("toHop") String toHop,
                            @RequestParam("soThich") String soThich,
                            Model model) {

        // Tách sở thích nhập vào (vd: "máy tính, lập trình")
        List<String> dsSoThich = Arrays.asList(soThich.split(","));

        // Gọi service để tìm ngành phù hợp nhất
        NganhHoc nganhPhuHop = tuvanService.tuVanTatCaNganh(diemThi, toHop, dsSoThich);

        // Gửi dữ liệu sang giao diện
        model.addAttribute("nganhPhuHop", nganhPhuHop);
        model.addAttribute("diemThi", diemThi);
        model.addAttribute("toHop", toHop);
        model.addAttribute("soThich", soThich);

        return "tuvan"; // hiển thị trang kết quả tư vấn
    }
}
