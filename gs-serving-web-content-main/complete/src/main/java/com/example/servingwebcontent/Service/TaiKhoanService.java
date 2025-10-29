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
        System.out.println("  - Role from DB: " + taiKhoan.getVaiTro());
        System.out.println("  - Password hash (first 30 chars): " + 
            taiKhoan.getMatKhau().substring(0, Math.min(30, taiKhoan.getMatKhau().length())) + "...");
        System.out.println("  - Password starts with $2: " + taiKhoan.getMatKhau().startsWith("$2"));
        
        // Tạo UserDetails với authorities
        UserDetails userDetails = User.builder()
            .username(taiKhoan.getTenDangNhap())
            .password(taiKhoan.getMatKhau())
            .authorities(new SimpleGrantedAuthority(taiKhoan.getVaiTro()))
            .build();
        
        System.out.println("  - Authorities: " + userDetails.getAuthorities());
        System.out.println("==========================");

        return userDetails;
    }

    @Transactional
    @CacheEvict(value = "taiKhoanCache", key = "#username")
    public void register(String username, String email, String password, String role) {
        System.out.println("===== ĐĂNG KÝ BẮT ĐẦU =====");
        
        // Kiểm tra username đã tồn tại
        if (taiKhoanRepository.findByTenDangNhap(username).isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại!");
        }

        // Kiểm tra email đã tồn tại (nếu cần)
        if (taiKhoanRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email đã được sử dụng!");
        }

        // Chuẩn hóa role
        String normalizedRole = role.trim().toUpperCase();
        
        // Validation role
        if (!normalizedRole.equals("ADMIN") && !normalizedRole.equals("HOCSINH")) {
            throw new IllegalArgumentException("Vai trò không hợp lệ. Chỉ chấp nhận ADMIN hoặc HOCSINH.");
        }

        // Mã hóa mật khẩu
        String encodedPassword = passwordEncoder.encode(password);
        
        // Thêm prefix ROLE_ cho Spring Security
        String finalRole = "ROLE_" + normalizedRole;
        
        System.out.println("Thông tin đăng ký:");
        System.out.println("  - Username: " + username);
        System.out.println("  - Email: " + email);
        System.out.println("  - Raw password length: " + password.length());
        System.out.println("  - Encoded password (first 30 chars): " + encodedPassword.substring(0, 30) + "...");
        System.out.println("  - Role: " + finalRole);

        // Tạo và lưu tài khoản
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap(username);
        taiKhoan.setEmail(email);
        taiKhoan.setMatKhau(encodedPassword);
        taiKhoan.setVaiTro(finalRole);
        
        taiKhoanRepository.save(taiKhoan);
        System.out.println("✅ Lưu thành công vào database!");
        System.out.println("==========================");
    }

    // Method hỗ trợ tìm tài khoản theo username
    public TaiKhoan findByUsername(String username) {
        return taiKhoanRepository.findByTenDangNhap(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    // // Method hỗ trợ tìm tài khoản theo email
    // public TaiKhoan findByEmail(String email) {
    //     return taiKhoanRepository.findByEmail(email)
    //         .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));
    // }
}