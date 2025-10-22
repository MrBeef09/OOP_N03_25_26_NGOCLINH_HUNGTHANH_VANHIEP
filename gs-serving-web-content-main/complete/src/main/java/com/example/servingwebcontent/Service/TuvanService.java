package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.NganhHoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TuvanService {

    private List<NganhHoc> dsNganh;

    public TuvanService() {
        dsNganh = new ArrayList<>();

        // ===== DỮ LIỆU MẪU =====
        dsNganh.add(new NganhHoc(
                "Công nghệ thông tin", "CNTT01", "A00, A01",
                25.5, 95, 20, 200, 150,
                Arrays.asList("máy tính", "lập trình", "khoa học", "logic")
        ));

        dsNganh.add(new NganhHoc(
                "Kinh tế", "KT01", "A00, D01",
                24.0, 90, 18, 150, 120,
                Arrays.asList("kinh doanh", "quản lý", "tài chính", "số liệu")
        ));

        dsNganh.add(new NganhHoc(
                "Ngôn ngữ Anh", "NNA01", "D01",
                23.5, 85, 15, 120, 100,
                Arrays.asList("ngôn ngữ", "du lịch", "giao tiếp", "ngoại ngữ")
        ));

        dsNganh.add(new NganhHoc(
                "Y khoa", "Y01", "B00",
                27.0, 98, 25, 100, 80,
                Arrays.asList("sức khỏe", "chăm sóc", "y học", "con người")
        ));
    }

    // ===== Thêm ngành học mới =====
    public void themNganh(NganhHoc nganh) {
        dsNganh.add(nganh);
    }

    // ===== Lấy danh sách ngành học =====
    public List<NganhHoc> getDsNganh() {
        return dsNganh;
    }

    // ===== Tư vấn ngành phù hợp =====
    public List<NganhHoc> tuVanTatCaNganh(double diemThiHS, String toHopHS, List<String> soThichHS) {
    List<NganhHoc> ketQua = new ArrayList<>();

    for (NganhHoc n : dsNganh) {
        double diem = n.tinhDiemNganh(diemThiHS, toHopHS, soThichHS);
        n.setDiemPhuHop(diem); // bạn thêm 1 trường tạm trong NganhHoc để lưu điểm
        ketQua.add(n);
    }

    // Sắp xếp giảm dần theo điểm phù hợp
    ketQua.sort((a, b) -> Double.compare(b.getDiemPhuHop(), a.getDiemPhuHop()));
    return ketQua;
}

}
