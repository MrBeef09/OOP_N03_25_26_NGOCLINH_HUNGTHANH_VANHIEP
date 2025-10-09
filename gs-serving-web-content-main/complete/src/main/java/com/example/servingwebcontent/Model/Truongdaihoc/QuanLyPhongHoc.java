import java.util.ArrayList;

public class QuanLyPhongHoc {
    private ArrayList<PhongHoc> dsPhong = new ArrayList<>();

    // CREATE
    public void themPhong(PhongHoc p) {
        dsPhong.add(p);
    }

    // READ
    public void hienThiPhong() {
        for (PhongHoc p : dsPhong) {
            p.xemThongTin();
        }
    }

    // UPDATE
    public void suaSucChua(String maPhong, int sucChuaMoi) {
        for (PhongHoc p : dsPhong) {
            if (p.getMaPhong().equals(maPhong)) {
                // vì sucChua là protected, nên có thể viết setter để cập nhật
                System.out.println("Cập nhật sức chứa phòng " + maPhong);
                // giả sử ta thêm setter vào class PhongHoc
                // p.setSucChua(sucChuaMoi);
            }
        }
    }

    // DELETE
    public void xoaPhong(String maPhong) {
        dsPhong.removeIf(p -> p.getMaPhong().equals(maPhong));
    }
}
