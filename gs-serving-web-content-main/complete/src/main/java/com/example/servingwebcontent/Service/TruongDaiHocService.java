package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TruongDaiHocService {

    @Autowired
    private TruongDaiHocRepository truongRepo;

    //  Lấy danh sách trường, tính điểm và sắp xếp theo điểm giảm dần
    public List<TruongDaiHoc> getDanhSachTruongSapXepTheoDiem() {
        List<TruongDaiHoc> ds = truongRepo.findAll();

        for (TruongDaiHoc t : ds) {
            double diemMoi = t.tinhDiemDanhGia();
            t.setDiemDanhGia(diemMoi);
            truongRepo.save(t); // Cập nhật lại DB
        }

        ds.sort((a, b) -> Double.compare(b.getDiemDanhGia(), a.getDiemDanhGia()));
        return ds;
    }

    // Thêm hoặc cập nhật trường (cho Admin)
    public void saveTruong(TruongDaiHoc truong) {
        double diem = truong.tinhDiemDanhGia();
        truong.setDiemDanhGia(diem);
        truongRepo.save(truong);
    }

    //  Xoá trường (cho Admin)
    public void deleteTruong(int id) {
        truongRepo.deleteById(id);
    }

    // Lấy thông tin chi tiết 1 trường (để chỉnh sửa, nếu cần)
    public Optional<TruongDaiHoc> getTruongById(int id) {
        return truongRepo.findById(id);
    }
}
