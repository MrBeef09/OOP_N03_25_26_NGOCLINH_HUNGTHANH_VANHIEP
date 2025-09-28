
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
    public void xemThongTin(){
        System.out.println("ma giao vien: " + maGiaoVien +
                           " | ho ten: " + getHoTen() +
                           " | ngay sinh: " + getNgaySinh() +
                           " | gioi tinh: " + getGioiTinh());
    }
    
    public void ChonTruongdaihoc(){
        if(truongCongTac != null){
            System.out.println("Giao vien" + getHoTen() + "da chon tuỏng dai hoc:" + truongCongTac.getTenTruong());
        }
        else{
            System.out.println("Giao vien" + getHoTen() + "chua co truong dai hoc cong tac.");
        }
    }
    public void GuiNhanxethocsinh(String nhanXet){
        System.out.println("Giao vien " + getHoTen() + " gui nhan xet: " + nhanXet);
    }
    public void XemDanhsachhocsinh(){
        System.out.println("Giao vien " + getHoTen() + " xem danh sach hoc sinh.");
    }
    public void CapnhatThongtin(String hoTen , int ngaySinh, String gioiTinh, ThongTinCaNhan thongTinCaNhan){
        if (thongTinCaNhan != null) {
            thongTinCaNhan.CapNhatThongTin(thongTinCaNhan.getDiaChi(), thongTinCaNhan.getSoDienThoai());
        } 
        else{
            System.out.println("Thong tin ca nhan chua duoc khoi tao.");
        }
        this.setHoTen(hoTen);
        this.setNgaySinh(ngaySinh);
        this.setGioiTinh(gioiTinh);
        System.out.println("Giao vien " + getHoTen() + " da cap nhat thong tin.");
    }
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
<<<<<<< HEAD
=======

>>>>>>> origin/main
