package com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.TienIch;

public class BeBoi implements TienIch {
    private double DienTich;
    private double DoSau;

    public BeBoi(double DienTich, double DoSau) {
        this.DienTich = DienTich;
        this.DoSau = DoSau;
    }

    public double GetDienTich() { return DienTich; }
    public double GetDoSau() { return DoSau; }

    @Override
    public void xemThongTin() {
        System.out.println("Bể bơi | Diện tích: " + DienTich + " m2" +
                           " | Độ sâu: " + DoSau + " m");
    }

    @Override
    public int danhGia() {
        return (int)(DienTich / 50 + DoSau);
        // ví dụ: mỗi 50m2 được 1 điểm, cộng thêm số điểm bằng độ sâu
    }
}
