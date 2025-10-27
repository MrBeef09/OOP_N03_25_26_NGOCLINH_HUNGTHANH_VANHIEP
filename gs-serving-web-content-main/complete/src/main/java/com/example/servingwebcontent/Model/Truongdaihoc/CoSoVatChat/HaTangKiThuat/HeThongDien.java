package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.HaTangKiThuat;

//import com.example.servingwebcontent.Model.Truongdaihoc.HaTangKiThuat;

public class HeThongDien implements HaTangKiThuat {
     private String congSuatToiDa;
    private int soLuongMayPhat;

    public HeThongDien(String congSuatToiDa, int soLuongMayPhat) {
        this.congSuatToiDa = congSuatToiDa;
        this.soLuongMayPhat = soLuongMayPhat;
    }

    @Override
    public void xemThongTin() {
        System.out.println("Hệ thống điện | Công suất: " + congSuatToiDa +
                           " | Máy phát: " + soLuongMayPhat);
    }

    @Override
    public int danhGia() {
        return soLuongMayPhat * 2;
    }

}
