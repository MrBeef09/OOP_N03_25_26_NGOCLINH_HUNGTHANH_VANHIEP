public class KetQuaHocTap {
    private float diemThi;
    private String hocLuc;
    private String toHopMon;

    //getter setter
    public float getDiemThi(){
        return diemThi;
    }
    public String getHocLuc(){
        return hocLuc;
    }
    public String getToHopMon(){
        return toHopMon;
    }
    public void setDiemThi(float diemThi){
        this.diemThi = diemThi;
    }
    public void setHocLuc(String hocLuc){
        this.hocLuc = hocLuc;
    }
    public void setToHopMon(String toHopMon){
        this.toHopMon = toHopMon;
    }
    
    //constructor
    public KetQuaHocTap(float DiemThi, String hocLuc, String toHopMon){
        this.diemThi = DiemThi;
        this.hocLuc = hocLuc;
        this.toHopMon = toHopMon;
    }
    //method 
    public void CapNhatDiemThi(float diemThi, String hocLuc, String toHopMon) {
        this.diemThi = diemThi;
        this.hocLuc = hocLuc;
        this.toHopMon = toHopMon;
    }
    public void Tinhhocluc(){}
}
