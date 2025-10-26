// package com.example.servingwebcontent.Service;

// import com.example.servingwebcontent.Model.User.GiaoVien;
// import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class GiaoVienService {

//     private List<GiaoVien> danhSachGiaoVien = new ArrayList<>();

//     // CREATE
//     public void themGiaoVien(GiaoVien gv) {
//         danhSachGiaoVien.add(gv);
//     }

//     // READ
//     public List<GiaoVien> layTatCa() {
//         return danhSachGiaoVien;
//     }

//     public GiaoVien timTheoMa(String maGV) {
//         return danhSachGiaoVien.stream()
//                 .filter(gv -> gv.getMaGiaoVien().equals(maGV))
//                 .findFirst()
//                 .orElse(null);
//     }

//     // UPDATE
//     public boolean capNhatThongTin(String maGV, GiaoVien gvMoi) {
//         GiaoVien gvCu = timTheoMa(maGV);
//         if (gvCu != null) {
//             gvCu.setHoTen(gvMoi.getHoTen());
//             gvCu.setNgaySinh(gvMoi.getNgaySinh());
//             gvCu.setGioiTinh(gvMoi.getGioiTinh());
//             gvCu.SetMaGiaoVien(gvMoi.getMaGiaoVien());
//             return true;
//         }
//         return false;
//     }

//     // DELETE
//     public boolean xoaGiaoVien(String maGV) {
//         return danhSachGiaoVien.removeIf(gv -> gv.getMaGiaoVien().equals(maGV));
//     }
// }
