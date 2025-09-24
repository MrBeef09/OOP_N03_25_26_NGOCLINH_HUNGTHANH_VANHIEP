public class TestKyTucXa {
    public static void main(String[] args) {
        // Tạo một số ký túc xá để test
        KyTucXa ktx1 = new KyTucXa("KTX1", 200, 1500);
        KyTucXa ktx2 = new KyTucXa("KTX2", 100, 800);
        KyTucXa ktx3 = new KyTucXa("KTX3", 300, 2500);

        // In thông tin và điểm đánh giá
        System.out.println("===== DANH SÁCH KÝ TÚC XÁ =====");

        ktx1.xemThongTin();
        System.out.println("Điểm đánh giá: " + ktx1.danhGia() + "\n");

        ktx2.xemThongTin();
        System.out.println("Điểm đánh giá: " + ktx2.danhGia() + "\n");

        ktx3.xemThongTin();
        System.out.println("Điểm đánh giá: " + ktx3.danhGia() + "\n");
    }
}
