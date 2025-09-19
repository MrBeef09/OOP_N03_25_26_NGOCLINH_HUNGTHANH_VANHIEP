import java.util.ArrayList;
import java.util.List;

// Lớp đối tượng GiaoVien
class GiaoVien {
    private int id;
    private String ten;
    private String monDay;

    public GiaoVien(int id, String ten, String monDay) {
        this.id = id;
        this.ten = ten;
        this.monDay = monDay;
    }

    // Getter & Setter
    public int getId() { return id; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public String getMonDay() { return monDay; }
    public void setMonDay(String monDay) { this.monDay = monDay; }

    @Override
    public String toString() {
        return "GiaoVien{id=" + id + ", ten='" + ten + "', monDay='" + monDay + "'}";
    }
}

// Lớp CRUD
public class GiaovienCrud {
    private List<GiaoVien> giaoviens = new ArrayList<>();

    // CREATE
    public void addGiaovien(GiaoVien gv) {
        giaoviens.add(gv);
        System.out.println("Đã thêm giáo viên: " + gv);
    }

    // READ - lấy thông tin giáo viên theo id
    public GiaoVien getGiaovienById(int id) {
        for (GiaoVien gv : giaoviens) {
            if (gv.getId() == id) {
                return gv;
            }
        }
        return null;
    }

    // UPDATE - sửa tên hoặc môn dạy
    public void updateGiaovien(int id, String newTen, String newMonDay) {
        GiaoVien gv = getGiaovienById(id);
        if (gv != null) {
            gv.setTen(newTen);
            gv.setMonDay(newMonDay);
            System.out.println("Đã cập nhật: " + gv);
        } else {
            System.out.println("Không tìm thấy giáo viên có id = " + id);
        }
    }

    // DELETE - xoá giáo viên theo id
    public void deleteGiaovien(int id) {
        GiaoVien gv = getGiaovienById(id);
        if (gv != null) {
            giaoviens.remove(gv);
            System.out.println("Đã xoá giáo viên: " + gv);
        } else {
            System.out.println("Không tìm thấy giáo viên có id = " + id);
        }
    }

    // READ ALL - in ra danh sách giáo viên
    public void getAllGiaoviens() {
        if (giaoviens.isEmpty()) {
            System.out.println("Danh sách giáo viên trống!");
        } else {
            System.out.println("Danh sách giáo viên:");
            for (GiaoVien gv : giaoviens) {
                System.out.println(gv);
            }
        }
    }
}
