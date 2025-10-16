package com.example.servingwebcontent.Model.Truongdaihoc;
public class ThuVien {
    private String maThuVien;
    private int soLuongSach;
    private int soLuongMayTinh;

    public ThuVien(String maThuVien, int soLuongSach, int soLuongMayTinh) {
        this.maThuVien = maThuVien;
        this.soLuongSach = soLuongSach;
        this.soLuongMayTinh = soLuongMayTinh;
    }

    public void xemThongTin() {
        System.out.println("Thư viện " + maThuVien +
                           " | Sách: " + soLuongSach +
                           " | Máy tính: " + soLuongMayTinh);
    }

    public int danhGia() {
        return (soLuongSach / 1000) + (soLuongMayTinh / 20);
    }
}
