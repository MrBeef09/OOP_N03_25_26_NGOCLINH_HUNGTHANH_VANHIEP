public class MainTest {
    public static void main(String[] args) {
        // ===== HẠ TẦNG KỸ THUẬT =====
        HaTangKiThuat anNinh = new HeThongAnNinh(120, true);
        HaTangKiThuat dien = new HeThongDien("500kVA", 3);
        HaTangKiThuat nuoc = new HeThongNuoc(1000, 4);
        HaTangKiThuat internet = new MangInternet("VNPT", 500, 10);

        System.out.println("=== HẠ TẦNG KỸ THUẬT ===");
        anNinh.hienThiThongTin();
        System.out.println("Đánh giá: " + anNinh.danhGia());
        dien.hienThiThongTin();
        System.out.println("Đánh giá: " + dien.danhGia());
        nuoc.hienThiThongTin();
        System.out.println("Đánh giá: " + nuoc.danhGia());
        internet.hienThiThongTin();
        System.out.println("Đánh giá: " + internet.danhGia());

        // ===== PHÒNG HỌC =====
        PhongHoc lyThuyet = new PhongLyThuyet("LT101", 80, 60, 70);
        PhongHoc thiNghiem = new PhongThiNghiem("TN201", 40, 15, true);
        PhongHoc thucHanh = new PhongThucHanhMayTinh("TH301", 50, 35, true);

        System.out.println("\n=== PHÒNG HỌC ===");
        lyThuyet.xemThongTin();
        System.out.println("Đánh giá: " + lyThuyet.danhGia());
        thiNghiem.xemThongTin();
        System.out.println("Đánh giá: " + thiNghiem.danhGia());
        thucHanh.xemThongTin();
        System.out.println("Đánh giá: " + thucHanh.danhGia());

        // ===== THƯ VIỆN =====
        ThuVien tv = new ThuVien("TV01", 5000, 100);
        System.out.println("\n=== THƯ VIỆN ===");
        tv.xemThongTin();
        System.out.println("Đánh giá: " + tv.danhGia());

        // ===== KÝ TÚC XÁ =====
        KyTucXa ktx = new KyTucXa("KTX01", 200, 800);
        System.out.println("\n=== KÝ TÚC XÁ ===");
        ktx.xemThongTin();
        System.out.println("Đánh giá: " + ktx.danhGia());

        // ===== TRƯỜNG ĐẠI HỌC =====
        TruongDaiHoc truong = new TruongDaiHoc("TDH01", "Đại học Công Nghệ");

        truong.themPhongHoc(lyThuyet);
        truong.themPhongHoc(thiNghiem);
        truong.themPhongHoc(thucHanh);
        truong.themThuVien(tv);
        // giả sử có class GiaoVien và MayTinh thì thêm vào ở đây
        // truong.themGiaoVien(new GiaoVien(...));
        // truong.themMayTinh(new MayTinh(...));

        System.out.println("\n=== TRƯỜNG ĐẠI HỌC ===");
        System.out.println("Tên trường: " + truong.getTenTruong());
        System.out.println("Danh sách phòng học:");
        for (PhongHoc p : truong.getDanhSachPhongHoc()) {
            p.xemThongTin();
        }
        System.out.println("Danh sách thư viện:");
        for (ThuVien t : truong.getDanhSachThuVien()) {
            t.xemThongTin();
        }
    }
}
