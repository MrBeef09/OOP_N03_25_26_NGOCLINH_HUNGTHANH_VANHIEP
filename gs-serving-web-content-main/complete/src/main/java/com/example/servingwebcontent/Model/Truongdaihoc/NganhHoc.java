
package com.example.servingwebcontent.Model.Truongdaihoc;
import java.util.List;

public class NganhHoc {
    private String tenNganh;
    private String maNganh;
    private String toHopMon;
    private double diemChuan;
    private double coHoiViecLam;   // %
    private double luongTrungBinh; // triệu
    private int chiTieu;
    private int hoSo;
    private List<String> soThichLienQuan;

    // ===== Constructor =====
    public NganhHoc(String tenNganh, String maNganh, String toHopMon,
                    double diemChuan, double coHoiViecLam,
                    double luongTrungBinh, int chiTieu, int hoSo,
                    List<String> soThichLienQuan) {
        this.tenNganh = tenNganh;
        this.maNganh = maNganh;
        this.toHopMon = toHopMon;
        this.diemChuan = diemChuan;
        this.coHoiViecLam = coHoiViecLam;
        this.luongTrungBinh = luongTrungBinh;
        this.chiTieu = chiTieu;
        this.hoSo = hoSo;
        this.soThichLienQuan = soThichLienQuan;
    }

    // ===== Xem thông tin =====
    public void xemThongTin() {
        System.out.println(this.toString());
    }

    // ===== Tính điểm phù hợp cho học sinh =====
    public double tinhDiemNganh(double diemThiHS, String toHopHS, List<String> soThichHS) {
        double diem = 0;

        // 1. So sánh điểm thi so với điểm chuẩn
        if (diemThiHS >= diemChuan) {
            diem += 0.4;
        } else {
            diem += (diemThiHS / diemChuan) * 0.4;
        }

        // 2. Kiểm tra tổ hợp môn
        if (toHopMon.contains(toHopHS.trim())) {
            diem += 0.3;
        }

        // 3. Kiểm tra sở thích trùng khớp
        int match = 0;
        for (String st : soThichHS) {
            for (String lienQuan : soThichLienQuan) {
                if (st.trim().equalsIgnoreCase(lienQuan)) {
                    match++;
                }
            }
        }
        if (!soThichLienQuan.isEmpty()) {
            diem += ((double) match / soThichLienQuan.size()) * 0.3;
        }

        return diem;
    }

    // ===== Override toString =====
    @Override
    public String toString() {
        return "Ngành: " + tenNganh +
               " | Mã ngành: " + maNganh +
               " | Tổ hợp môn: " + toHopMon +
               " | Điểm chuẩn: " + diemChuan +
               " | Cơ hội việc làm: " + coHoiViecLam + "%" +
               " | Lương TB: " + luongTrungBinh + " triệu" +
               " | Chỉ tiêu: " + chiTieu +
               " | Hồ sơ: " + hoSo;
    }

    // ===== Getter (nếu cần dùng sau này) =====
    public String getTenNganh() { return tenNganh; }
    public String getMaNganh() { return maNganh; }
    public String getToHopMon() { return toHopMon; }
    public double getDiemChuan() { return diemChuan; }

    // ===== Thêm thuộc tính tạm để lưu điểm phù hợp =====
private transient double diemPhuHop; // transient để không bị JPA map vào DB

public double getDiemPhuHop() {
    return diemPhuHop;
}

public void setDiemPhuHop(double diemPhuHop) {
    this.diemPhuHop = diemPhuHop;
}

}
