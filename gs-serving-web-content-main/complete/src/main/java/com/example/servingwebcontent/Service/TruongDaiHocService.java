package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.servingwebcontent.Exception.DataNotFoundException;

import java.util.List;

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
}