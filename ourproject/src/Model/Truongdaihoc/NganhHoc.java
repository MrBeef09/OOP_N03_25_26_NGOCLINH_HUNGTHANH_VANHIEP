
public class NganhHoc {
    private String tenNganh;
    private String maNganh;
    private String toHopMon;
    private double diemChuan;

    public NganhHoc(String tenNganh, String maNganh, String toHopMon, double diemChuan) {
        this.tenNganh = tenNganh;
        this.maNganh = maNganh;
        this.toHopMon = toHopMon;
        this.diemChuan = diemChuan;
    }

    // Getter
    public String getTenNganh() {
        return tenNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public String getToHopMon() {
        return toHopMon;
    }

    public double getDiemChuan() {
        return diemChuan;
    }

    // Method xemThongTin
    public String xemThongTin() {
        return "Ngành: " + tenNganh +
               " | Mã: " + maNganh +
               " | Tổ hợp môn: " + toHopMon +
               " | Điểm chuẩn: " + diemChuan;
    }

    // Method kiemTraPhuHop
    public String kiemTraPhuHop(double diemThi) {
        if (diemThi >= diemChuan) {
            return "Phù hợp: Có thể đăng ký ngành " + tenNganh;
        } else {
            return "Không phù hợp: Chưa đủ điểm vào ngành " + tenNganh;
        }
    }
}
