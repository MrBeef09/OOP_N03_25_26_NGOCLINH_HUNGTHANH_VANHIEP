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

    // ✅ Thêm trường điểm đánh giá để lưu trong database
    @Column(name = "diem_danh_gia")
    private double diemDanhGia;

    // Nếu bạn không cần ánh xạ với bảng khác, thì giữ @Transient để tránh lỗi JPA
    @OneToOne(mappedBy = "truongDaiHoc", cascade = CascadeType.ALL)
    private CoSoVatChat coSoVatChat;

    @OneToOne(mappedBy = "truongDaiHoc", cascade = CascadeType.ALL)
    private DoiNguGiaoVien doiNguGiaoVien;

    @Transient
    private List<NganhHoc> danhSachNganhHoc;

    // ====== Constructor ======
    public TruongDaiHoc() {
        this.coSoVatChat = new CoSoVatChat();
        this.doiNguGiaoVien = new DoiNguGiaoVien(0, 0, 0, 0);
        this.danhSachNganhHoc = new ArrayList<>();
    }

    public TruongDaiHoc(int maTruong, String tenTruong, String diaChi, int diemDanhGia) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.diemDanhGia = diemDanhGia;
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

    public double getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(int diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
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

    public void themNganhHoc(NganhHoc nganh) {
        danhSachNganhHoc.add(nganh);
    }

    // ====== Tính điểm tổng (nếu muốn cập nhật tự động) ======
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
        System.out.println("Điểm đánh giá: " + diemDanhGia);

        System.out.println("----- Cơ sở vật chất -----");
        if (coSoVatChat != null) {
            coSoVatChat.xemThongTin();
            System.out.println("Tổng điểm CSVC: " + coSoVatChat.tinhTongDiem());
        } else {
            System.out.println("Chưa có dữ liệu cơ sở vật chất.");
        }

        System.out.println("----- Đội ngũ giáo viên -----");
        if (doiNguGiaoVien != null) {
            doiNguGiaoVien.xemThongTin();
            System.out.println("Điểm GV: " + doiNguGiaoVien.danhGia());
        } else {
            System.out.println("Chưa có dữ liệu đội ngũ giáo viên.");
        }

        System.out.println("=> Tổng điểm đánh giá (tính toán): " + tinhDiemDanhGia());
        System.out.println("======================================");
    }
}
