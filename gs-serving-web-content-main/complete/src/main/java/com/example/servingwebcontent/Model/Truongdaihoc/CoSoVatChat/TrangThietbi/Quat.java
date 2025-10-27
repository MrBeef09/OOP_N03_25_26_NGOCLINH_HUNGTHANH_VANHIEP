package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.TrangThietbi;

public class Quat implements TrangThietBi {
    private int soLuong;

    public Quat(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public void xemThongTin() {
        System.out.println("Quạt | Số lượng: " + soLuong);
    }

    @Override
    public int danhGia() {
        return soLuong / 10; // cứ 10 quạt = 1 điểm
    }
}
