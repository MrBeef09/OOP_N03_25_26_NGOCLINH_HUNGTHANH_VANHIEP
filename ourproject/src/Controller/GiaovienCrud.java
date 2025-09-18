import java.util.ArrayList;
import java.util.List;

public class GiaovienCrud {
    private List<Giaovien> giaoviens = new ArrayList<>();

    // CREATE
    public void addGiaovien(Giaovien gv) {
        giaoviens.add(gv);
        System.out.println("Đã thêm giáo viên: " + gv);
    }

    // READ - xem toàn bộ danh sách
    public void getGiaoviens() {
        System.out.println("Danh sách giáo viên:");
        for (Giaovien gv : giaoviens) {
            System.out.println(gv);
        }
    }

    // READ - tìm theo mã giáo viên
    public Giaovien getByMagiaovien(String magiaovien) {
        for (Giaovien gv : giaoviens) {
            if (gv.getMagiaovien().equals(magiaovien)) {
                return gv;
            }
        }
        System.out.println("Không tìm thấy giáo viên có mã: " + magiaovien);
        return null;
    }

    // UPDATE - cập nhật thông tin (vd: trường công tác)
    public void updateTruongcongtac(String magiaovien, TruongDaiHoc newTruong) {
        Giaovien gv = getByMagiaovien(magiaovien);
        if (gv != null) {
            gv.Truongcongtac = newTruong;
            System.out.println("Đã cập nhật trường công tác cho giáo viên: " + gv.getMagiaovien());
        }
    }

    // DELETE - xóa giáo viên theo mã
    public void deleteGiaovien(String magiaovien) {
        Giaovien gv = getByMagiaovien(magiaovien);
        if (gv != null) {
            giaoviens.remove(gv);
            System.out.println("Đã xóa giáo viên có mã: " + magiaovien);
        }
    }
}