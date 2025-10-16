package com.example.servingwebcontent.Model.User;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;

    //getter setter 
    public String getMatKhau(){
        return matKhau;
    }
    public String getTenDangNhap(){
        return tenDangNhap;
    }
    public String getVaiTro(){
        return vaiTro;
    }
    public void setMatKhau(String matKhau , String tenDangNhap ,String vaiTro){
        if (matKhau != null && matKhau.length() > 0 ){
            this.matKhau = matKhau;
        }
        if(tenDangNhap!= null && tenDangNhap.length() > 0){
            this.tenDangNhap = tenDangNhap;
        }
        if(vaiTro != null && vaiTro.equals("Hoc sinh") || vaiTro.equals("Admin")){
            this.vaiTro = vaiTro;
        }
    }


    // method
    public boolean Xacnhanmatkhau(String nhapLai){
        return this.matKhau.equals(nhapLai);
    }
    public void Dangky(String matkhau,String tenDangnhap ,String vaiTro){
        setMatKhau(matkhau, tenDangnhap, vaiTro);
        System.out.println("Dang ky tai khoan thanh cong");
    }
    public boolean Dangnhap(String matkhau,String tenDangnhap){
        boolean check = false;
        while (!check){
            if(this.matKhau.equals(matkhau) && this.tenDangNhap.equals(tenDangnhap)){
            System.out.println("Dang nhap thanh cong voi vai tro" + this.vaiTro);
            check = true;
            
        }
        else{
            System.out.println("Sai ten dang nhap hoac mat khau , vui long nhap lai");
        }
        }
        return check;
    }
    
    public boolean Doimatkhau(String MatKhauCu , String MatKhauMoi){
        if(this.matKhau.equals(MatKhauCu)){
            this.matKhau.equals(MatKhauMoi);
            System.out.println("Doi mat khau thanh cong");
            return true;
        }
        else{
            System.out.println("Mat khau cu khong dung");
            return false;
        }
    }
}
