package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.servingwebcontent.Exception.DataNotFoundException;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class TruongDaiHocService {

    @Autowired
    private TruongDaiHocRepository truongRepository;
    public List<TruongDaiHoc> getDanhSachTruongSapXepTheoDiem() {
        // 1. Lấy tất cả các trường từ database
        List<TruongDaiHoc> allTruong = truongRepository.findAll();

        if (allTruong == null || allTruong.isEmpty()) {
        throw new DataNotFoundException("Không tìm thấy dữ liệu Trường Đại Học trong hệ thống.");
    }

        // 2. Lặp qua từng trường để tính toán và cập nhật điểm đánh giá
        for (TruongDaiHoc truong : allTruong) {
            int diemMoi = truong.tinhDiemDanhGia(); // Gọi phương thức tính điểm trong Model
            truong.setDiemDanhGia(diemMoi); // Cập nhật điểm cho đối tượng (chỉ trong bộ nhớ)
        }

        // 3. Sắp xếp danh sách các trường theo điểm đánh giá đã được cập nhật (giảm dần)
        // Sử dụng Stream API và Comparator cho ngắn gọn và hiệu quả
        return allTruong.stream()
                .sorted(Comparator.comparingDouble(TruongDaiHoc::getDiemDanhGia).reversed())
                .collect(Collectors.toList());

    
    // // Bạn có thể thêm các phương thức khác như tìm theo ID
    // public TruongDaiHoc getTruongById(Integer id) {
    //     return truongRepository.findById(id).orElse(null);


    // // ✅ Tìm trường theo ID
    // public TruongDaiHoc getTruongById(int id) {
    //     return truongRepository.findById(id).orElse(null);
    // }

    // ✅ Lấy tất cả trường (không sắp xếp)
    // public List<TruongDaiHoc> getAllTruong() {
    //     return truongRepository.findAll();
    // }

    
}
}

