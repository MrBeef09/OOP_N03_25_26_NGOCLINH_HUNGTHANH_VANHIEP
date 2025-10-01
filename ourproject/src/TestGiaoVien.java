public class TestGiaoVien {
    public static void main(String[] args) {
        // Tạo đối tượng liên quan
        ThongTinCaNhan thongTin = new ThongTinCaNhan("Hà Nội", 123456789);
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.Dangky("123456", "giaovien1", "Admin");

        // Giả sử bạn đã có class TruongDaiHoc với constructor và getTenTruong()
        TruongDaiHoc truongDH = new TruongDaiHoc("DH001", "Đại học Bách Khoa Hà Nội");

        // Tạo đối tượng GiaoVien
        GiaoVien gv = new GiaoVien("GV001", thongTin, taiKhoan, truongDH);
        gv.setHoTen("Nguyễn Văn A");
        gv.setNgaySinh(1985);
        gv.setGioiTinh("Nam");

        // Gọi method xemThongTin
        System.out.println("=== Thông tin giáo viên ===");
        gv.xemThongTin();

        // Test đăng nhập
        System.out.println("\n=== Test đăng nhập ===");
        boolean login = gv.Dangnhap("123456", "giaovien1");
        System.out.println("Kết quả đăng nhập: " + login);

        // Test chọn trường đại học
        System.out.println("\n=== Test chọn trường đại học ===");
        gv.ChonTruongdaihoc();

        // Test gửi nhận xét học sinh
        System.out.println("\n=== Test gửi nhận xét ===");
        gv.GuiNhanxethocsinh("Cần chăm chỉ hơn trong học tập!");

        // Test xem danh sách học sinh
        System.out.println("\n=== Test xem danh sách học sinh ===");
        gv.XemDanhsachhocsinh();

        // Test cập nhật thông tin
        System.out.println("\n=== Test cập nhật thông tin ===");
        gv.CapnhatThongtin("Nguyễn Văn B", 1986, "Nam", thongTin);

        // In toString()
        System.out.println("\n=== Thông tin sau cập nhật ===");
        System.out.println(gv.toString());
    }
}

