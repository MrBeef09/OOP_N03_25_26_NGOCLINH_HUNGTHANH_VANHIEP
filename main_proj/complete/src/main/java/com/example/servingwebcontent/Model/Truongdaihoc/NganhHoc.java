package com.example.servingwebcontent.Model.Truongdaihoc;

import java.text.Normalizer;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nganh_hoc")
public class NganhHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_nganh", nullable = false)
    private String tenNganh;

    @Column(name = "ma_nganh", nullable = false, unique = true)
    private String maNganh;

    @Column(name = "to_hop_mon")
    private String toHopMon;

    @Column(name = "diem_phu_hop")
    private double diemPhuHop;

    @Column(name = "diem_chuan")
    private double diemChuan;

    @Column(name = "co_hoi_viec_lam")
    private double coHoiViecLam;   // %

    @Column(name = "luong_trung_binh")
    private double luongTrungBinh; // triệu

    @Column(name = "nhu_cau_tuyen_dung")
    private int nhuCauTuyenDung;

    @Column(name = "ho_so")
    private int hoSo;

   @ElementCollection
@CollectionTable(
    name = "so_thich_lien_quan",
    joinColumns = @JoinColumn(name = "nganh_id")
)
@Column(name = "so_thich")
@OrderColumn(name = "id") // thêm dòng này để Hibernate tạo cột id làm khóa chính
private List<String> soThichLienQuan;


    // ===== Constructor =====
    public NganhHoc() {}

    public NganhHoc(String tenNganh, String maNganh, String toHopMon,
                    double diemChuan, double coHoiViecLam,
                    double luongTrungBinh, int nhuCauTuyenDung, int hoSo,
                    List<String> soThichLienQuan) {
        this.tenNganh = tenNganh;
        this.maNganh = maNganh;
        this.toHopMon = toHopMon;
        this.diemChuan = diemChuan;
        this.coHoiViecLam = coHoiViecLam;
        this.luongTrungBinh = luongTrungBinh;
        this.nhuCauTuyenDung = nhuCauTuyenDung;
        this.hoSo = hoSo;
        this.soThichLienQuan = soThichLienQuan;
    }

    // ===== Xem thông tin =====
    public void xemThongTin() {
        System.out.println(this.toString());
    }
    // chuẩn hóa chuỗi 
    private String normalize(String s){
          if(s == null) return "";
          // loại bỏ khoảng trắng đầu cuối và chuyển về chữ thường
          String tmp = s.trim().toLowerCase();
          //loại dấu tiếng việt
          tmp = Normalizer.normalize(tmp, Normalizer.Form.NFD);
          tmp = tmp.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
          //bỏ kí tự không phải chữ cái,chữ số hoặc là khoảng trắng 
          tmp = tmp.replaceAll("[^a-z0-9\\s]","");
          //chuyển nhiều khoảng trắng thành 1
          tmp = tmp.replaceAll("\\s+","");
          return tmp;
}
    // Kiểm tra 2 chuỗi có 1 phần khớp hay không
         private boolean softMatch(String userInterest,String dbValue){
            if (userInterest == null || userInterest.isEmpty()) return false;
            if (dbValue == null || dbValue.isEmpty()) return false;

            String a = normalize(userInterest);
            String b = normalize(dbValue);
    // nếu dbvalue chưa toàn bộ userInterest thì trả về true
            if(b.contains(a)) return true;
    //nếu userInterrest chưa toàn bộ dbvalue thì trả về true
            if(a.contains(b)) return true;
    //tách userInterest thành từ, kiểm tra từng token có nằm trong dbValue không
    String[] tokens = a.split("");
    int matchTokens =0;
    for(String t : tokens){
        if(t.length() >= 2 && b.contains(t)) {
            matchTokens++;
        }
    }
    //Nếu hơn 50% token của userInterest xuất hiện trong dbValue thì trả về true
        return tokens.length > 0 && ((double) matchTokens / tokens.length) >= 0.5;
         }
    // ===== Tính điểm phù hợp =====
    public double tinhDiemNganh(double diemThiHS, String toHopHS, List<String> soThichHS) {
    double diem = 0.0;

    // 1️⃣ So sánh điểm thi và điểm chuẩn
    if (diemThiHS >= diemChuan) {
        double chenhlech = diemThiHS - diemChuan;
        diem += 0.3 + (chenhlech * 0.02); // +2% mỗi điểm hơn
    } else {
        diem += (diemThiHS / diemChuan) * 0.4; // tỉ lệ nếu thấp hơn
    }

    // 2️⃣ Chỉ tiêu lớn hơn 100
    if (nhuCauTuyenDung > 100) {
        diem += 0.1; // +10%
    }

    // 3️⃣ Cơ hội việc làm (0.9 ~ 0.9%)
    double coHoi = coHoiViecLam;
    if (coHoi > 1) coHoi /= 100; // nếu lỡ nhập 90 thì thành 0.9
    diem += coHoi * 0.2; // tối đa +20%

    // 4️⃣ Lương trung bình (giả sử 20 triệu là mức cao nhất)
    double luong = luongTrungBinh;
    double diemLuong = Math.min((luong / 20.0) * 0.1, 0.1); // tối đa +10%
    diem += diemLuong;

    // 5️⃣ Sở thích (vẫn như cũ)
    if (soThichLienQuan != null && soThichHS != null && !soThichLienQuan.isEmpty()) {
        int matchCount = 0;
        int checks = 0;

        for (String userSt : soThichHS) {
            if (userSt == null || userSt.trim().isEmpty()) continue;
            checks++;
            boolean matched = false;

            for (String dbSt : soThichLienQuan) {
                if (softMatch(userSt, dbSt)) {
                    matched = true;
                    break;
                }
            }
            if (!matched && softMatch(userSt, this.tenNganh)) matched = true;
            if (matched) matchCount++;
        }

        if (checks > 0) {
            double ratio = (double) matchCount / checks;
            diem += ratio * 0.25; // tối đa +30%
        }
    }

    // 🔹 Chuẩn hóa (0 → 1)
    if (diem > 1) diem = 1;
    if (diem < 0) diem = 0;

    // Nhân 100 để ra %
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
                " | Chỉ tiêu: " + nhuCauTuyenDung +
                " | Hồ sơ: " + hoSo;
    }

    // ===== Getter & Setter =====
    public Long getId() { return id; }
    public String getTenNganh() { return tenNganh; }
    public void setTenNganh(String tenNganh) { this.tenNganh = tenNganh; }

    public String getMaNganh() { return maNganh; }
    public void setMaNganh(String maNganh) { this.maNganh = maNganh; }

    public String getToHopMon() { return toHopMon; }
    public void setToHopMon(String toHopMon) { this.toHopMon = toHopMon; }

    public double getDiemChuan() { return diemChuan; }
    public void setDiemChuan(double diemChuan) { this.diemChuan = diemChuan; }

    public double getDiemPhuHop() { return diemPhuHop; }
    public void setDiemPhuHop(double diemPhuHop) { this.diemPhuHop = diemPhuHop;}

    public double getCoHoiViecLam() { return coHoiViecLam; }
    public void setCoHoiViecLam(double coHoiViecLam) { this.coHoiViecLam = coHoiViecLam; }

    public double getLuongTrungBinh() { return luongTrungBinh; }
    public void setLuongTrungBinh(double luongTrungBinh) { this.luongTrungBinh = luongTrungBinh; }

    public int getNhuCauTuyenDung() { return nhuCauTuyenDung; }
    public void setNhuCauTuyenDung(int nhuCauTuyenDung) { this.nhuCauTuyenDung = nhuCauTuyenDung; }

    public int getHoSo() { return hoSo; }
    public void setHoSo(int hoSo) { this.hoSo = hoSo; }

    public List<String> getSoThichLienQuan() { return soThichLienQuan; }
    public void setSoThichLienQuan(List<String> soThichLienQuan) { this.soThichLienQuan = soThichLienQuan; }

}
