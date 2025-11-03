package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.User.GiaoVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiaoVienServiceTest {

    private GiaoVienService giaoVienService;

    @BeforeEach
    void setUp() {
        giaoVienService = new GiaoVienService();
    }

    @Test
    void testThemVaLayTatCa() {
        GiaoVien gv = new GiaoVien("GV01", "Nguyen Van A", LocalDate.of(1990, 1, 1), "Nam");
        giaoVienService.themGiaoVien(gv);

        List<GiaoVien> ds = giaoVienService.layTatCa();
        assertEquals(1, ds.size());
        assertEquals("GV01", ds.get(0).getMaGiaoVien());
    }

    @Test
    void testTimTheoMa() {
        GiaoVien gv1 = new GiaoVien("GV01", "Nguyen Van A", LocalDate.of(1990, 1, 1), "Nam");
        GiaoVien gv2 = new GiaoVien("GV02", "Tran Thi B", LocalDate.of(1992, 2, 2), "Nữ");
        giaoVienService.themGiaoVien(gv1);
        giaoVienService.themGiaoVien(gv2);

        GiaoVien ketQua = giaoVienService.timTheoMa("GV02");
        assertNotNull(ketQua);
        assertEquals("Tran Thi B", ketQua.getHoTen());
    }

    @Test
    void testCapNhatThongTin() {
        GiaoVien gvCu = new GiaoVien("GV01", "Nguyen Van A", LocalDate.of(1990, 1, 1), "Nam");
        giaoVienService.themGiaoVien(gvCu);

        GiaoVien gvMoi = new GiaoVien("GV01", "Nguyen Van A (Updated)", LocalDate.of(1991, 2, 2), "Nam");
        boolean result = giaoVienService.capNhatThongTin("GV01", gvMoi);

        assertTrue(result);
        GiaoVien gvCapNhat = giaoVienService.timTheoMa("GV01");
        assertEquals("Nguyen Van A (Updated)", gvCapNhat.getHoTen());
        assertEquals(LocalDate.of(1991, 2, 2), gvCapNhat.getNgaySinh());
    }

    @Test
    void testXoaGiaoVien() {
        GiaoVien gv = new GiaoVien("GV01", "Nguyen Van A", LocalDate.of(1990, 1, 1), "Nam");
        giaoVienService.themGiaoVien(gv);

        boolean result = giaoVienService.xoaGiaoVien("GV01");
        assertTrue(result);
        assertNull(giaoVienService.timTheoMa("GV01"));
    }
}