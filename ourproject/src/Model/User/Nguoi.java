//package User;
public class Nguoi {
    private String HoTen;
    private int NgaySinh;
    private String GioiTinh;

    //getter setter
    public String GetHoTen(){
        return HoTen;
    }
    public void SetHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    public int GetNgaySinh(){
        return NgaySinh;
    }
    public void SetNgaySinh(int NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    public String getGioiTinh(){
        return GioiTinh;
    }
    public void SetGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    //method
    public void XemThongTin(){
        System.out.println("Ho va ten:" + HoTen);
        System.out.println("Ngay sinh:" + NgaySinh);
        System.out.println("Gioi tinh:" + GioiTinh); 
    }
    
}
