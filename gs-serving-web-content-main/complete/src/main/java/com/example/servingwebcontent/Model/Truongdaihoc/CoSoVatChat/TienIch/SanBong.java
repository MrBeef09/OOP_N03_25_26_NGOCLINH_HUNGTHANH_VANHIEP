package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.TienIch;

public class SanBong implements TienIch {
    private String LoaiSan;
    private int SucChua;

    public SanBong(String LoaiSan, int SucChua) {
        this.LoaiSan = LoaiSan;
        this.SucChua = SucChua;
    }

    public String GetLoaiSan() { return LoaiSan; }
    public int GetSucChua() { return SucChua; }

    @Override
    public void xemThongTin() {
        System.out.println("Sân bóng | Loại sân: " + LoaiSan +
                           " | Sức chứa: " + SucChua);
    }

    @Override
    public int danhGia() {
        return SucChua / 50; // cứ 50 chỗ ngồi = 1 điểm
    }
}
