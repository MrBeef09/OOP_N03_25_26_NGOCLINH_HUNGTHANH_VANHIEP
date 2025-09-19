import java.util.ArrayList;
import java.util.List;

public class GiaovienCrud {
    private List<GiaoVien> giaoviens = new ArrayList<>();

    // CREATE
    public void addGiaovien(GiaoVien gv) {
        giaoviens.add(gv);
        System.out.println("Đã thêm giáo viên: " + gv);
    }

    // READ - xem toàn bộ danh sách
    public void getGiaoviens() {
        System.out.println("Danh sách giáo viên:");
        for (GiaoVien gv : giaoviens) {
            System.out.println(gv);
        }
    }

    // READ - tìm theo mã giáo viên
    public GiaoVien getByMagiaovien(String magiaovien) {
        for (GiaoVien gv : giaoviens) {
            if (gv.getMaGiaoVien().equals(magiaovien)) {
                return gv;
            }
        }
        System.out.println("Không tìm thấy giáo viên có mã: " + magiaovien);
        return null;
    }

    // UPDATE - cập nhật thông tin (vd: trường công tác)
    public void updateTruongcongtac(String magiaovien, TruongDaiHoc newTruong) {
        GiaoVien gv = getByMagiaovien(magiaovien);
        if (gv != null) {
            gv.Truongcongtac = newTruong;
            System.out.println("Đã cập nhật trường công tác cho giáo viên: " + gv.getMagiaovien());
        }
    }

    // DELETE - xóa giáo viên theo mã
    public void deleteGiaovien(String magiaovien) {
        GiaoVien gv = getByMagiaovien(magiaovien);
        if (gv != null) {
            giaoviens.remove(gv);
            System.out.println("Đã xóa giáo viên có mã: " + magiaovien);
        }
    }
}