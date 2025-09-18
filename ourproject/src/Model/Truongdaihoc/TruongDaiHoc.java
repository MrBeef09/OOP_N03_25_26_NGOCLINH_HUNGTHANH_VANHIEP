
import java.util.*;

public class TruongDaiHoc {
    private String maTruong;
    private String tenTruong;
    private List<PhongHoc> danhSachPhongHoc = new ArrayList<>();
    private List<ThuVien> danhSachThuVien = new ArrayList<>();
    private List<PhongThiNghiem> danhSachPTN = new ArrayList<>();
    private List<MayTinh> danhSachMayTinh = new ArrayList<>();
    private List<GiaoVien> danhSachGiaoVien = new ArrayList<>();

    public TruongDaiHoc(String maTruong, String tenTruong) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public List<PhongHoc> getDanhSachPhongHoc() { return danhSachPhongHoc; }
    public List<ThuVien> getDanhSachThuVien() { return danhSachThuVien; }
    public List<PhongThiNghiem> getDanhSachPTN() { return danhSachPTN; }
    public List<MayTinh> getDanhSachMayTinh() { return danhSachMayTinh; }
    public List<GiaoVien> getDanhSachGiaoVien() { return danhSachGiaoVien; }

    public void themPhongHoc(PhongHoc p) { danhSachPhongHoc.add(p); }
    public void themThuVien(ThuVien tv) { danhSachThuVien.add(tv); }
    public void themPhongThiNghiem(PhongThiNghiem ptn) { danhSachPTN.add(ptn); }
    public void themMayTinh(MayTinh mt) { danhSachMayTinh.add(mt); }
    public void themGiaoVien(GiaoVien gv) { danhSachGiaoVien.add(gv); }
}
