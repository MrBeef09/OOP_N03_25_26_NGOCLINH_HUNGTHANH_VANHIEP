package com.example.servingwebcontent.Model.Truongdaihoc;

public class MangInternet implements HaTangKiThuat {
    private String nhaCungCap;
    private int tocDo; // Mbps
    private int soLuongRouter;

    public MangInternet(String nhaCungCap, int tocDo, int soLuongRouter) {
        this.nhaCungCap = nhaCungCap;
        this.tocDo = tocDo;
        this.soLuongRouter = soLuongRouter;
    }

    @Override
    public void xemThongTin() {
        System.out.println("Mạng Internet | Nhà cung cấp: " + nhaCungCap +
                           " | Tốc độ: " + tocDo + "Mbps" +
                           " | Router: " + soLuongRouter);
    }

    @Override
    public int danhGia() {
        return (tocDo / 100) + (soLuongRouter / 5);
    }
}
