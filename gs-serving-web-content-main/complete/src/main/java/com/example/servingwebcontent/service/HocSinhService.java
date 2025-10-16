package com.example.servingwebcontent.service;

import com.example.servingwebcontent.Model.User.HocSinh;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HocSinhService {
    private List<HocSinh> danhSachHocSinh = new ArrayList<>();

    // CREATE
    public void themHocSinh(HocSinh hs) {
        danhSachHocSinh.add(hs);
    }

    // READ - all
    public List<HocSinh> layTatCaHocSinh() {
        return danhSachHocSinh;
    }

    // READ - by mã học sinh
    public HocSinh timTheoMa(String maHocSinh) {
        return danhSachHocSinh.stream()
                .filter(hs -> hs.getMaHocSinh().equals(maHocSinh))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean capNhatHocSinh(String maHocSinh, HocSinh hsMoi) {
        HocSinh hs = timTheoMa(maHocSinh);
        if (hs != null) {
            hs.setHoTen(hsMoi.getHoTen());
            hs.setNgaySinh(hsMoi.getNgaySinh());
            hs.setGioiTinh(hsMoi.getGioiTinh());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean xoaHocSinh(String maHocSinh) {
        return danhSachHocSinh.removeIf(hs -> hs.getMaHocSinh().equals(maHocSinh));
    }
}

