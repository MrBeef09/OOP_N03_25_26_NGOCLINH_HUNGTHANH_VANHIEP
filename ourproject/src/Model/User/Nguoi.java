//package User;
public class Nguoi {                                                           
    private String hoTen;
    private int ngaySinh;
    private String gioiTinh;

    //getter setter
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public int getNgaySinh(){
        return ngaySinh;
    }
    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getGioiTinh(){
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    //method
    public void XemThongTin(){
        System.out.println("Ho va ten:" + hoTen);
        System.out.println("Ngay sinh:" + ngaySinh);
        System.out.println("Gioi tinh:" + gioiTinh); 
    }
    
}
