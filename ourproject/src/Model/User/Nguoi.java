//package User;
public class Nguoi {
    private String Hoten;
    private int Ngaysinh;
    private String Gioitinh;

    //getter setter
    public String getHoten(){
        return Hoten;
    }
    public int getNgaysinh(){
        return Ngaysinh;
    }
    public String getGioitinh(){
        return Gioitinh;
    }

    public void setNguoi(String Hoten , int Ngaysinh , String Gioitinh){
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Gioitinh = Gioitinh;
    }

    //method
    public void xemThongtin(){
        System.out.println("Ho va ten:" + Hoten);
        System.out.println("Ngay sinh:" + Ngaysinh);
        System.out.println("Gioi tinh:" + Gioitinh); 
    }
}