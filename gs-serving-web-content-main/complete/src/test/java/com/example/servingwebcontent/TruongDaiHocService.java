package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TruongDaiHocServiceTest {

    @Mock
    private TruongDaiHocRepository truongRepo;

    @InjectMocks
    private TruongDaiHocService truongService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDanhSachTruongSapXepTheoDiem() {
        // 🔹 Giả lập dữ liệu
        TruongDaiHoc t1 = new TruongDaiHoc("DH01", "ĐH A", 0);
        TruongDaiHoc t2 = new TruongDaiHoc("DH02", "ĐH B", 0);

        // 🔹 Giả lập hành vi tính điểm
        when(truongRepo.findAll()).thenReturn(Arrays.asList(t1, t2));

        // Giả sử phương thức tinhDiemDanhGia() trả giá trị cụ thể
        // (mock behavior qua subclass hoặc setter)
        t1.setDiemDanhGia(7.5);
        t2.setDiemDanhGia(8.2);

        // 🔹 Khi gọi service
        List<TruongDaiHoc> ketQua = truongService.getDanhSachTruongSapXepTheoDiem();

        // 🔹 Kiểm tra
        assertEquals(2, ketQua.size());
        assertTrue(ketQua.get(0).getDiemDanhGia() >= ketQua.get(1).getDiemDanhGia());

        // 🔹 Đảm bảo repo.save() được gọi
        verify(truongRepo, times(2)).save(any(TruongDaiHoc.class));
        verify(truongRepo, times(1)).findAll();
    }
}
