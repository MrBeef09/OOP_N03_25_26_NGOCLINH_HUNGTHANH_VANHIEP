package com.example.servingwebcontent.Model.User;

import javax.persistence.*;

@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_dang_nhap", nullable = false, unique = true)
    private String tenDangNhap;

    @Column(name = "mat_khau", nullable = false)
    private String matKhau;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "vai_tro")
    private String vaiTro; // Lưu với format "ROLE_ADMIN" hoặc "ROLE_HOCSINH"

    // Constructors
    public TaiKhoan() {}

    public TaiKhoan(String tenDangNhap, String matKhau, String vaiTro) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    // ✅ SỬA METHOD NÀY - Chấp nhận cả "ROLE_" prefix
    public void setVaiTro(String vaiTro) {
        if (vaiTro == null || vaiTro.trim().isEmpty()) {
            throw new IllegalArgumentException("Vai trò không được để trống.");
        }
        
        String normalized = vaiTro.trim().toUpperCase();
        
        // Chấp nhận cả "ADMIN", "HOCSINH", "ROLE_ADMIN", "ROLE_HOCSINH"
        if (normalized.equals("ADMIN") || normalized.equals("HOCSINH") ||
            normalized.equals("ROLE_ADMIN") || normalized.equals("ROLE_HOCSINH")) {
            this.vaiTro = normalized;
        } else {
            throw new IllegalArgumentException("Vai trò không hợp lệ. Chỉ chấp nhận ADMIN hoặc HOCSINH.");
        }
    }

    // Các method tiện ích 
    public boolean xacNhanMatKhau(String nhapLai) {
        return this.matKhau.equals(nhapLai);
    }

    public boolean doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (this.matKhau.equals(matKhauCu)) {
            this.matKhau = matKhauMoi;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TaiKhoan{tenDangNhap='" + tenDangNhap + "', vaiTro=" + vaiTro + "}";
    }
}