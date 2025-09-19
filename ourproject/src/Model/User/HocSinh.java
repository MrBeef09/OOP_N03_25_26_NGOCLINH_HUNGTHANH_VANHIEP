//package User;
public class HocSinh extends Nguoi {
    private String MaHocSinh;
    private ThongTinCaNhan ThongTinCaNhan;
    private KetQuaHocTap KetQuaHocTap;
    private SoThichNganhHoc SoThichNganhHoc;
    private TaiKhoan TaiKhoan;


    public HocSinh(String MaHocSinh, String HoTen , int NgaySinh , String GioiTinh){
        this.MaHocSinh = MaHocSinh;
        this.setHoTen(HoTen);
        this.setNgaySinh(NgaySinh);
        this.setGioiTinh(GioiTinh);
    }
    //getter setter
    public String getMaHocSinh(){
        return MaHocSinh;
    }
    public void setMahocsinh(String MaHocSinh) {
        if(MaHocSinh.length() > 0){
            this.MaHocSinh = MaHocSinh;
        }
    }


    //method
    public void Dangnhap(){}
    public void ChonTruongdaihoc(){}
    public void XemDanhsachTruongGoiY(){}
    @Override
public String toString() {
    return "Học sinh {" +
            "Mã HS='" + MaHocSinh + '\'' +
            ", Họ tên='" + getHoTen() + '\'' +
            ", Ngày sinh=" + getNgaySinh() +
            ", Giới tính='" + getGioiTinh() + '\'' +
            '}';
}

    
}
