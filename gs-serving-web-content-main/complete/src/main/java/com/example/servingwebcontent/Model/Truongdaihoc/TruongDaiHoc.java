package com.example.servingwebcontent.Model.Truongdaihoc;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "truong_dai_hoc")
public class TruongDaiHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTruong;

    private String tenTruong;
    private String diaChi;

    // Các phần này tạm thời chưa lưu vào DB
    @Transient
    private CoSoVatChat coSoVatChat;

    @Transient
    private DoiNguGiaoVien doiNguGiaoVien;

    @Transient
    private List<NganhHoc> danhSachNganhHoc;

    public TruongDaiHoc() {} // Bắt buộc có constructor rỗng cho JPA

    public TruongDaiHoc(int maTruong, String tenTruong, String diaChi) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.coSoVatChat = new CoSoVatChat();
        this.doiNguGiaoVien = new DoiNguGiaoVien(0, 0, 0, 0);
        this.danhSachNganhHoc = new ArrayList<>();
    }





    // ===== Getter & Setter =====
    public int getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(int maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public CoSoVatChat getCoSoVatChat() {
        return coSoVatChat;
    }

    public void setCoSoVatChat(CoSoVatChat coSoVatChat) {
        this.coSoVatChat = coSoVatChat;
    }

    public DoiNguGiaoVien getDoiNguGiaoVien() {
        return doiNguGiaoVien;
    }

    public void setDoiNguGiaoVien(DoiNguGiaoVien doiNguGiaoVien) {
        this.doiNguGiaoVien = doiNguGiaoVien;
    }

    

    public List<NganhHoc> getDanhSachNganhHoc() {
        return danhSachNganhHoc;
    }

    // ====== Các phương thức thêm dữ liệu ======
   

    public void themNganhHoc(NganhHoc nganh) {
        danhSachNganhHoc.add(nganh);
    }

    // ====== Tính điểm tổng đánh giá trường ======
    public int tinhDiemDanhGia() {
        int diemCSVC = (coSoVatChat != null) ? coSoVatChat.tinhTongDiem() : 0;
        int diemGV = (doiNguGiaoVien != null) ? doiNguGiaoVien.danhGia() : 0;
        return diemCSVC + diemGV;
    }

    // ====== Hiển thị thông tin ======
    public void xemThongTin() {
        System.out.println("======================================");
        System.out.println("Mã trường: " + maTruong);
        System.out.println("Tên trường: " + tenTruong);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("----- Cơ sở vật chất -----");
        coSoVatChat.xemThongTin();
        System.out.println("----- Đội ngũ giáo viên -----");
        doiNguGiaoVien.xemThongTin();
        System.out.println("Điểm đánh giá tổng: " + tinhDiemDanhGia());
        System.out.println("======================================");
    }
}
