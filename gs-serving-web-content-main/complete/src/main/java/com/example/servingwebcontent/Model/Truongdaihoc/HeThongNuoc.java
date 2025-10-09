package com.example.servingwebcontent.Model.Truongdaihoc;
public class HeThongNuoc implements HaTangKiThuat{
    private int sucChuaBeNuoc; // đơn vị: m3
    private int soLuongMayBom;

    public HeThongNuoc(int sucChuaBeNuoc, int soLuongMayBom) {
        this.sucChuaBeNuoc = sucChuaBeNuoc;
        this.soLuongMayBom = soLuongMayBom;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Hệ thống nước | Bể chứa: " + sucChuaBeNuoc + " m3" +
                           " | Máy bơm: " + soLuongMayBom);
    }

    @Override
    public int danhGia() {
        return (sucChuaBeNuoc / 100) + soLuongMayBom;
    }
}
