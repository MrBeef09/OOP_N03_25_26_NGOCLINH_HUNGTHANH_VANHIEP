//package User;
public class Nguoi {
    private String HoTen;
    private int NgaySinh;
    private String GioiTinh;

    //getter setter
    public String getHoTen(){
        return HoTen;
    }
    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    public int getNgaySinh(){
        return NgaySinh;
    }
    public void setNgaySinh(int NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    public String getGioiTinh(){
        return GioiTinh;
    }
    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    //method
    public void XemThongTin(){
        System.out.println("Ho va ten:" + HoTen);
        System.out.println("Ngay sinh:" + NgaySinh);
        System.out.println("Gioi tinh:" + GioiTinh); 
    }
    
}
