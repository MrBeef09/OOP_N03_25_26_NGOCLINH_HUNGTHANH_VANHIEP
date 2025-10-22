package com.example.servingwebcontent.Model.Truongdaihoc;
public class MayChieu implements TrangThietBi {
    private String doPhanGiai;
    private String congSuat;

    public MayChieu(String doPhanGiai, String congSuat) {
        this.doPhanGiai = doPhanGiai;
        this.congSuat = congSuat;
    }

    @Override
    public void xemThongTin() {
        System.out.println("Máy Chiếu | Độ phân giải: " + doPhanGiai +
                           " | Công suất: " + congSuat);
    }

    @Override
    public int danhGia() {
        return 5; // ví dụ: mỗi máy chiếu cộng 5 điểm
    }
}
