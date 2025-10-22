package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruongDaiHocRepository extends JpaRepository<TruongDaiHoc, Integer> {
    // Không cần viết thêm gì ở đây
}


