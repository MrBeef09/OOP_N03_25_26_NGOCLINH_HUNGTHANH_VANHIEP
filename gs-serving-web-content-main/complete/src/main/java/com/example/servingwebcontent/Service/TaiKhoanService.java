package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.User.TaiKhoan;
import com.example.servingwebcontent.Model.User.Role;
import com.example.servingwebcontent.Repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaiKhoanService implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(username);
        if (taiKhoan == null) {
            throw new UsernameNotFoundException("Người dùng không tồn tại: " + username);
        }

        // Build authorities robustly: try getRoles() (collection) else parse vai_tro string
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        try {
            Collection<Role> roles = null;
            try {
                roles = (Collection<Role>) taiKhoan.getRoles();
            } catch (Throwable ignored) {
            }
            if (roles != null) {
                authorities = roles.stream()
                        .map(r -> {
                            String name = Optional.ofNullable(r.getName()).orElse("");
                            if (!name.startsWith("ROLE_")) name = "ROLE_" + name;
                            return new SimpleGrantedAuthority(name);
                        })
                        .collect(Collectors.toList());
            } else {
                String vt = Optional.ofNullable(taiKhoan.getVaiTro()).orElse("");
                if (!vt.isBlank()) {
                    authorities = Arrays.stream(vt.split(","))
                            .map(String::trim)
                            .filter(s -> !s.isEmpty())
                            .map(s -> s.startsWith("ROLE_") ? s : "ROLE_" + s)
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
                }
            }
        } catch (Exception ex) {
            authorities = Collections.emptyList();
        }

        // return UserDetails with stored (hashed) password
        return org.springframework.security.core.userdetails.User.builder()
                .username(taiKhoan.getTenDangNhap())
                .password(taiKhoan.getMatKhau()) // phải là BCrypt hash trong DB
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
    
    // THÊM CÁC METHOD MỚI
    
    /**
     * Đăng ký tài khoản mới
     */
    public TaiKhoan register(String username, String email, String password, String role) {
        // Kiểm tra username đã tồn tại chưa
        if (taiKhoanRepository.findByTenDangNhap(username) != null) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại");
        }
        
        // Tạo tài khoản mới
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap(username);
        taiKhoan.setEmail(email);
        taiKhoan.setMatKhau(passwordEncoder.encode(password)); // Mã hóa mật khẩu
        taiKhoan.setVaiTro(role); // "HOCSINH" hoặc "ADMIN"
        
        return taiKhoanRepository.save(taiKhoan);
    }
    
    /**
     * Lưu tài khoản
     */
    public TaiKhoan save(TaiKhoan taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }
    
    /**
     * Tìm tài khoản theo username
     */
    public TaiKhoan findByUsername(String username) {
        return taiKhoanRepository.findByTenDangNhap(username);
    }
    
    /**
     * Kiểm tra username đã tồn tại chưa
     */
    public boolean existsByUsername(String username) {
        return taiKhoanRepository.findByTenDangNhap(username) != null;
    }
}