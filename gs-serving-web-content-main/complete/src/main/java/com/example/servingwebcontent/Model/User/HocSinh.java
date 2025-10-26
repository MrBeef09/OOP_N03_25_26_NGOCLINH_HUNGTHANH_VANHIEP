package com.example.servingwebcontent.Model.User;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "hoc_sinh")
public class HocSinh extends Nguoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_hoc_sinh", nullable = false, unique = true)
    private String maHocSinh;


    @Embedded
    private ThongTinCaNhan thongTinCaNhan;
    @Embedded
    private KetQuaHocTap ketQuaHocTap;
    @Embedded 
    private SoThichNganhHoc soThichNganhHoc;

    //  Mối quan hệ 1-1 với tài khoản
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tai_khoan_id", referencedColumnName = "id")
    private TaiKhoan taiKhoan;


    // ✅ Constructors
    public HocSinh() {}

    public HocSinh(String maHocSinh, String hoTen, LocalDate ngaySinh, String gioiTinh,
                   ThongTinCaNhan thongTinCaNhan, KetQuaHocTap ketQuaHocTap, TaiKhoan taiKhoan) {
        super(hoTen, ngaySinh, gioiTinh);
        this.maHocSinh = maHocSinh;
        this.thongTinCaNhan = thongTinCaNhan;
        this.ketQuaHocTap = ketQuaHocTap;
        this.taiKhoan = taiKhoan;
    }

    //  Getter & Setter
    public Long getId() {
        return id;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    

    //  Một vài method tiện ích
    

    @Override
    public void XemThongTin() {
        
        System.out.println("Học sinh: " + getHoTen()); 
        System.out.println("Mã HS: " + maHocSinh);
        System.out.println("Giới tính: " + getGioiTinh());
        System.out.println("Ngày sinh: " + getNgaySinh());
        System.out.println("Thông tin cá nhân" + thongTinCaNhan);
        System.out.println("Kết quả học tập: " + ketQuaHocTap);
        System.out.println("Tài khoản: " + (taiKhoan != null ? taiKhoan.getTenDangNhap() : "Chưa có"));
    }

    @Override
    public String toString() {
        return "HocSinh{" +
                "maHocSinh='" + maHocSinh + '\'' +
                ", hoTen='" + getHoTen() + '\'' + 
                ", ngaySinh='" + getNgaySinh() + '\'' +
                ", gioiTinh='" + getGioiTinh() + '\'' +
                ", thongTinCaNhan=" + thongTinCaNhan +
                ", ketQuaHocTap =" + ketQuaHocTap +
                ", taiKhoan=" + (taiKhoan != null ? taiKhoan.getTenDangNhap() : "null") +
                '}';
    }
}
