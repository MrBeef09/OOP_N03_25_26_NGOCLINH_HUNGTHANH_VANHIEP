
public class GiaoVien extends Nguoi {
    private String maGiaoVien;
    private ThongTinCaNhan thongTinCaNhan;
    private TaiKhoan taiKhoan;
    private TruongDaiHoc truongCongTac;

    //constructor
    public GiaoVien(String maGiaoVien, ThongTinCaNhan thongTinCaNhan, TaiKhoan taiKhoan, TruongDaiHoc truongCongTac) {
        this.maGiaoVien = maGiaoVien;
        this.thongTinCaNhan = thongTinCaNhan;
        this.taiKhoan = taiKhoan;
        this.truongCongTac = truongCongTac;
    }   

    //getter setter
    public String getMaGiaoVien(){
        return maGiaoVien;
    }
    public void SetMaGiaoVien(String maGiaoVien){
        if(maGiaoVien.length() > 0){
            this.maGiaoVien = maGiaoVien;
        }
    }

    //method
    public boolean Dangnhap(String passWord, String username){
        if(taiKhoan != null){
            return taiKhoan.Dangnhap(passWord, username);
        }
        return false;
    }
    public void XemThongTin(){
        System.out.println("ma giao vien: " + maGiaoVien +
                           " | ho ten: " + getHoTen() +
                           " | ngay sinh: " + getNgaySinh() +
                           " | gioi tinh: " + getGioiTinh());
    }
    
    public void ChonTruongdaihoc(){}
    public void GuiNhanxethocsinh(){}
    public void XemDanhsachhocsinh(){}
    public void CapnhatThongtin(){}
    @Override
public String toString() {
    return "Giáo viên {" +
            "Mã GV='" + maGiaoVien + '\'' +
            ", Họ tên='" + getHoTen() + '\'' +
            ", Ngày sinh=" + getNgaySinh() +
            ", Giới tính='" + getGioiTinh() + '\'' +
            '}';
}

}
