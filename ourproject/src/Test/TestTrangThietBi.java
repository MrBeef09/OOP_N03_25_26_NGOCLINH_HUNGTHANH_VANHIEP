
public class TestTrangThietBi {
    public static void main(String[] args) {
        TrangThietBi mayChieu = new MayChieu("Full HD", "300W");
        TrangThietBi mayTinh = new MayTinh("Intel i7", 16, "512GB SSD");
        TrangThietBi dieuHoa = new DieuHoa("12000 BTU", 5);
        TrangThietBi quat = new Quat(30);

        mayChieu.XemThongTin();
        mayTinh.XemThongTin();
        dieuHoa.XemThongTin();
        quat.XemThongTin();

        System.out.println("Điểm máy chiếu: " + mayChieu.DanhGia());
        System.out.println("Điểm máy tính: " + mayTinh.DanhGia());
        System.out.println("Điểm điều hòa: " + dieuHoa.DanhGia());
        System.out.println("Điểm quạt: " + quat.DanhGia());
    }
}
