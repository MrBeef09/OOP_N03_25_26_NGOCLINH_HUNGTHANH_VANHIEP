package User;
public class Taikhoan {
    public String Tendangnhap;
    private String Matkhau;
    public String Vaitro;

    //getter setter 
    public String getMatkhau(){
        return (Matkhau);
    }
    public void setMatkhau(String Matkhau){
        if (Matkhau.length() > 0){
            this.Matkhau = Matkhau;
        }
    }


    // method
    public void Xacnhanmatkhau(){}
    public void Dangky(){}
    public void Dangnhap(){}
    public void Doimatkhau(){}
}
