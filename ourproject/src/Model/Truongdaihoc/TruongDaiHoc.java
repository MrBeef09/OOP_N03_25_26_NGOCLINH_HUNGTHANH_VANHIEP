
import java.util.ArrayList;
import java.util.List;
import Model.GiaoVien;

public class TruongDaiHoc {
    private int maTruong;
    private String tenTruong;
    private String diaChi;
    private CoSoVatChat coSoVatChat;
    private List<GiaoVien> danhSachGiaoVien;
    private List<NganhHoc> danhSachNganhHoc;

    public TruongDaiHoc(int maTruong, String tenTruong, String diaChi) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.coSoVatChat = new CoSoVatChat(); // luôn có sẵn cơ sở vật chất
        this.danhSachGiaoVien = new ArrayList<>();
        this.danhSachNganhHoc = new ArrayList<>();
    }

    // ===== Getter =====
    public int getMaTruong() {
        return maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public CoSoVatChat getCoSoVatChat() {
        return coSoVatChat;
    }

    public List<GiaoVien> getDanhSachGiaoVien() {
        return danhSachGiaoVien;
    }

    public List<NganhHoc> getDanhSachNganhHoc() {
        return danhSachNganhHoc;
    }

    // ===== Method =====
    public void themGiaoVien(GiaoVien gv) {
        danhSachGiaoVien.add(gv);
    }

    public void themNganhHoc(NganhHoc nganh) {
        danhSachNganhHoc.add(nganh);
    }

    public void xemThongTin() {
        System.out.println("Mã trường: " + maTruong +
                           " | Tên trường: " + tenTruong +
                           " | Địa chỉ: " + diaChi);
        System.out.println("=== Danh sách giáo viên: ===");
        for (GiaoVien gv : danhSachGiaoVien) {
            gv.xemThongTin();
        }
        System.out.println("=== Danh sách ngành học: ===");
        for (NganhHoc ng : danhSachNganhHoc) {
            ng.xemThongTin();
        }
    }

    public void xemCoSoVatChat() {
        System.out.println("=== Cơ sở vật chất của trường ===");
        coSoVatChat.xemThongTin();
        System.out.println("Tổng điểm CSVC: " + coSoVatChat.tinhTongDiem());
    }
}
