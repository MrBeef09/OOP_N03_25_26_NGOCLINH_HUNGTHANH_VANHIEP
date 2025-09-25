//package User;
public class ThongTinCaNhan {
    private String diaChi;
    private int soDienThoai;

    // getter setter
    public String getDiaChi(){
        return diaChi;
    }
    public int getSoDienThoai(){
        return soDienThoai;
    }
    public void setDiaChi(String DiaChi) {
        this.diaChi = diaChi;
    }
    public void setSoDienthoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    //constructor
    public ThongTinCaNhan(String diaChi, int soDienThoai) {
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
    // method
    public void CapNhatThongTin(String diaChi, int soDienThoai) {
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
    public void Xemthongtin(){
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + soDienThoai);
    }
}
