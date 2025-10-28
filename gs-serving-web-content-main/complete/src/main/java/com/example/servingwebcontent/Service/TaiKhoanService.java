package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.User.TaiKhoan;
import com.example.servingwebcontent.Repository.TaiKhoanRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TaiKhoanService implements UserDetailsService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("===== ĐĂNG NHẬP DEBUG =====");
    System.out.println("Đang tìm user: [" + username + "]");
    
    TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(username)
        .orElseThrow(() -> {
            System.out.println("❌ KHÔNG TÌM THẤY USER!");
            return new UsernameNotFoundException("User not found: " + username);
        });

    System.out.println("✅ Tìm thấy user:");
    System.out.println("  - Username: " + taiKhoan.getTenDangNhap());
    System.out.println("  - Email: " + taiKhoan.getEmail());
    System.out.println("  - Role: " + taiKhoan.getVaiTro());
    System.out.println("  - Password hash (first 30 chars): " + taiKhoan.getMatKhau().substring(0, 30) + "...");
    System.out.println("  - Password starts with $2: " + taiKhoan.getMatKhau().startsWith("$2"));
    System.out.println("==========================");

    // ✅ Chuẩn hóa ROLE_ prefix cho Spring Security
    String role = taiKhoan.getVaiTro();
    if (!role.startsWith("ROLE_")) {
        role = "ROLE_" + role;  // thêm prefix nếu thiếu
    }

    return User.builder()
    .username(taiKhoan.getTenDangNhap())
    .password(taiKhoan.getMatKhau())
    .roles(taiKhoan.getVaiTro().replace("ROLE_", ""))
    .build();
    
}

    @Transactional
    @CacheEvict(value = "taiKhoanCache", key = "#username")
    public void register(String username, String email, String password, String role) {
        System.out.println("===== ĐĂNG KÝ BẮT ĐẦU =====");
        
        // Kiểm tra username đã tồn tại
        if (taiKhoanRepository.findByTenDangNhap(username).isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại!");
        }

        // Chuẩn hóa role
        String normalizedRole = role.trim().toUpperCase();
        
        // Validation role
        if (!normalizedRole.equals("ADMIN") && !normalizedRole.equals("HOCSINH")) {
            throw new IllegalArgumentException("Vai trò không hợp lệ. Chỉ chấp nhận ADMIN hoặc HOCSINH.");
        }

        String encodedPassword = passwordEncoder.encode(password);
        String finalRole = "ROLE_" + normalizedRole;
        
        System.out.println("Thông tin đăng ký:");
        System.out.println("  - Username: " + username);
        System.out.println("  - Email: " + email);
        System.out.println("  - Raw password length: " + password.length());
        System.out.println("  - Encoded password (first 30 chars): " + encodedPassword.substring(0, 30) + "...");
        System.out.println("  - Role: " + finalRole);

        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap(username);
        taiKhoan.setEmail(email);
        taiKhoan.setMatKhau(encodedPassword);
        taiKhoan.setVaiTro(finalRole);
        
        taiKhoanRepository.save(taiKhoan);
        System.out.println("✅ Lưu thành công!");
        System.out.println("==========================");
    }
}