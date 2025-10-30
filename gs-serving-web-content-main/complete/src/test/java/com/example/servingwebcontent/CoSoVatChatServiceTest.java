package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CoSoVatChatServiceTest {

    private CoSoVatChatService service;

    @BeforeEach
    void setUp() {
        service = new CoSoVatChatService();
    }

    @Test
    void testThemVaLayPhongHoc() {
        PhongHoc p = new PhongHoc("Phòng A1", 50, "Tốt");
        service.themPhongHoc(p);

        List<PhongHoc> ds = service.getDsPhongHoc();
        assertEquals(1, ds.size());
        assertEquals("Phòng A1", ds.get(0).getTenPhong());
    }

    @Test
    void testTinhTongDiem() {
        // Giả sử các lớp con đều có phương thức danhGia() trả về int
        PhongHoc p = new PhongHoc("A1", 50, "Tốt");
        KyTucXa k = new KyTucXa("KTX1", 200, "Sạch sẽ");
        ThuVien t = new ThuVien("TV1", 1000, "Hiện đại");

        // Mock dữ liệu
        service.themPhongHoc(p);
        service.themKTX(k);
        service.themThuVien(t);

        int tong = service.tinhTongDiem();
        assertTrue(tong >= 0, "Tổng điểm phải lớn hơn hoặc bằng 0");
    }

    @Test
    void testClearAll() {
        service.themPhongHoc(new PhongHoc("A1", 30, "Tốt"));
        service.themThuVien(new ThuVien("TV", 500, "Tốt"));

        service.clearAll();

        assertTrue(service.getDsPhongHoc().isEmpty());
        assertTrue(service.getDsThuVien().isEmpty());
    }

    @Test
    void testLayDanhSachCSVC() {
        service.themPhongHoc(new PhongHoc("A1", 30, "Tốt"));
        service.themKTX(new KyTucXa("KTX1", 100, "Khá"));

        List<Object> ds = service.layDanhSachCSVC();
        assertEquals(2, ds.size());
        assertTrue(ds.get(0) instanceof PhongHoc || ds.get(0) instanceof KyTucXa);
    }
}
