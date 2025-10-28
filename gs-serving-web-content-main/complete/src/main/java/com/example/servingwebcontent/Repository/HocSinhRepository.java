package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.User.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh, Long> {
    HocSinh findByMaHocSinh(String maHocSinh);
}