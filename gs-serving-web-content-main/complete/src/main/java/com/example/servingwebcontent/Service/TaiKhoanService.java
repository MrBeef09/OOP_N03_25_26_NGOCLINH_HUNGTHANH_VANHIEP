package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.User.TaiKhoan;
import com.example.servingwebcontent.Repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
            .username(taiKhoan.getTenDangNhap())
            .password(taiKhoan.getMatKhau())
            .authorities(Collections.singletonList(
                new SimpleGrantedAuthority(taiKhoan.getVaiTro()) // ROLE_HOCSINH hoặc ROLE_ADMIN
            ))
            .build();
    }

    public void register(String username, String email, String password, String role) {
    // Kiểm tra username đã tồn tại
    if (taiKhoanRepository.findByTenDangNhap(username).isPresent()) {
        throw new RuntimeException("Tên đăng nhập đã tồn tại!");
    }

    // Chuẩn hóa role: loại bỏ khoảng trắng và uppercase
    String normalizedRole = role.trim().toUpperCase();
    
    // Validation role - CHỈ CHẤP NHẬN "ADMIN" hoặc "HOCSINH" (không có ROLE_ prefix)
    if (!normalizedRole.equals("ADMIN") && !normalizedRole.equals("HOCSINH")) {
        throw new IllegalArgumentException("Vai trò không hợp lệ. Chỉ chấp nhận ADMIN hoặc HOCSINH.");
    }

    TaiKhoan taiKhoan = new TaiKhoan();
    taiKhoan.setTenDangNhap(username);
    taiKhoan.setEmail(email);
    taiKhoan.setMatKhau(passwordEncoder.encode(password));
    taiKhoan.setVaiTro("ROLE_" + normalizedRole); // Thêm prefix ROLE_ khi lưu vào DB
    
    taiKhoanRepository.save(taiKhoan);
}
}