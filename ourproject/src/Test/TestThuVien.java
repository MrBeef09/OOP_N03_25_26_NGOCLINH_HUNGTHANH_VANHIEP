public class TestThuVien {
    public static void main(String[] args) {
        // Tạo một số thư viện để test
        ThuVien tv1 = new ThuVien("TV1", 12000, 100);
        ThuVien tv2 = new ThuVien("TV2", 5000, 40);
        ThuVien tv3 = new ThuVien("TV3", 20000, 300);

        // In thông tin và điểm đánh giá
        System.out.println("===== DANH SÁCH THƯ VIỆN =====");

        tv1.xemThongTin();
        System.out.println("Điểm đánh giá: " + tv1.danhGia() + "\n");

        tv2.xemThongTin();
        System.out.println("Điểm đánh giá: " + tv2.danhGia() + "\n");

        tv3.xemThongTin();
        System.out.println("Điểm đánh giá: " + tv3.danhGia() + "\n");
    }
}
