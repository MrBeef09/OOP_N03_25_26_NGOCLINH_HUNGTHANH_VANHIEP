public class Taikhoan {
    private String Tendangnhap;
    private String Matkhau;
    private String Vaitro;

    //getter setter 
    public String getMatkhau(){
        return Matkhau;
    }
    public String getTendangnhap(){
        return Tendangnhap;
    }
    public String getVaitro(){
        return Vaitro;
    }
    public void setMatkhau(String Matkhau , String Tendangnhap ,String Vaitro){
        if (Matkhau != null && Matkhau.length() > 0 ){
            this.Matkhau = Matkhau;
        }
        if(Tendangnhap!= null && Tendangnhap.length() > 0){
            this.Tendangnhap = Tendangnhap;
        }
        if(Vaitro != null && Vaitro.equals("Hoc sinh") || Vaitro.equals("Admin")){
            this.Vaitro = Vaitro;
        }
    }


    // method
    public boolean Xacnhanmatkhau(String nhapLai){
        return this.Matkhau.equals(nhapLai);
    }
    public void Dangky(String matkhau,String tenDangnhap ,String vaiTro){
        setMatkhau(matkhau, tenDangnhap, vaiTro);
        System.out.println("Dang ky tai khoan thanh cong");
    }
    public void Dangnhap(String matkhau,String tenDangnhap){
        if(this.Matkhau.equals(matkhau) && this.Tendangnhap.equals(tenDangnhap)){
            System.out.println("Dang nhap thanh cong voi vai tro" + this.Vaitro);
        }
        else{
            System.out.println("Sai ten dang nhap hoac mat khau , vui long nhap lai");
        }
    }
    public boolean Doimatkhau(String matkhauCu , String matkhauMoi){
        if(this.Matkhau.equals(matkhauCu)){
            this.Matkhau.equals(matkhauMoi);
            System.out.println("Doi mat khau thanh cong");
            return true;
        }
        else{
            System.out.println("Mat khau cu khong dung");
            return false;
        }
    }
}
