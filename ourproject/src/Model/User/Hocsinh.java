package User;
public class Hocsinh {
    private String Mahocsinh;
    public Thongtincanhan Thongtincanhan;
    public Ketquahoctap Ketquahoctap;
    public Sothichnganhhoc Sothichnganhhoc;
    public Taikhoan Taikhoan;

    //getter setter
    public String Mahocsinh(){
        return (Mahocsinh);
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
}
