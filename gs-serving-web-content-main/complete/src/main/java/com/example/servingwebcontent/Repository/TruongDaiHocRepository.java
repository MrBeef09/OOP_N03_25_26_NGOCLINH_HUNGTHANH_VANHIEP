package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruongDaiHocRepository extends JpaRepository<TruongDaiHoc, Integer> {

    List<TruongDaiHoc> findAllByOrderByDiemDanhGiaDesc();
}

