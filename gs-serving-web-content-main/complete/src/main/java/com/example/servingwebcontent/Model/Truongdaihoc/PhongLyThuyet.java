    public class PhongLyThuyet extends PhongHoc {
    private int soBan;
    private int soGhe;

    public PhongLyThuyet(String maPhong, int sucChua, int soBan, int soGhe) {
        super(maPhong, sucChua);
        this.soBan = soBan;
        this.soGhe = soGhe;
    }

    @Override
    public int danhGia() {
        return (soBan > 50 && soGhe > 50) ? 1 : 0;
    }

    @Override
    public void xemThongTin() {
        super.xemThongTin();
        System.out.println("Số bàn: " + soBan + ", Số ghế: " + soGhe);
    }
}


