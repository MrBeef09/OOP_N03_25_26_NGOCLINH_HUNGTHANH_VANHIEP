package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.User.GiaoVien;
import com.example.servingwebcontent.Service.GiaoVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/giaovien")
public class GiaoVienController {

    @Autowired
    private GiaoVienService giaoVienService;

    // CREATE
    @PostMapping("/add")
    public String themGiaoVien(@RequestBody GiaoVien gv) {
        giaoVienService.themGiaoVien(gv);
        return "Đã thêm giáo viên: " + gv.getHoTen();
    }

    // READ ALL
    @GetMapping("/all")
    public List<GiaoVien> layTatCa() {
        return giaoVienService.layTatCa();
    }

    // READ ONE
    @GetMapping("/{maGV}")
    public GiaoVien layTheoMa(@PathVariable String maGV) {
        return giaoVienService.timTheoMa(maGV);
    }

    // UPDATE
    @PutMapping("/{maGV}")
    public String capNhat(@PathVariable String maGV, @RequestBody GiaoVien gvMoi) {
        boolean ok = giaoVienService.capNhatThongTin(maGV, gvMoi);
        return ok ? "Cập nhật thành công" : "Không tìm thấy giáo viên có mã " + maGV;
    }

    // DELETE
    @DeleteMapping("/{maGV}")
    public String xoa(@PathVariable String maGV) {
        boolean ok = giaoVienService.xoaGiaoVien(maGV);
        return ok ? "Đã xoá giáo viên có mã " + maGV : "Không tìm thấy giáo viên!";
    }
}
