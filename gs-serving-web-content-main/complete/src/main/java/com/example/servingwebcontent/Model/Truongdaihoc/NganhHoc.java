package com.example.servingwebcontent.Model.Truongdaihoc;

import jakarta.persistence.*;
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

    @Column(name = "diem_chuan")
    private double diemChuan;

    @Column(name = "co_hoi_viec_lam")
    private double coHoiViecLam;   // %

    @Column(name = "luong_trung_binh")
    private double luongTrungBinh; // triệu

    @Column(name = "chi_tieu")
    private int chiTieu;

    @Column(name = "ho_so")
    private int hoSo;

    @ElementCollection
    @CollectionTable(name = "so_thich_lien_quan", joinColumns = @JoinColumn(name = "nganh_id"))
    @Column(name = "so_thich")
    private List<String> soThichLienQuan;

    // ===== Constructor =====
    public NganhHoc() {}

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

    // ===== Tính điểm phù hợp =====
    public double tinhDiemNganh(double diemThiHS, String toHopHS, List<String> soThichHS) {
        double diem = 0;

        // 1. So sánh điểm thi so với điểm chuẩn
        if (diemThiHS >= diemChuan) {
            diem += 0.4;
        } else {
            diem += (diemThiHS / diemChuan) * 0.4;
        }

        // 2. Kiểm tra tổ hợp môn
        if (toHopMon != null && toHopMon.contains(toHopHS.trim())) {
            diem += 0.3;
        }

        // 3. Kiểm tra sở thích trùng khớp
        if (soThichLienQuan != null && soThichHS != null) {
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

    public double getCoHoiViecLam() { return coHoiViecLam; }
    public void setCoHoiViecLam(double coHoiViecLam) { this.coHoiViecLam = coHoiViecLam; }

    public double getLuongTrungBinh() { return luongTrungBinh; }
    public void setLuongTrungBinh(double luongTrungBinh) { this.luongTrungBinh = luongTrungBinh; }

    public int getChiTieu() { return chiTieu; }
    public void setChiTieu(int chiTieu) { this.chiTieu = chiTieu; }

    public int getHoSo() { return hoSo; }
    public void setHoSo(int hoSo) { this.hoSo = hoSo; }

    public List<String> getSoThichLienQuan() { return soThichLienQuan; }
    public void setSoThichLienQuan(List<String> soThichLienQuan) { this.soThichLienQuan = soThichLienQuan; }

}
