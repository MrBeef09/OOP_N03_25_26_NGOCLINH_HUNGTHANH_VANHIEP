
public class GiaoVien extends Nguoi {
    private String MaGiaoVien;
    private ThongTinCaNhan ThongTinCaNhan;
    private TaiKhoan TaiKhoan;
    private TruongDaiHoc TruongCongTac;

    //getter setter
    public String getMaGiaoVien(){
        return MaGiaoVien;
    }
    public void SetMaGiaoVien(String MaGiaoVien) {
        if(MaGiaoVien.length() > 0){
            this.MaGiaoVien = MaGiaoVien;
        }
    }

    //method
    public void Dangnhap(){}
    public void ChonTruongdaihoc(){}
    public void GuiNhanxethocsinh(){}
    public void XemDanhsachhocsinh(){}
    public void CapnhatThongtin(){}
    @Override
public String toString() {
    return "Giáo viên {" +
            "Mã GV='" + MaGiaoVien + '\'' +
            ", Họ tên='" + getHoTen() + '\'' +
            ", Ngày sinh=" + getNgaySinh() +
            ", Giới tính='" + getGioiTinh() + '\'' +
            '}';
}

}
