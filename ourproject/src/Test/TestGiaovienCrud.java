public class TestGiaovienCrud {
    public static void main(String[] args) {
        GiaovienCrud crud = new GiaovienCrud();

        // Thêm giáo viên
        crud.addGiaovien(new GiaoVien(1, "Nguyen Van A", "Toán"));
        crud.addGiaovien(new GiaoVien(2, "Tran Thi B", "Văn"));

        // Xem tất cả
        crud.getAllGiaoviens();

        // Cập nhật
        crud.updateGiaovien(2, "Tran Thi B", "Ngữ Văn");

        // Tìm theo id
        System.out.println("Tìm id=1: " + crud.getGiaovienById(1));

        // Xoá
        crud.deleteGiaovien(1);

        // Xem tất cả sau khi xóa
        crud.getAllGiaoviens();
    }
}
