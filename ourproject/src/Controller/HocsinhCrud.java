import java.util.ArrayList;
import java.util.List;

public class HocsinhCrud {
    private List<Hocsinh> Hocsinhs = new ArrayList<>();

    // CREATE
    public void addHocsinh(Hocsinh Hocsinh) {
        Hocsinhs.add(Hocsinh);
        System.out.println("Đã thêm học sinh: " + Hocsinh);
    }

    // READ all
    public void getHocsinh() {
        System.out.println("Danh sách học sinh:");
        for (Hocsinh s : Hocsinhs) {
            System.out.println(s);
        }
    }

    // READ by mã học sinh
    public Hocsinh getmaHocsinh(String maHocsinh) {
        for (Hocsinh s : Hocsinhs) {
            if (s.getMahocsinh().equals(maHocsinh)) { 
                return s;
            }
        }
        return null;
    }

    // UPDATE
    public void updateHocsinh(String maHocsinh, String newHoten, int newNgaysinh , String newGioitinh) {
        Hocsinh s = getmaHocsinh(maHocsinh);
        if (s != null) {
            s.setHoten(newHoten);
            s.setNgaysinh(newNgaysinh);
            s.setGioitinh(newGioitinh);
            System.out.println("Đã cập nhật: " + s);
        } else {
            System.out.println("Không tìm thấy học sinh có mã: " + maHocsinh);
        }
    }

    // DELETE
    public void deleteHocsinh(String maHocsinh) {
        Hocsinh s = getmaHocsinh(maHocsinh);
        if (s != null) {
            Hocsinhs.remove(s);
            System.out.println("Đã xóa học sinh: " + s);
        } else {
            System.out.println("Không tìm thấy học sinh có mã: " + maHocsinh);
        }
    }
}
