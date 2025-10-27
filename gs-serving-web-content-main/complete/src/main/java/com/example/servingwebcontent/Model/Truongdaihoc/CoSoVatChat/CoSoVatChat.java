package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat;

import jakarta.persistence.*;
//import java.util.ArrayList;
//import java.util.List;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;

@Entity
@Table(name = "co_so_vat_chat")
public class CoSoVatChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int soPhongHoc;
    private int soKyTucXa;
    private int soThuVien;
    private int soTrangThietBi;
    private int soTienIch;
    private int soHaTangKiThuat;
    private int tongDiem; // tổng điểm được tính

    // ===== Quan hệ 1-1 với TruongDaiHoc =====
    @OneToOne
    @JoinColumn(name = "ma_truong") // liên kết với cột ma_truong trong bảng truong_dai_hoc
    private TruongDaiHoc truongDaiHoc;

    // ===== Constructor =====
    public CoSoVatChat() {}

    public CoSoVatChat(int soPhongHoc, int soKyTucXa, int soThuVien, int soTrangThietBi, int soTienIch, int soHaTangKiThuat) {
        this.soPhongHoc = soPhongHoc;
        this.soKyTucXa = soKyTucXa;
        this.soThuVien = soThuVien;
        this.soTrangThietBi = soTrangThietBi;
        this.soTienIch = soTienIch;
        this.soHaTangKiThuat = soHaTangKiThuat;
        this.tongDiem = tinhTongDiem();
    }

    // ===== Tính điểm =====
    public int tinhTongDiem() {
        // ví dụ mỗi hạng mục đóng góp 10 điểm
        return (soPhongHoc + soKyTucXa + soThuVien + soTrangThietBi + soTienIch + soHaTangKiThuat) * 10;
    }

    // ===== Getter & Setter =====
    public int getId() { return id; }

    public int getSoPhongHoc() { return soPhongHoc; }
    public void setSoPhongHoc(int soPhongHoc) { this.soPhongHoc = soPhongHoc; }

    public int getSoKyTucXa() { return soKyTucXa; }
    public void setSoKyTucXa(int soKyTucXa) { this.soKyTucXa = soKyTucXa; }

    public int getSoThuVien() { return soThuVien; }
    public void setSoThuVien(int soThuVien) { this.soThuVien = soThuVien; }

    public int getSoTrangThietBi() { return soTrangThietBi; }
    public void setSoTrangThietBi(int soTrangThietBi) { this.soTrangThietBi = soTrangThietBi; }

    public int getSoTienIch() { return soTienIch; }
    public void setSoTienIch(int soTienIch) { this.soTienIch = soTienIch; }

    public int getSoHaTangKiThuat() { return soHaTangKiThuat; }
    public void setSoHaTangKiThuat(int soHaTangKiThuat) { this.soHaTangKiThuat = soHaTangKiThuat; }

    public int getTongDiem() { return tongDiem; }
    public void setTongDiem(int tongDiem) { this.tongDiem = tongDiem; }

    public TruongDaiHoc getTruongDaiHoc() { return truongDaiHoc; }
    public void setTruongDaiHoc(TruongDaiHoc truongDaiHoc) { this.truongDaiHoc = truongDaiHoc; }

    // ===== Hiển thị =====
    public void xemThongTin() {
        System.out.println("Phòng học: " + soPhongHoc);
        System.out.println("Ký túc xá: " + soKyTucXa);
        System.out.println("Thư viện: " + soThuVien);
        System.out.println("Trang thiết bị: " + soTrangThietBi);
        System.out.println("Tiện ích: " + soTienIch);
        System.out.println("Hạ tầng kỹ thuật: " + soHaTangKiThuat);
        System.out.println("=> Tổng điểm: " + tinhTongDiem());
    }
}
