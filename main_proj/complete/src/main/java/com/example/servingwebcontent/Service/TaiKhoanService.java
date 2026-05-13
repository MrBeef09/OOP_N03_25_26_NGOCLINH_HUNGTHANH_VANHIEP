package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.User.TaiKhoan;
import com.example.servingwebcontent.Repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanService implements UserDetailsService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("===== ĐĂNG NHẬP DEBUG =====");
        System.out.println("Đang tìm user: [" + username + "]");
        
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(username)
            .orElseThrow(() -> {
                System.out.println("❌ KHÔNG TÌM THẤY USER!");
                return new UsernameNotFoundException("User not found: " + username);
            });

        System.out.println(" Tìm thấy user:");
        System.out.println("  - Username: " + taiKhoan.getTenDangNhap());
        System.out.println("  - Role from DB: " + taiKhoan.getVaiTro());
        
        // Loại bỏ "ROLE_" prefix nếu có trong database
        String role = taiKhoan.getVaiTro();
        if (role.startsWith("ROLE_")) {
            role = role.substring(5); // Bỏ "ROLE_" prefix
        }
        
        System.out.println("  - Role after process: " + role);
        
        // Dùng roles() - Spring sẽ tự thêm "ROLE_" prefix
        UserDetails userDetails = User.builder()
            .username(taiKhoan.getTenDangNhap())
            .password(taiKhoan.getMatKhau())
            .roles(role) // DÙNG roles() thay vì authorities()
            .build();
        
        System.out.println("  - Final Authorities: " + userDetails.getAuthorities());
        System.out.println("==========================");

        return userDetails;
    }

    public TaiKhoan findByUsername(String username) {
        return taiKhoanRepository.findByTenDangNhap(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public TaiKhoan findByEmail(String email) {
        return taiKhoanRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));
    }
}