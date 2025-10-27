package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.TienIch;

public class CanTin implements TienIch {
    private String MaCanTin;
    private int SucChua;

    public CanTin(String MaCanTin, int SucChua) {
        this.MaCanTin = MaCanTin;
        this.SucChua = SucChua;
    }

    public String GetMaCanTin() { return MaCanTin; }
    public int GetSucChua() { return SucChua; }

    @Override
    public void xemThongTin() {
        System.out.println("Căn tin | Mã: " + MaCanTin +
                           " | Sức chứa: " + SucChua);
    }

    @Override
    public int danhGia() {
        return SucChua / 100; // cứ 100 chỗ = 1 điểm
    }
}
