package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.TrangThietbi;

public class MayTinh implements TrangThietBi {
    private String CPU;
    private int RAM;
    private String oCung;

    public MayTinh(String CPU, int RAM, String oCung) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.oCung = oCung;
    }

    @Override
    public void xemThongTin() {
        System.out.println("Máy Tính | CPU: " + CPU +
                           " | RAM: " + RAM + "GB" +
                           " | Ổ cứng: " + oCung);
    }

    @Override
    public int danhGia() {
        return RAM / 4; // cứ 4GB RAM = 1 điểm
    }
}
