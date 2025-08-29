public class Nguoi {
    private String Hoten;
    private int Ngaysinh;
    private String Gioitinh;

    //getter setter
    public String getHoten(){
        return Hoten;
    }
    public void setHoten(){
        this.Hoten = Hoten;
    }
    public int getNgaysinh(){
        return Ngaysinh;
    }
    public void setNgaysinh(){
        this.Ngaysinh = Ngaysinh;
    }
    public String getGioitinh(){
        return Gioitinh;
    }
    public void setGioitinh(){
        this.Gioitinh = Gioitinh;
    }

    //method
    public void xemThongtin(){
        System.out.println(Hoten);
        System.out.println(Ngaysinh);
        System.out.println(Gioitinh); 
    }
}