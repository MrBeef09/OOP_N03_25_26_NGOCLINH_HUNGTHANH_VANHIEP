public class DoiNguGiaoVien {
    private int soLuongGV;
    private int soLuongTS; // số tiến sĩ
    private int soLuongThS; // số thạc sĩ
    private int kinhNghiemTB; // số năm kinh nghiệm trung bình

    public DoiNguGiaoVien(int soLuongGV, int soLuongTS, int soLuongThS, int kinhNghiemTB) {
        this.soLuongGV = soLuongGV;
        this.soLuongTS = soLuongTS;
        this.soLuongThS = soLuongThS;
        this.kinhNghiemTB = kinhNghiemTB;
    }

    public void xemThongTin() {
        System.out.println("Giáo viên: " + soLuongGV +
                           " | TS: " + soLuongTS +
                           " | ThS: " + soLuongThS +
                           " | Kinh nghiệm TB: " + kinhNghiemTB + " năm");
    }

    public int danhGia() {
        // ví dụ: 1 điểm cho mỗi 10 GV
        // 2 điểm cho mỗi TS, 1 điểm cho mỗi ThS
        // + kinh nghiệm trung bình chia 5
        return (soLuongGV / 10) + (soLuongTS * 2) + (soLuongThS) + (kinhNghiemTB / 5);
    }
}
