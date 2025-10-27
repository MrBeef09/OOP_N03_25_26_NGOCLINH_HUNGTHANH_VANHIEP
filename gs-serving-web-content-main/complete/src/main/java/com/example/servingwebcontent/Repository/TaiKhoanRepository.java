package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.User.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
    // Method để tìm tài khoản theo tên đăng nhập (dùng cho login)
    TaiKhoan findByTenDangNhap(String tenDangNhap);

    // Bạn có thể thêm method khác nếu cần, ví dụ:
    // boolean existsByTenDangNhap(String tenDangNhap);  // Kiểm tra tồn tại
    // List<TaiKhoan> findByVaiTro(String vaiTro);  // Tìm theo vai trò
}
