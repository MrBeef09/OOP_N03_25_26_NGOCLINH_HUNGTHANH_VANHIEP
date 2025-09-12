//package User;
public class Hocsinh extends Nguoi {
    private String Mahocsinh;
    public Thongtincanhan Thongtincanhan;
    public Ketquahoctap Ketquahoctap;
    public Sothichnganhhoc Sothichnganhhoc;
    public Taikhoan Taikhoan;


    public Hocsinh(String Mahocsinh, String Hoten , int Ngaysinh , String Gioitinh){
        this.Mahocsinh = Mahocsinh;
        this.setHoten(Hoten);
        this.setNgaysinh(Ngaysinh);
        this.setGioitinh(Gioitinh);
    }
    //getter setter
    public String getMahocsinh(){
        return Mahocsinh;
    }
    public void setMahocsinh(String mahocsinh) {
        if(Mahocsinh.length() > 0){
            this.Mahocsinh = Mahocsinh;
        }
    }


    //method
    public void Dangnhap(){}
    public void ChonTruongdaihoc(){}
    public void XemDanhsachTruongGoiY(){}
    @Override
public String toString() {
    return "Học sinh {" +
            "Mã HS='" + Mahocsinh + '\'' +
            ", Họ tên='" + getHoten() + '\'' +
            ", Ngày sinh=" + getNgaysinh() +
            ", Giới tính='" + getGioitinh() + '\'' +
            '}';
}

    
}
