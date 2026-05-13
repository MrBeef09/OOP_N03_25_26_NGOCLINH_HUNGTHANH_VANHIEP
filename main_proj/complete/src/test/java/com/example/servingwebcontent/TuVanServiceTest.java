package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.NganhHoc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TuvanServiceTest {

    private TuvanService tuvanService;

    @BeforeEach
    void setUp() {
        tuvanService = new TuvanService();
    }

    @Test
    void testKhoiTaoDuLieuMau() {
        List<NganhHoc> ds = tuvanService.getDsNganh();
        assertFalse(ds.isEmpty(), "Danh sách ngành ban đầu không được rỗng");
        assertEquals(4, ds.size(), "Phải có 4 ngành mẫu được khởi tạo");
    }

    @Test
    void testThemNganhMoi() {
        NganhHoc nganhMoi = new NganhHoc(
                "Thiết kế đồ họa", "TK01", "H00",
                22.0, 80, 10, 100, 70,
                Arrays.asList("sáng tạo", "mỹ thuật", "thiết kế")
        );

        tuvanService.themNganh(nganhMoi);
        List<NganhHoc> ds = tuvanService.getDsNganh();

        assertTrue(ds.stream().anyMatch(n -> n.getMaNganh().equals("TK01")));
    }

    @Test
    void testTuVanTatCaNganh() {
        List<String> soThichHS = Arrays.asList("lập trình", "máy tính");
        List<NganhHoc> ketQua = tuvanService.tuVanTatCaNganh(26.0, "A00", soThichHS);

        assertNotNull(ketQua);
        assertEquals(4, ketQua.size());

        // Kiểm tra thứ tự giảm dần điểm phù hợp
        for (int i = 0; i < ketQua.size() - 1; i++) {
            assertTrue(ketQua.get(i).getDiemPhuHop() >= ketQua.get(i + 1).getDiemPhuHop(),
                    "Danh sách không được sắp sai thứ tự");
        }
    }
}
