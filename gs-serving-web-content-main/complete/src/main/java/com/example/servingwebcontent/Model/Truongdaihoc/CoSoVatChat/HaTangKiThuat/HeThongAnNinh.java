package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.HaTangKiThuat;

//import com.example.servingwebcontent.Model.Truongdaihoc.HaTangKiThuat;

public class HeThongAnNinh implements HaTangKiThuat {
    private int soLuongCamera;
    private boolean coBaoChay;

    public HeThongAnNinh(int soLuongCamera, boolean coBaoChay) {
        this.soLuongCamera = soLuongCamera;
        this.coBaoChay = coBaoChay;
    }

    @Override
    public void xemThongTin() {
        System.out.println("Hệ thống an ninh | Camera: " + soLuongCamera +
                           " | Báo cháy: " + (coBaoChay ? "Có" : "Không"));
    }

    @Override
    public int danhGia() {
        return soLuongCamera / 10 + (coBaoChay ? 5 : 0);
    }
}
