package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruongDaiHocService {

    @Autowired
    private TruongDaiHocRepository truongRepository;

    // ✅ Lấy danh sách các trường sắp xếp theo điểm đánh giá giảm dần
    public List<TruongDaiHoc> getDanhSachTruongSapXepTheoDiem() {
        return truongRepository.findAllByOrderByDiemDanhGiaDesc();
    }

    
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
