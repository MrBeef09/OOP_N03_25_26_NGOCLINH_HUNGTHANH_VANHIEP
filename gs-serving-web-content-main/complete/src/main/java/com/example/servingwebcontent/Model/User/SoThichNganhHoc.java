public class SoThichNganhHoc {
    private String nganhQuanTam;
    private String soThich;
    private String taiNang;

    // getter setter
    public String getNganhQuanTam(){
        return nganhQuanTam;
    }
    
    public String getSoThich(){
        return soThich;
    }
    
    public String getTaiNang(){
        return taiNang;
    }
    public void setNganhQuanTam(String nganhQuanTam) {
        this.nganhQuanTam = nganhQuanTam;
    }
    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }
    public void setTaiNang(String taiNang) {
        this.taiNang = taiNang;
    }

    // method
    public void chonNganhHoc() {
        System.out.println("Bạn đã chọn ngành học: " + nganhQuanTam);

    }
    public void Xemsothich(){
        System.out.println("So thich: " + soThich);
        System.out.println("Tai nang: " + taiNang);
    }
}
