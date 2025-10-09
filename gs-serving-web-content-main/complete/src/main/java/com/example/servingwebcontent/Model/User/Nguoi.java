//package User;
public abstract class Nguoi {
    private  String hoTen;
    private  int ngaySinh;
    private  String gioiTinh;

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
    public abstract void XemThongTin();
    
}
