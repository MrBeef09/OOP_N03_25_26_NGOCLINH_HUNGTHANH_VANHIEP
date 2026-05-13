package com.example.servingwebcontent.Repository;
import org.springframework.data.jpa.repository.Query;
import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruongDaiHocRepository extends JpaRepository<TruongDaiHoc, Integer> {

    // Dùng câu query này để lấy tất cả dữ liệu trong 1 lần
    @Query("SELECT t FROM TruongDaiHoc t LEFT JOIN FETCH t.coSoVatChat LEFT JOIN FETCH t.doiNguGiaoVien")
    List<TruongDaiHoc> findAllWithDetails();
}

