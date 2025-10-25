package com.example.servingwebcontent.Model.User;

import jakarta.persistence.*;

@Entity
@Table(name = "thong_tin_ca_nhan")
public class ThongTinCaNhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    // 🔹 Mối quan hệ 1-1 với Học Sinh (nếu có)
    @OneToOne(mappedBy = "thongTinCaNhan", cascade = CascadeType.ALL)
    private HocSinh hocSinh;

    // ✅ Constructors
    public ThongTinCaNhan() {}

    public ThongTinCaNhan(String diaChi, String soDienThoai) {
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    // ✅ Getter & Setter
    public Long getId() {
        return id;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public HocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    // ✅ Method tiện ích
    
    @Override
    public String toString() {
        return "ThongTinCaNhan{" +
                "id=" + id +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
