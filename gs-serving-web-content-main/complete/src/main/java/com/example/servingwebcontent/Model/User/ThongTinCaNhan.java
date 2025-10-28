package com.example.servingwebcontent.Model.User;

import jakarta.persistence.Embeddable;

@Embeddable
public class ThongTinCaNhan {
    private String diaChi;
    private String soDienThoai;

    public ThongTinCaNhan() {}

    public ThongTinCaNhan(String diaChi, String soDienThoai) {
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
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

    public void capNhatThongTin(String diaChiMoi, String sdtMoi) {
        if (diaChiMoi != null && !diaChiMoi.isEmpty()) this.diaChi = diaChiMoi;
        if (sdtMoi != null && !sdtMoi.isEmpty()) this.soDienThoai = sdtMoi;
    }

    @Override
    public String toString() {
        return "ThongTinCaNhan{" +
                "diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
