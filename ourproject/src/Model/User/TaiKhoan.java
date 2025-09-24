public class TaiKhoan {
    private String TenDangNhap;
    private String MatKhau;
    private String VaiTro;

    //getter setter 
    public String getMatKhau(){
        return MatKhau;
    }
    public String getTenDangNhap(){
        return TenDangNhap;
    }
    public String getVaiTro(){
        return VaiTro;
    }
    public void setMatKhau(String MatKhau , String TenDangNhap ,String VaiTro){
        if (MatKhau != null && MatKhau.length() > 0 ){
            this.MatKhau = MatKhau;
        }
        if(TenDangNhap!= null && TenDangNhap.length() > 0){
            this.TenDangNhap = TenDangNhap;
        }
        if(VaiTro != null && VaiTro.equals("Hoc sinh") || VaiTro.equals("Admin")){
            this.VaiTro = VaiTro;
        }
    }


    // method
    public boolean Xacnhanmatkhau(String nhapLai){
        return this.MatKhau.equals(nhapLai);
    }
    public void Dangky(String matkhau,String tenDangnhap ,String vaiTro){
        setMatKhau(matkhau, tenDangnhap, vaiTro);
        System.out.println("Dang ky tai khoan thanh cong");
    }
    public boolean Dangnhap(String matkhau,String tenDangnhap){
        boolean check = false;
        while (!check){
            if(this.MatKhau.equals(matkhau) && this.TenDangNhap.equals(tenDangnhap)){
            System.out.println("Dang nhap thanh cong voi vai tro" + this.VaiTro);
            check = true;
            
        }
        else{
            System.out.println("Sai ten dang nhap hoac mat khau , vui long nhap lai");
        }
        }
        return check;
    }
    
    public boolean Doimatkhau(String MatKhauCu , String MatKhauMoi){
        if(this.MatKhau.equals(MatKhauCu)){
            this.MatKhau.equals(MatKhauMoi);
            System.out.println("Doi mat khau thanh cong");
            return true;
        }
        else{
            System.out.println("Mat khau cu khong dung");
            return false;
        }
    }
}
