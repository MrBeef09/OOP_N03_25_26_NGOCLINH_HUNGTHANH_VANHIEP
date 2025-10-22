package com.example.servingwebcontent.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository; // Import Repository

@Service
public class TruongDaiHocService {

    @Autowired
    private TruongDaiHocRepository truongRepository; // Inject Repository

    public List<TruongDaiHoc> getDanhSachTruong() {
        // Sử dụng phương thức findAll() của JpaRepository để lấy dữ liệu từ DB
        return truongRepository.findAll(); 
    }
    
    // Bạn có thể thêm các phương thức khác như tìm theo ID
    public TruongDaiHoc getTruongById(Integer id) {
        return truongRepository.findById(id).orElse(null);
    }
}