package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.User.TaiKhoan;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
    
    @Cacheable(value = "taiKhoanCache", key = "#tenDangNhap")  // ← Thêm dòng này
    Optional<TaiKhoan> findByTenDangNhap(String tenDangNhap);
    
    Optional<TaiKhoan> findByEmail(String email);
}