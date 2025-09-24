//package User;
public class HocSinh extends Nguoi {
    private String maHocSinh;
    private ThongTinCaNhan thongTinCaNhan;
    private KetQuaHocTap ketQuaHocTap;
    private SoThichNganhHoc soThichNganhHoc;
    private TaiKhoan taiKhoan;

    //constructor
    public HocSinh(String maHocSinh, ThongTinCaNhan thongTinCaNhan,
                   KetQuaHocTap ketQuaHocTap, SoThichNganhHoc soThichNganhHoc,
                   TaiKhoan taiKhoan) {
        this.maHocSinh = maHocSinh;
        this.thongTinCaNhan = thongTinCaNhan;
        this.ketQuaHocTap = ketQuaHocTap;
        this.soThichNganhHoc = soThichNganhHoc;
        this.taiKhoan = taiKhoan;
    }

    //getter setter
    public String getMaHocSinh(){
        return maHocSinh;
    }
    public void setMaHocSinh(String maHocSinh) {
        if (maHocSinh != null && !maHocSinh.trim().isEmpty()) {
            this.maHocSinh = maHocSinh;
        }
    }

    //method
    public boolean dangNhap(String password, String username) {
    if (taiKhoan != null) {
        return taiKhoan.Dangnhap(password, username);
    }
    return false; 
   }

    public void chonTruongDaiHoc(String maTruong) {
        System.out.println(getHoTen() + " đã chọn trường có mã: " + maTruong);
    }

    public void xemDanhSachTruongGoiY() {
        System.out.println("Danh sach truong goi y cho hoc sinh " + getHoTen() + ":");
        if (soThichNganhHoc != null) {
            System.out.println("- Goi y dua theo nganh: " + soThichNganhHoc.getNganhQuanTam());
        } else {
            System.out.println("- Hien chua có du lieu ve so thich nganh hoc.");
        }
        if (ketQuaHocTap != null) {
            System.out.println("- Goi y dua theo điểm thi: " + ketQuaHocTap.getDiemThi());
        } else {
            System.out.println("- Hien chua có du lieu ve diem thi.");
        }
        if (soThichNganhHoc.getTaiNang() != null) {
            System.out.println("- Goi y dua theo tai nang: " + soThichNganhHoc.getTaiNang());
        } else {
            System.out.println("- Hien chua có du lieu ve tai nang.");
            
        }
    }
    @Override
public String toString() {
    return "Học sinh {" +
            "Mã HS='" + maHocSinh + '\'' +
            ", Họ tên='" + getHoTen() + '\'' +
            ", Ngày sinh=" + getNgaySinh() +
            ", Giới tính='" + getGioiTinh() + '\'' +
            '}';
}

    
}
