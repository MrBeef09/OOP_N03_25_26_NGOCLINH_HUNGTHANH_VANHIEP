package com.example.servingwebcontent.Model.User;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "hoc_sinh")
public class HocSinh extends Nguoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_hoc_sinh", nullable = false, unique = true)
    private String maHocSinh;

    @Column(name = "ho_ten", nullable = false)
    private String hoTen;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "diem_thi")
    private Double diemThi;

    //  Mối quan hệ 1-1 với tài khoản
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tai_khoan_id", referencedColumnName = "id")
    private TaiKhoan taiKhoan;

    // ✅ Constructors
    public HocSinh() {}

    public HocSinh(String maHocSinh, String hoTen, String ngaySinh, String gioiTinh,
                   String diaChi, String soDienThoai, Double diemThi, TaiKhoan taiKhoan) {
        this.maHocSinh = maHocSinh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.diemThi = diemThi;
        this.taiKhoan = taiKhoan;
    }

    //  Getter & Setter
    public Long getId() {
        return id;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public LocalDate setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Double getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(Double diemThi) {
        this.diemThi = diemThi;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    //  Một vài method tiện ích
    public void capNhatThongTin(String diaChiMoi, String sdtMoi, Double diemMoi) {
        if (diaChiMoi != null && !diaChiMoi.isEmpty()) this.diaChi = diaChiMoi;
        if (sdtMoi != null && !sdtMoi.isEmpty()) this.soDienThoai = sdtMoi;
        if (diemMoi != null) this.diemThi = diemMoi;
    }

    @Override
    public void XemThongTin() {
        System.out.println("Học sinh: " + hoTen);
        System.out.println("Mã HS: " + maHocSinh);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Điện thoại: " + soDienThoai);
        System.out.println("Điểm thi: " + diemThi);
        System.out.println("Tài khoản: " + (taiKhoan != null ? taiKhoan.getTenDangNhap() : "Chưa có"));
    }

    @Override
    public String toString() {
        return "HocSinh{" +
                "maHocSinh='" + maHocSinh + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diemThi=" + diemThi +
                ", taiKhoan=" + (taiKhoan != null ? taiKhoan.getTenDangNhap() : "null") +
                '}';
    }
}
