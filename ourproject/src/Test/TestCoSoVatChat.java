import java.util.ArrayList;
import java.util.List;

public class CoSoVatChat {
    private List<PhongHoc> dsPhongHoc;
    private List<KyTucXa> dsKTX;
    private List<ThuVien> dsThuVien;
    private List<TrangThietBi> dsTrangThietBi;
    private List<TienIch> dsTienIch;
    private List<HaTangKiThuat> dsHaTang;

    public CoSoVatChat() {
        dsPhongHoc = new ArrayList<>();
        dsKTX = new ArrayList<>();
        dsThuVien = new ArrayList<>();
        dsTrangThietBi = new ArrayList<>();
        dsTienIch = new ArrayList<>();
        dsHaTang = new ArrayList<>();
    }

    // ====== Thêm đối tượng ======
    public void themPhongHoc(PhongHoc p) { dsPhongHoc.add(p); }
    public void themKTX(KyTucXa k) { dsKTX.add(k); }
    public void themThuVien(ThuVien t) { dsThuVien.add(t); }
    public void themTrangThietBi(TrangThietBi tb) { dsTrangThietBi.add(tb); }
    public void themTienIch(TienIch ti) { dsTienIch.add(ti); }
    public void themHaTang(HaTangKiThuat ht) { dsHaTang.add(ht); }

    // ====== Xem thông tin toàn bộ ======
    public void xemThongTin() {
        System.out.println("===== DANH SÁCH PHÒNG HỌC =====");
        for (PhongHoc p : dsPhongHoc) {
            p.xemThongTin();
            System.out.println("Điểm: " + p.danhGia() + "\n");
        }

        System.out.println("===== DANH SÁCH KÝ TÚC XÁ =====");
        for (KyTucXa k : dsKTX) {
            k.xemThongTin();
            System.out.println("Điểm: " + k.danhGia() + "\n");
        }

        System.out.println("===== DANH SÁCH THƯ VIỆN =====");
        for (ThuVien t : dsThuVien) {
            t.xemThongTin();
            System.out.println("Điểm: " + t.danhGia() + "\n");
        }

        System.out.println("===== DANH SÁCH TRANG THIẾT BỊ =====");
        for (TrangThietBi tb : dsTrangThietBi) {
            tb.XemThongTin();
            System.out.println("Điểm: " + tb.DanhGia() + "\n");
        }

        System.out.println("===== DANH SÁCH TIỆN ÍCH =====");
        for (TienIch ti : dsTienIch) {
            ti.XemThongTin();
            System.out.println("Điểm: " + ti.DanhGia() + "\n");
        }

        System.out.println("===== DANH SÁCH HẠ TẦNG KỸ THUẬT =====");
        for (HaTangKiThuat ht : dsHaTang) {
            ht.hienThiThongTin();
            System.out.println("Điểm: " + ht.danhGia() + "\n");
        }
    }

    // ====== Tính tổng điểm ======
    public int tinhTongDiem() {
        int tong = 0;
        for (PhongHoc p : dsPhongHoc) tong += p.danhGia();
        for (KyTucXa k : dsKTX) tong += k.danhGia();
        for (ThuVien t : dsThuVien) tong += t.danhGia();
        for (TrangThietBi tb : dsTrangThietBi) tong += tb.DanhGia();
        for (TienIch ti : dsTienIch) tong += ti.DanhGia();
        for (HaTangKiThuat ht : dsHaTang) tong += ht.danhGia();
        return tong;
    }
}
