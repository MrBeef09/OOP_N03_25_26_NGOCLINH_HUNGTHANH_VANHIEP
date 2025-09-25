

public class TestTienIch {
    public static void main(String[] args) {
        TienIch canTin = new CanTin("CT01", 500);
        TienIch sanBong = new SanBong("Cỏ nhân tạo", 1000);
        TienIch beBoi = new BeBoi(250.0, 2.0);

        canTin.XemThongTin();
        sanBong.XemThongTin();
        beBoi.XemThongTin();

        System.out.println("Điểm căn tin: " + canTin.DanhGia());
        System.out.println("Điểm sân bóng: " + sanBong.DanhGia());
        System.out.println("Điểm bể bơi: " + beBoi.DanhGia());
    }
}
