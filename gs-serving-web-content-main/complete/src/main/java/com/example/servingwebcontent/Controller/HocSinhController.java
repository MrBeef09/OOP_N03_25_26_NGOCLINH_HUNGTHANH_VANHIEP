package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.User.HocSinh;
import com.example.servingwebcontent.service.HocSinhService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hocsinh")
public class HocSinhController {

    @Autowired
    private HocSinhService hocSinhService;

    // CREATE
    @PostMapping("/add")
    public String themHocSinh(@RequestBody HocSinh hs) {
        hocSinhService.themHocSinh(hs);
        return "Đã thêm học sinh: " + hs.getHoTen();
    }

    // READ - all
    @GetMapping("/all")
    public List<HocSinh> layTatCa() {
        return hocSinhService.layTatCaHocSinh();
    }

    // READ - by mã học sinh
    @GetMapping("/{maHS}")
    public HocSinh layTheoMa(@PathVariable String maHS) {
        return hocSinhService.timTheoMa(maHS);
    }

    // UPDATE
    @PutMapping("/{maHS}")
    public String capNhat(@PathVariable String maHS, @RequestBody HocSinh hsMoi) {
        boolean ok = hocSinhService.capNhatHocSinh(maHS, hsMoi);
        return ok ? "Cập nhật thành công!" : "Không tìm thấy học sinh có mã: " + maHS;
    }

    // DELETE
    @DeleteMapping("/{maHS}")
    public String xoa(@PathVariable String maHS) {
        boolean ok = hocSinhService.xoaHocSinh(maHS);
        return ok ? "Đã xoá học sinh có mã: " + maHS : "Không tìm thấy học sinh!";
    }
}
