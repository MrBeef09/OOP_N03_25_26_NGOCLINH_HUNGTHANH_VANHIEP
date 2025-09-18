
<<<<<<< HEAD:ourproject/src/Model/User/Giaovien.java
public class Giaovien extends Nguoi {
    private String Magiaovien;
    public Thongtincanhan Thongtincanhan;
    public Taikhoan Taikhoan;
    public TruongDaiHoc Truongcongtac;
=======
public class GiaoVien extends Nguoi {
    private String MaGiaoVien;
    public Thongtincanhan ThongTinCaNhan;
    public Taikhoan TaiKhoan;
    public Truongdaihoc TruongCongTac;
>>>>>>> 06fcf07374d75d1906fc8457a3d70ea1f0a2d74e:ourproject/src/Model/User/GiaoVien.java

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
