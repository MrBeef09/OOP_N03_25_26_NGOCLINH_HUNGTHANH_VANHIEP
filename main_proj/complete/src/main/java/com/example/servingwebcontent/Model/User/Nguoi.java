package com.example.servingwebcontent.Model.User;

import jakarta.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Nguoi {

    @Column(name = "ho_ten", nullable = false)
    private String hoTen;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    // 🔹 Constructors
    public Nguoi() {}

    public Nguoi(String hoTen, LocalDate ngaySinh, String gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    // 🔹 Getter / Setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    // 🔹 Phương thức trừu tượng: các lớp con phải override
    public abstract void xemThongTin();

    @Override
    public String toString() {
        return "Nguoi {" +
                "hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }
}
