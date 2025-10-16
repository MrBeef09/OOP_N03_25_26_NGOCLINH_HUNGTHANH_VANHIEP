package com.example.servingwebcontent.Model.Truongdaihoc;
public class DoiNguGiaoVien {
    private int soLuongGV;
    private int soLuongTS; // số tiến sĩ
    private int soLuongThS; // số thạc sĩ
    private int kinhNghiemTB; // số năm kinh nghiệm trung bình

    // Constructor
    public DoiNguGiaoVien(int soLuongGV, int soLuongTS, int soLuongThS, int kinhNghiemTB) {
        this.soLuongGV = soLuongGV;
        this.soLuongTS = soLuongTS;
        this.soLuongThS = soLuongThS;
        this.kinhNghiemTB = kinhNghiemTB;
    }

    // Getter và Setter
    public int getSoLuongGV() {
        return soLuongGV;
    }

    public void setSoLuongGV(int soLuongGV) {
        this.soLuongGV = soLuongGV;
    }

    public int getSoLuongTS() {
        return soLuongTS;
    }

    public void setSoLuongTS(int soLuongTS) {
        this.soLuongTS = soLuongTS;
    }

    public int getSoLuongThS() {
        return soLuongThS;
    }

    public void setSoLuongThS(int soLuongThS) {
        this.soLuongThS = soLuongThS;
    }

    public int getKinhNghiemTB() {
        return kinhNghiemTB;
    }

    public void setKinhNghiemTB(int kinhNghiemTB) {
        this.kinhNghiemTB = kinhNghiemTB;
    }

    // Phương thức xem thông tin
    public void xemThongTin() {
        System.out.println("Giáo viên: " + soLuongGV +
                           " | TS: " + soLuongTS +
                           " | ThS: " + soLuongThS +
                           " | Kinh nghiệm TB: " + kinhNghiemTB + " năm");
    }

    // Phương thức đánh giá đội ngũ
    public int danhGia() {
        return (soLuongGV / 10) + (soLuongTS * 2) + (soLuongThS) + (kinhNghiemTB / 5);
    }
}