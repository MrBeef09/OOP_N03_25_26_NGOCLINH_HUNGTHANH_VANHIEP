
public class GiaoVien extends Nguoi {
    private String MaGiaoVien;
    public Thongtincanhan ThongTinCaNhan;
    public Taikhoan TaiKhoan;
    public Truongdaihoc TruongCongTac;

    //getter setter
    public String SetMaGiaoVien(){
        return (Magiaovien);
    }
    public void SetMaGiaoVien(String MaGiaoVien) {
        if(Magiaovien.length() > 0){
            this.Magiaovien = Magiaovien;
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
            "Mã GV='" + Magiaovien + '\'' +
            ", Họ tên='" + getHoten() + '\'' +
            ", Ngày sinh=" + getNgaysinh() +
            ", Giới tính='" + getGioitinh() + '\'' +
            '}';
}

}
