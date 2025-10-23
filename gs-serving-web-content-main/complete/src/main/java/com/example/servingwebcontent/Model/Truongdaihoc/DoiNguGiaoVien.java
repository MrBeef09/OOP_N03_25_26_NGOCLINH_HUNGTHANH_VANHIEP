package com.example.servingwebcontent.Model.Truongdaihoc;

import jakarta.persistence.*;

@Entity
@Table(name = "doi_ngu_giao_vien")
public class DoiNguGiaoVien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int soLuongGV;
    private int soLuongTS; // số tiến sĩ
    private int soLuongThS; // số thạc sĩ
    private int kinhNghiemTB; // số năm kinh nghiệm trung bình
    private int diemDanhGia; // lưu kết quả danhGia()

    // ===== Quan hệ 1-1 với TruongDaiHoc =====
    @OneToOne
    @JoinColumn(name = "ma_truong")
    private TruongDaiHoc truongDaiHoc;

    // Constructor
    public DoiNguGiaoVien() {}

    public DoiNguGiaoVien(int soLuongGV, int soLuongTS, int soLuongThS, int kinhNghiemTB) {
        this.soLuongGV = soLuongGV;
        this.soLuongTS = soLuongTS;
        this.soLuongThS = soLuongThS;
        this.kinhNghiemTB = kinhNghiemTB;
        this.diemDanhGia = danhGia();
    }

    // Phương thức đánh giá đội ngũ
    public int danhGia() {
        return (soLuongGV / 10) + (soLuongTS * 2) + (soLuongThS) + (kinhNghiemTB / 5);
    }

    // Getters & Setters
    public int getId() { return id; }
    
    public int getSoLuongGV() { return soLuongGV; }
    public void setSoLuongGV(int soLuongGV) { this.soLuongGV = soLuongGV; }

    public int getSoLuongTS() { return soLuongTS; }
    public void setSoLuongTS(int soLuongTS) { this.soLuongTS = soLuongTS; }

    public int getSoLuongThS() { return soLuongThS; }
    public void setSoLuongThS(int soLuongThS) { this.soLuongThS = soLuongThS; }

    public int getKinhNghiemTB() { return kinhNghiemTB; }
    public void setKinhNghiemTB(int kinhNghiemTB) { this.kinhNghiemTB = kinhNghiemTB; }

    public int getDiemDanhGia() { return diemDanhGia; }
    public void setDiemDanhGia(int diemDanhGia) { this.diemDanhGia = diemDanhGia; }

    public TruongDaiHoc getTruongDaiHoc() { return truongDaiHoc; }
    public void setTruongDaiHoc(TruongDaiHoc truongDaiHoc) { this.truongDaiHoc = truongDaiHoc; }

    public void xemThongTin() {
        System.out.println("Giáo viên: " + soLuongGV +
                           " | TS: " + soLuongTS +
                           " | ThS: " + soLuongThS +
                           " | Kinh nghiệm TB: " + kinhNghiemTB + " năm" +
                           " | Điểm: " + danhGia());
    }
}