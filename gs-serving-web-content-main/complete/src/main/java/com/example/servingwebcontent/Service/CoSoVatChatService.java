package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.*;
import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.KyTucXa;
import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.ThuVien;
import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.;
import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.CoSoVatChat.PhongHoc.PhongHoc;
import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.CoSoVatChat.TienIch.TienIch;
import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.CoSoVatChat.TrangThietbi.TrangThietBi;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CoSoVatChatService {

    private List<PhongHoc> dsPhongHoc = new ArrayList<>();
    private List<KyTucXa> dsKTX = new ArrayList<>();
    private List<ThuVien> dsThuVien = new ArrayList<>();
    private List<TrangThietBi> dsTrangThietBi = new ArrayList<>();
    private List<TienIch> dsTienIch = new ArrayList<>();
    private List<HaTangKiThuat> dsHaTang = new ArrayList<>();

    // ====== Thêm đối tượng ======
    public void themPhongHoc(PhongHoc p) { dsPhongHoc.add(p); }
    public void themKTX(KyTucXa k) { dsKTX.add(k); }
    public void themThuVien(ThuVien t) { dsThuVien.add(t); }
    public void themTrangThietBi(TrangThietBi tb) { dsTrangThietBi.add(tb); }
    public void themTienIch(TienIch ti) { dsTienIch.add(ti); }
    public void themHaTang(HaTangKiThuat ht) { dsHaTang.add(ht); }

    // ====== Xem toàn bộ ======
    public List<PhongHoc> getDsPhongHoc() { return dsPhongHoc; }
    public List<KyTucXa> getDsKTX() { return dsKTX; }
    public List<ThuVien> getDsThuVien() { return dsThuVien; }
    public List<TrangThietBi> getDsTrangThietBi() { return dsTrangThietBi; }
    public List<TienIch> getDsTienIch() { return dsTienIch; }
    public List<HaTangKiThuat> getDsHaTang() { return dsHaTang; }

    // ====== Tính tổng điểm ======
    public int tinhTongDiem() {
        int tong = 0;
        for (PhongHoc p : dsPhongHoc) tong += p.danhGia();
        for (KyTucXa k : dsKTX) tong += k.danhGia();
        for (ThuVien t : dsThuVien) tong += t.danhGia();
        for (TrangThietBi tb : dsTrangThietBi) tong += tb.danhGia();
        for (TienIch ti : dsTienIch) tong += ti.danhGia();
        for (HaTangKiThuat ht : dsHaTang) tong += ht.danhGia();
        return tong;
    }

    // ====== Xóa hoặc làm mới dữ liệu (nếu cần) ======
    public void clearAll() {
        dsPhongHoc.clear();
        dsKTX.clear();
        dsThuVien.clear();
        dsTrangThietBi.clear();
        dsTienIch.clear();
        dsHaTang.clear();
    }
public List<Object> layDanhSachCSVC() {
    List<Object> danhSach = new ArrayList<>();
    danhSach.addAll(dsPhongHoc);
    danhSach.addAll(dsKTX);
    danhSach.addAll(dsThuVien);
    danhSach.addAll(dsTrangThietBi);
    danhSach.addAll(dsTienIch);
    danhSach.addAll(dsHaTang);
    return danhSach;
}


}
