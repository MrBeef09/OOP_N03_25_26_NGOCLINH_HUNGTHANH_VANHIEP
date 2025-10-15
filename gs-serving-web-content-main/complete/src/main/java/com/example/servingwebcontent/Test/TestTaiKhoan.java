public class TestTaiKhoan {
    public static void main(String[] args) {
        // Tạo tài khoản mới
        TaiKhoan tk = new TaiKhoan();

        // Đăng ký
        System.out.println("=== Đăng ký tài khoản ===");
        tk.Dangky("123456", "user1", "Hoc sinh");

        // Xác nhận mật khẩu
        System.out.println("\n=== Xác nhận mật khẩu ===");
        boolean xacNhan = tk.Xacnhanmatkhau("123456");
        System.out.println("Mật khẩu đúng? " + xacNhan);

        // Đăng nhập đúng
        System.out.println("\n=== Đăng nhập (đúng) ===");
        boolean login1 = tk.Dangnhap("123456", "user1");
        System.out.println("Kết quả đăng nhập: " + login1);

        // Đăng nhập sai (sẽ yêu cầu nhập lại theo logic while)
        // Để test thực tế, bạn nên sửa method Dangnhap trong TaiKhoan để tránh vòng lặp vô hạn
        // Ở đây chỉ minh họa gọi thử
        // System.out.println("\n=== Đăng nhập (sai) ===");
        // boolean login2 = tk.Dangnhap("sai_pass", "user1");

        // Đổi mật khẩu
        System.out.println("\n=== Đổi mật khẩu ===");
        boolean doiMK = tk.Doimatkhau("123456", "654321");
        System.out.println("Kết quả đổi mật khẩu: " + doiMK);

        // Đăng nhập lại với mật khẩu mới
        System.out.println("\n=== Đăng nhập với mật khẩu mới ===");
        boolean login3 = tk.Dangnhap("654321", "user1");
        System.out.println("Kết quả đăng nhập: " + login3);
    }
}
