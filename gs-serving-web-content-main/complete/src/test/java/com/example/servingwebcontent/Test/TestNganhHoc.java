// temporarily disabled
/*
import java.util.*;

public class TestNganhHoc {
    public static void runTest() {
        // Danh sách ngành học
        NganhHoc cntt = new NganhHoc("Công nghệ thông tin", "CNTT01", "A00, A01", 25.0,
                                     95, 15, 500, 1000,
                                     Arrays.asList("lập trình", "toán", "máy tính"));

        NganhHoc kinhTe = new NganhHoc("Kinh tế", "KT01", "A00, D01", 24.5,
                                       90, 12, 300, 800,
                                       Arrays.asList("kinh doanh", "ngoại ngữ", "quản lý"));

        NganhHoc yKhoa = new NganhHoc("Y Khoa", "YK01", "B00", 27.0,
                                      98, 18, 200, 2000,
                                      Arrays.asList("sinh học", "hóa học", "chăm sóc"));

        List<NganhHoc> ds = Arrays.asList(cntt, kinhTe, yKhoa);

        // In danh sách ngành học
        System.out.println("===== DANH SÁCH NGÀNH HỌC =====");
        for (NganhHoc n : ds) {
            n.xemThongTin();
        }

        // Nhập dữ liệu HS
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập điểm thi của bạn: ");
        double diemThiHS = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhập tổ hợp môn (A00, A01, B00...): ");
        String toHopHS = sc.nextLine();

        System.out.print("Nhập sở thích của bạn (cách nhau bằng dấu phẩy): ");
        String soThichInput = sc.nextLine();
        List<String> soThichHS = Arrays.asList(soThichInput.split(","));

        // Tính điểm phù hợp cho từng ngành
        System.out.println("\n===== ĐÁNH GIÁ NGÀNH PHÙ HỢP =====");
        for (NganhHoc n : ds) {
            double diem = n.tinhDiemNganh(diemThiHS, toHopHS, soThichHS);
            System.out.println(n.getTenNganh() + " => Điểm phù hợp: " + diem);
        }
    }
}
*/
