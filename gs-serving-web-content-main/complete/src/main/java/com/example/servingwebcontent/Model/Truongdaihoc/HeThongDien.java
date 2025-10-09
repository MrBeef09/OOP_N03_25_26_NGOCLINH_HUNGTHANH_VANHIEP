package com.example.servingwebcontent.Model.Truongdaihoc;

public class HeThongDien implements HaTangKiThuat {
     private String congSuatToiDa;
    private int soLuongMayPhat;

    public HeThongDien(String congSuatToiDa, int soLuongMayPhat) {
        this.congSuatToiDa = congSuatToiDa;
        this.soLuongMayPhat = soLuongMayPhat;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Hệ thống điện | Công suất: " + congSuatToiDa +
                           " | Máy phát: " + soLuongMayPhat);
    }

    @Override
    public int danhGia() {
        return soLuongMayPhat * 2;
    }

}
