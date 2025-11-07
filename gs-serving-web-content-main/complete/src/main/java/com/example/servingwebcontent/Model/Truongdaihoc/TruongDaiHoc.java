package com.example.servingwebcontent.Model.Truongdaihoc;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "truong_dai_hoc")
public class TruongDaiHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTruong;

    private String tenTruong;
    private String diaChi;

    @Column(name = "diem_danh_gia")
    private Double diemDanhGia;

    // Liên kết 1-1 với bảng Cơ sở vật chất, dùng EAGER để tránh LazyInitialization
    @OneToOne(mappedBy = "truongDaiHoc", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CoSoVatChat coSoVatChat;

    // Liên kết 1-1 với bảng Đội ngũ giáo viên, dùng EAGER
    @OneToOne(mappedBy = "truongDaiHoc", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DoiNguGiaoVien doiNguGiaoVien;

    // Danh sách ngành học (không lưu trong DB)
    @Transient
    private List<NganhHoc> danhSachNganhHoc = new ArrayList<>();

    // ===== Constructor =====
    public TruongDaiHoc() {}

    public TruongDaiHoc(int maTruong, String tenTruong, String diaChi, Double diemDanhGia) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.diemDanhGia = diemDanhGia;
    }

    // ===== Getter & Setter =====
    public int getMaTruong() { return maTruong; }
    public void setMaTruong(int maTruong) { this.maTruong = maTruong; }

    public String getTenTruong() { return tenTruong; }
    public void setTenTruong(String tenTruong) { this.tenTruong = tenTruong; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public Double getDiemDanhGia() { return diemDanhGia; }
    public void setDiemDanhGia(Double diemDanhGia) { this.diemDanhGia = diemDanhGia; }

    public CoSoVatChat getCoSoVatChat() { return coSoVatChat; }
    public void setCoSoVatChat(CoSoVatChat coSoVatChat) { this.coSoVatChat = coSoVatChat; }

    public DoiNguGiaoVien getDoiNguGiaoVien() { return doiNguGiaoVien; }
    public void setDoiNguGiaoVien(DoiNguGiaoVien doiNguGiaoVien) { this.doiNguGiaoVien = doiNguGiaoVien; }

    public List<NganhHoc> getDanhSachNganhHoc() { return danhSachNganhHoc; }
    public void themNganhHoc(NganhHoc nganh) { danhSachNganhHoc.add(nganh); }

    // ===== Tính điểm đánh giá tổng =====
    public double tinhDiemDanhGia() {
        double diemCSVC = (coSoVatChat != null) ? coSoVatChat.tinhTongDiem() : 0;
        double diemGV = (doiNguGiaoVien != null) ? doiNguGiaoVien.danhGia() : 0;
        return diemCSVC + diemGV;
    }

    // ===== Cập nhật điểm trước khi lưu vào DB =====
    @PrePersist
    @PreUpdate
    public void capNhatDiemDanhGia() {
        this.diemDanhGia = tinhDiemDanhGia();
    }

    // ===== Helper hiển thị =====
    @Override
    public String toString() {
        return "TruongDaiHoc{" +
                "maTruong=" + maTruong +
                ", tenTruong='" + tenTruong + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", diemDanhGia=" + diemDanhGia +
                '}';
    }
}
