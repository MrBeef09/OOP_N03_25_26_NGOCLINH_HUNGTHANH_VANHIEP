public class PhongThiNghiem extends PhongHoc {
    private int soDungCu;
    private boolean tieuChuanAnToan;

    public PhongThiNghiem(String maPhong, int sucChua, int soDungCu, boolean tieuChuanAnToan) {
        super(maPhong, sucChua);
        this.soDungCu = soDungCu;
        this.tieuChuanAnToan = tieuChuanAnToan;
    }

    @Override
    public int danhGia() {
        return (soDungCu >= 10 && tieuChuanAnToan) ? 1 : 0;
    }

    @Override
    public void xemThongTin() {
        super.xemThongTin();
        System.out.println("Số dụng cụ: " + soDungCu + ", An toàn: " + tieuChuanAnToan);
    }
}
