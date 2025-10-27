package com.example.servingwebcontent.Controller;
// import com.example.servingwebcontent.Model.Truongdaihoc.*;
import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.PhongHoc.PhongHoc;

import java.util.ArrayList;
import java.util.List;

public class QuanLyPhongHoc {
    private List<PhongHoc> dsPhongHoc = new ArrayList<>();

    // CREATE
    public void create(PhongHoc phong) {
        dsPhongHoc.add(phong);
        System.out.println("Thêm phòng học thành công!");
    }

    // READ
    public void read() {
        if (dsPhongHoc.isEmpty()) {
            System.out.println("Danh sách phòng học trống.");
        } else {
            for (PhongHoc p : dsPhongHoc) {
                p.xemThongTin();
            }
        }
    }

    // UPDATE
    public void update(String maPhong, PhongHoc phongMoi) {
        for (int i = 0; i < dsPhongHoc.size(); i++) {
            if (dsPhongHoc.get(i).getMaPhong().equals(maPhong)) {
                dsPhongHoc.set(i, phongMoi);
                System.out.println("Cập nhật phòng học thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng học để cập nhật.");
    }

    // DELETE
    public void delete(String maPhong) {
        boolean removed = dsPhongHoc.removeIf(p -> p.getMaPhong().equals(maPhong));
        if (removed) {
            System.out.println("Xóa phòng học thành công!");
        } else {
            System.out.println("Không tìm thấy phòng học để xóa.");
        }
    }
}
