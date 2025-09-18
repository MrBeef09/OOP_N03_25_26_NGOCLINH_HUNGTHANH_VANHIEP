import java.util.ArrayList;
import java.util.List;

public class CoSoVatChat {
    private List<ThuVien> danhSachThuVien;
    private List<KyTucXa> danhSachKyTucXa;
    private List<HaTangKiThuat> danhSachHaTang;

    public CoSoVatChat() {
        this.danhSachThuVien = new ArrayList<>();
        this.danhSachKyTucXa = new ArrayList<>();
        this.danhSachHaTang = new ArrayList<>();
    }

    public void themThuVien(ThuVien tv) {
        danhSachThuVien.add(tv);
    }

    public void themKyTucXa(KyTucXa ktx) {
        danhSachKyTucXa.add(ktx);
    }

    public void themHaTang(HaTangKiThuat ht) {
        danhSachHaTang.add(ht);
    }

    public void xemThongTin() {
        System.out.println("=== Cơ sở vật chất ===");
        
        for (ThuVien tv : danhSachThuVien) {
            tv.xemThongTin();
            System.out.println(" -> Đánh giá: " + tv.danhGia());
        }

        for (KyTucXa ktx : danhSachKyTucXa) {
            ktx.xemThongTin();
            System.out.println(" -> Đánh giá: " + ktx.danhGia());
        }

        for (HaTangKiThuat ht : danhSachHaTang) {
            ht.hienThiThongTin();
            System.out.println(" -> Đánh giá: " + ht.danhGia());
        }

        System.out.println("Tổng đánh giá: " + tongDanhGia());
    }

    public int tongDanhGia() {
        int sum = 0;

        for (ThuVien tv : danhSachThuVien) sum += tv.danhGia();
        for (KyTucXa ktx : danhSachKyTucXa) sum += ktx.danhGia();
        for (HaTangKiThuat ht : danhSachHaTang) sum += ht.danhGia();

        return sum;
    }
}
