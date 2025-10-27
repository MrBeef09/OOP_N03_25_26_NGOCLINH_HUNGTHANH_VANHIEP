package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.PhongHoc;

public class PhongThucHanhMayTinh extends PhongHoc {
    private int soMayTinh;
    private boolean coInternet;

    public PhongThucHanhMayTinh(String maPhong, int sucChua, int soMayTinh, boolean coInternet) {
        super(maPhong, sucChua);
        this.soMayTinh = soMayTinh;
        this.coInternet = coInternet;
    }

    @Override
    public int danhGia() {
        // Ví dụ: nếu có >= 30 máy và có internet thì +1 điểm
        return (soMayTinh >= 30 && coInternet) ? 1 : 0;
    }

    @Override
    public void xemThongTin() {
        super.xemThongTin();
        System.out.println("Số máy tính: " + soMayTinh + ", Có Internet: " + coInternet);
    }
}
