package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.servingwebcontent.Exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class TruongDaiHocService {

    @Autowired
    private TruongDaiHocRepository truongRepo;

    public List<TruongDaiHoc> getDanhSachTruongSapXepTheoDiem() {
        // 1. Lấy tất cả các trường từ DB
        List<TruongDaiHoc> ds = truongRepo.findAll();

        // 2. Tính và lưu lại điểm cho từng trường
        for (TruongDaiHoc t : ds) {
            double diemMoi = t.tinhDiemDanhGia();
            t.setDiemDanhGia(diemMoi);
            truongRepo.save(t); // ⚠️ Lưu lại DB — bắt buộc phải có dòng này
        }

        // 3. Sắp xếp giảm dần theo điểm
        ds.sort((a, b) -> Double.compare(b.getDiemDanhGia(), a.getDiemDanhGia()));

        return ds;
    }

    public List<TruongDaiHoc> findAll() {
        return truongRepo.findAll();
    }

    /**
     * DÙNG CHO ADMIN: Tìm trường theo ID (Dùng Integer)
     * (Dùng cho API lấy dữ liệu edit)
     */
    public Optional<TruongDaiHoc> findByIdOptional(Integer id) {
        return truongRepo.findById(id);
    }

    /**
     * DÙNG CHO ADMIN: Lưu (Tạo mới hoặc Cập nhật)
     * (Entity sẽ tự động tính điểm nhờ @PrePersist/@PreUpdate)
     */
    public TruongDaiHoc save(TruongDaiHoc truong) {
        return truongRepo.save(truong);
    }

    /**
     * DÙNG CHO ADMIN: Xóa trường theo ID (Dùng Integer)
     */
    public void deleteById(Integer id) {
        if (!truongRepo.existsById(id)) {
            throw new DataNotFoundException("Không tìm thấy trường để xóa với ID: " + id);
        }
        truongRepo.deleteById(id);
    }

    /**
     * DÙNG CHO ADMIN: Logic tìm kiếm trường theo tên
     */
    public List<TruongDaiHoc> searchByTenTruong(String query) {
        if (query == null || query.trim().isEmpty()) {
            // Trả về tất cả nếu query rỗng
            return truongRepo.findAll();
        }
        return truongRepo.findByTenTruongContainingIgnoreCase(query);
    }


    /**
     * DÙNG CHO ADMIN: Logic tìm kiếm trường theo từ khóa (tên, địa chỉ, mã trường)
     */
    public List<TruongDaiHoc> searchByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            // Trả về tất cả nếu keyword rỗng
            return truongRepo.findAll();
        }
        return truongRepo.searchByKeyword(keyword);
    }
}   