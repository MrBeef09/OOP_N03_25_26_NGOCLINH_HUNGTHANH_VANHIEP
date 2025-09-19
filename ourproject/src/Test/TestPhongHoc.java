public class TestPhongHoc {
    public static void main(String[] args) {
        QuanLyPhongHoc ql = new QuanLyPhongHoc();

        // CREATE
        ql.themPhong(new PhongLyThuyet("LT101", 80, 50,100));
        ql.themPhong(new PhongThucHanhMayTinh("TH201",40,60,true));
        ql.themPhong(new PhongThiNghiem("TN301", 40, 60,true));

        System.out.println("=== Danh sách phòng sau khi thêm ===");
        ql.hienThiPhong();

        // UPDATE
        ql.suaSucChua("LT101", 100);

        System.out.println("=== Danh sách phòng sau khi cập nhật ===");
        ql.hienThiPhong();

        // DELETE
        ql.xoaPhong("TH201");

        System.out.println("=== Danh sách phòng sau khi xóa ===");
        ql.hienThiPhong();
    }
}

