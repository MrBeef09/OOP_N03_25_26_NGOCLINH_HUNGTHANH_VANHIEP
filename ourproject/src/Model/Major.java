public class Major extends Universities {
    private int maNganh;
    private String tenNganh;   
    private int diemChuan;
    private int diemThi;

    // Getter & Setter
    public int getDiemChuan() {
        return diemChuan;
    }
    public void setDiemChuan(int diemChuan) {
        this.diemChuan = diemChuan;
    }

    public int getDiemThi() {
        return diemThi;
    }
    public void setDiemThi(int diemThi) {
        this.diemThi = diemThi;
    }

    public int getMaNganh() {
        return maNganh;
    }
    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }
    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    void kiemTra() {
        if (diemThi >= diemChuan) {
            System.out.println("Đậu ngành: " + tenNganh);
        } else {
            System.out.println("Trượt ngành: " + tenNganh);
        }
    }
}
