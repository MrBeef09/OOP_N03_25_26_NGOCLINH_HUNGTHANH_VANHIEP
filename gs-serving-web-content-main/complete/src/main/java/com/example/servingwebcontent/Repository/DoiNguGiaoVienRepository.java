package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.Truongdaihoc.DoiNguGiaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoiNguGiaoVienRepository extends JpaRepository<DoiNguGiaoVien, Integer> {
    
}