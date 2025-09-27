
public class TestHaTangKiThuat {
    public static void main(String[] args) {
        HaTangKiThuat dien = new HeThongDien("500kVA", 3);
        HaTangKiThuat nuoc = new HeThongNuoc(2000, 2);
        HaTangKiThuat internet = new MangInternet("VNPT", 500, 10);
        HaTangKiThuat anninh = new HeThongAnNinh(50, true);

        System.out.println("===== KIỂM TRA HẠ TẦNG KỸ THUẬT =====");

        dien.hienThiThongTin();
        System.out.println("Đánh giá: " + dien.danhGia() + "\n");

        nuoc.hienThiThongTin();
        System.out.println("Đánh giá: " + nuoc.danhGia() + "\n");

        internet.hienThiThongTin();
        System.out.println("Đánh giá: " + internet.danhGia() + "\n");

        anninh.hienThiThongTin();
        System.out.println("Đánh giá: " + anninh.danhGia() + "\n");

        int tongDiem = dien.danhGia() + nuoc.danhGia() + 
                       internet.danhGia() + anninh.danhGia();

        System.out.println(">>> Tổng điểm hạ tầng kỹ thuật: " + tongDiem);
    }
}

