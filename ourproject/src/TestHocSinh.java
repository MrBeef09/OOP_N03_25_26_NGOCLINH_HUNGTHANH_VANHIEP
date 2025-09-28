public class TestHocSinh {
    public static void main(String[] args) {
        // Tạo các đối tượng liên quan
        ThongTinCaNhan thongTin = new ThongTinCaNhan("Hà Nội", 987654321);
        KetQuaHocTap ketQua = new KetQuaHocTap(8.5f, "Giỏi", "A00");
        SoThichNganhHoc soThich = new SoThichNganhHoc();
        soThich.setNganhQuanTam("Công nghệ thông tin");
        soThich.setSoThich("Lập trình, máy tính");
        soThich.setTaiNang("Toán học");

        TaiKhoan tk = new TaiKhoan();
        tk.Dangky("hs123", "hocsinh1", "Hoc sinh");

        // Tạo đối tượng HocSinh
        HocSinh hs = new HocSinh("HS001", thongTin, ketQua, soThich, tk);
        hs.setHoTen("Trần Văn B");
        hs.setNgaySinh(2005);
        hs.setGioiTinh("Nam");

        // Test in thông tin học sinh
        System.out.println("=== Thông tin học sinh ===");
        System.out.println(hs.toString());

        // Test cập nhật thông tin cá nhân
        System.out.println("\n=== Cập nhật thông tin cá nhân ===");
        hs.CapNhatThongTinCaNhan("Trần Văn B", 2005, "Nam", "HS001", "TP.HCM", 123123123);

        // Test đăng nhập
        System.out.println("\n=== Test đăng nhập ===");
        boolean login = hs.dangNhap("hs123", "hocsinh1");
        System.out.println("Kết quả đăng nhập: " + login);

        // Test chọn trường đại học
        System.out.println("\n=== Chọn trường đại học ===");
        hs.chonTruongDaiHoc("DH001");

        // Test xem danh sách trường gợi ý
        System.out.println("\n=== Xem danh sách trường gợi ý ===");
        hs.xemDanhSachTruongGoiY();
    }
}

