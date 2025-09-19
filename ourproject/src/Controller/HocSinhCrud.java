import java.util.ArrayList;
import java.util.List;

public class HocSinhCrud {
    private List<HocSinh> Hocsinhs = new ArrayList<>();

    // CREATE
    public void addHocsinh(HocSinh Hocsinh) {
        Hocsinhs.add(Hocsinh);
        System.out.println("Đã thêm học sinh: " + Hocsinh);
    }

    // READ all
    public void getHocsinh() {
        System.out.println("Danh sách học sinh:");
        for (HocSinh s : Hocsinhs) {
            System.out.println(s);
        }
    }

    // READ by mã học sinh
    public HocSinh getmaHocsinh(String maHocsinh) {
        for (HocSinh s : Hocsinhs) {
            if (s.getMaHocSinh().equals(maHocsinh)) { 
                return s;
            }
        }
        return null;
    }

    // UPDATE
    public void updateHocsinh(String maHocsinh, String newHoten, int newNgaysinh , String newGioitinh) {
        HocSinh s = getmaHocsinh(maHocsinh);
        if (s != null) {
            s.setHoTen(newHoten);
            s.setNgaySinh(newNgaysinh);
            s.setGioiTinh(newGioitinh);
            System.out.println("Đã cập nhật: " + s);
        } else {
            System.out.println("Không tìm thấy học sinh có mã: " + maHocsinh);
        }
    }

    // DELETE
    public void deleteHocsinh(String maHocsinh) {
        HocSinh s = getmaHocsinh(maHocsinh);
        if (s != null) {
            Hocsinhs.remove(s);
            System.out.println("Đã xóa học sinh: " + s);
        } else {
            System.out.println("Không tìm thấy học sinh có mã: " + maHocsinh);
        }
    }
}
