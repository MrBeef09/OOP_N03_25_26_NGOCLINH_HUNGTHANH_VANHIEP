
public class Giaovien {
    private String Magiaovien;
    public Thongtincanhan Thongtincanhan;
    public Taikhoan Taikhoan;
    public Truongdaihoc Truongcongtac;

    //getter setter
    public String getMagiaovien(){
        return (Magiaovien);
    }
    public void setMagiaovien(String Magiaovien) {
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
}
