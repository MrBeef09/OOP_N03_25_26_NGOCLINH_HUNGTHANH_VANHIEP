package com.example.servingwebcontent.Model.User;

//package User;
public class HocSinh extends Nguoi {
    private String maHocSinh;
    private ThongTinCaNhan thongTinCaNhan;
    private KetQuaHocTap ketQuaHocTap;
    private SoThichNganhHoc soThichNganhHoc;
    private TaiKhoan taiKhoan;

    //constructor
    public HocSinh(String maHocSinh, ThongTinCaNhan thongTinCaNhan,
                   KetQuaHocTap ketQuaHocTap, SoThichNganhHoc soThichNganhHoc,
                   TaiKhoan taiKhoan) {
        this.maHocSinh = maHocSinh;
        this.thongTinCaNhan = thongTinCaNhan;
        this.ketQuaHocTap = ketQuaHocTap;
        this.soThichNganhHoc = soThichNganhHoc;
        this.taiKhoan = taiKhoan;
    }

    //getter setter
    public String getMaHocSinh(){
        return maHocSinh;
    }
    public void setMaHocSinh(String maHocSinh) {
        if (maHocSinh != null && !maHocSinh.trim().isEmpty()) {
            this.maHocSinh = maHocSinh;
        }
    }

    //method
    public void XemThongTin() {
        System.out.println("Ma hoc sinh: " + maHocSinh +
                           " | Ho ten: " + getHoTen() +
                           " | Ngay sinh: " + getNgaySinh() +
                           " | Gioi tinh: " + getGioiTinh() +
                           " | Dia chi: " + (thongTinCaNhan != null ? thongTinCaNhan.getDiaChi() : "Chua cap nhat") +
                           " | So dien thoai: " + (thongTinCaNhan != null ? thongTinCaNhan.getSoDienThoai() : "Chua cap nhat")+
                           " | Diem thi: " + (ketQuaHocTap != null ? ketQuaHocTap.getDiemThi() : "Chua cap nhat") +
                           " | Nganh quan tam: " + (soThichNganhHoc != null ? soThichNganhHoc.getNganhQuanTam() : "Chua cap nhat") +
                           " | So thich: " + (soThichNganhHoc != null ? soThichNganhHoc.getSoThich() : "Chua cap nhat") +
                           " | Tai nang: " + (soThichNganhHoc != null ? soThichNganhHoc.getTaiNang() : "Chua cap nhat"));
    }


    public void CapNhatThongTinCaNhan(String hoTen, int ngaySinh, String gioiTinh, 
                                  String maHocSinh, String diaChi, int soDienThoai, 
                                  KetQuaHocTap ketQuaHocTap, 
                                  SoThichNganhHoc soThichNganhHoc, 
                                  TaiKhoan taiKhoan) {
    
    this.setHoTen(hoTen);
    this.setNgaySinh(ngaySinh); 
    this.setGioiTinh(gioiTinh);
    this.setMaHocSinh(maHocSinh);

    if (this.thongTinCaNhan != null) {
        this.thongTinCaNhan.CapNhatThongTin(diaChi, soDienThoai);
    } else {
        System.out.println("Thong tin ca nhan chua duoc khoi tao.");
    }

    if (ketQuaHocTap != null) {
        this.ketQuaHocTap = ketQuaHocTap;
    } else {
        System.out.println("Ket qua hoc tap chua duoc khoi tao.");
    }

    if (soThichNganhHoc != null) {
        this.soThichNganhHoc = soThichNganhHoc;
    } else {
        System.out.println("So thich nganh hoc chua duoc khoi tao.");}
                                  }

    public boolean dangNhap(String password, String username) {
    if (taiKhoan != null) {
        return taiKhoan.Dangnhap(password, username);
    }
    return false; 
   }

    public void chonTruongDaiHoc(String maTruong) {
        System.out.println(getHoTen() + " đã chọn trường có mã: " + maTruong);
    }

    public void xemDanhSachTruongGoiY() {
        System.out.println("Danh sach truong goi y cho hoc sinh " + getHoTen() + ":");
        if (soThichNganhHoc != null) {
            System.out.println("- Goi y dua theo nganh: " + soThichNganhHoc.getNganhQuanTam());
        } else {
            System.out.println("- Hien chua có du lieu ve so thich nganh hoc.");
        }
        if (ketQuaHocTap != null) {
            System.out.println("- Goi y dua theo điểm thi: " + ketQuaHocTap.getDiemThi());
        } else {
            System.out.println("- Hien chua có du lieu ve diem thi.");
        }
        if (soThichNganhHoc.getTaiNang() != null) {
            System.out.println("- Goi y dua theo tai nang: " + soThichNganhHoc.getTaiNang());
        } else {
            System.out.println("- Hien chua có du lieu ve tai nang.");
            
        }
    }
    @Override
public String toString() {
    return "Học sinh {" +
            "Mã HS='" + maHocSinh + '\'' +
            ", Họ tên='" + getHoTen() + '\'' +
            ", Ngày sinh=" + getNgaySinh() +
            ", Giới tính='" + getGioiTinh() + '\'' +
            '}';
}

    
}
