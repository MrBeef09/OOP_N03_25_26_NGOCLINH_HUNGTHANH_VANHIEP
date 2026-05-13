package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.User.HocSinh;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HocSinhServiceTest {

    private HocSinhService hocSinhService;

    @BeforeEach
    void setUp() {
        hocSinhService = new HocSinhService();
    }

    @Test
    void testThemVaLayTatCaHocSinh() {
        HocSinh hs = new HocSinh("HS01", "Nguyen Van B", LocalDate.of(2005, 5, 5), "Nam");
        hocSinhService.themHocSinh(hs);

        List<HocSinh> danhSach = hocSinhService.layTatCaHocSinh();
        assertEquals(1, danhSach.size());
        assertEquals("HS01", danhSach.get(0).getMaHocSinh());
    }

    @Test
    void testTimTheoMa() {
        HocSinh hs1 = new HocSinh("HS01", "Nguyen Van B", LocalDate.of(2005, 5, 5), "Nam");
        HocSinh hs2 = new HocSinh("HS02", "Tran Thi C", LocalDate.of(2006, 6, 6), "Nữ");

        hocSinhService.themHocSinh(hs1);
        hocSinhService.themHocSinh(hs2);

        HocSinh ketQua = hocSinhService.timTheoMa("HS02");
        assertNotNull(ketQua);
        assertEquals("Tran Thi C", ketQua.getHoTen());
    }

    @Test
    void testCapNhatHocSinh() {
        HocSinh hsCu = new HocSinh("HS01", "Nguyen Van B", LocalDate.of(2005, 5, 5), "Nam");
        hocSinhService.themHocSinh(hsCu);

        HocSinh hsMoi = new HocSinh("HS01", "Nguyen Van B (Updated)", LocalDate.of(2005, 12, 12), "Nam");
        boolean ketQua = hocSinhService.capNhatHocSinh("HS01", hsMoi);

        assertTrue(ketQua);
        HocSinh hsCapNhat = hocSinhService.timTheoMa("HS01");
        assertEquals("Nguyen Van B (Updated)", hsCapNhat.getHoTen());
        assertEquals(LocalDate.of(2005, 12, 12), hsCapNhat.getNgaySinh());
    }

    @Test
    void testXoaHocSinh() {
        HocSinh hs = new HocSinh("HS01", "Nguyen Van B", LocalDate.of(2005, 5, 5), "Nam");
        hocSinhService.themHocSinh(hs);

        boolean ketQua = hocSinhService.xoaHocSinh("HS01");
        assertTrue(ketQua);
        assertNull(hocSinhService.timTheoMa("HS01"));
    }
}
