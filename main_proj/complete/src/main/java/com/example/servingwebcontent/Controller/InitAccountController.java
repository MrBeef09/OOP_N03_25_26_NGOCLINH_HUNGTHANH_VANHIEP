package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.User.TaiKhoan;
import com.example.servingwebcontent.Repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller để tạo tài khoản mẫu
 * CẢNH BÁO: CHỈ DÙNG CHO DEVELOPMENT! XÓA KHI DEPLOY PRODUCTION!
 */
@Controller
public class InitAccountController {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Tạo tài khoản Admin và Học sinh mẫu
     * Truy cập: http://localhost:8080/init-accounts
     */
    @GetMapping("/init-accounts")
    @ResponseBody
    public String initAccounts() {
        StringBuilder result = new StringBuilder();
        result.append("========== TẠO TÀI KHOẢN MẪU ==========\n\n");

        try {
            // ==========================================
            // 1. TẠO TÀI KHOẢN ADMIN
            // ==========================================
            
            // Xóa admin cũ nếu có
            taiKhoanRepository.findByTenDangNhap("admin").ifPresent(user -> {
                taiKhoanRepository.delete(user);
                result.append("🗑️ Đã xóa tài khoản admin cũ\n");
            });

            // Tạo admin mới
            TaiKhoan admin = new TaiKhoan();
            admin.setTenDangNhap("admin");
            admin.setEmail("admin@example.com");
            admin.setMatKhau(passwordEncoder.encode("admin123"));
            admin.setVaiTro("ROLE_ADMIN");
            
            taiKhoanRepository.save(admin);
            
            result.append("✅ Đã tạo tài khoản ADMIN:\n");
            result.append("   Username: admin\n");
            result.append("   Password: admin123\n");
            result.append("   Email: admin@example.com\n");
            result.append("   Role: ROLE_ADMIN\n\n");

            // ==========================================
            // 2. TẠO TÀI KHOẢN HỌC SINH
            // ==========================================
            
            // Xóa học sinh cũ nếu có
            taiKhoanRepository.findByTenDangNhap("hocsinh").ifPresent(user -> {
                taiKhoanRepository.delete(user);
                result.append("🗑️ Đã xóa tài khoản hocsinh cũ\n");
            });

            // Tạo học sinh mới
            TaiKhoan hocSinh = new TaiKhoan();
            hocSinh.setTenDangNhap("hocsinh");
            hocSinh.setEmail("hocsinh@example.com");
            hocSinh.setMatKhau(passwordEncoder.encode("hocsinh123"));
            hocSinh.setVaiTro("ROLE_HOCSINH");
            
            taiKhoanRepository.save(hocSinh);
            
            result.append("✅ Đã tạo tài khoản HỌC SINH:\n");
            result.append("   Username: hocsinh\n");
            result.append("   Password: hocsinh123\n");
            result.append("   Email: hocsinh@example.com\n");
            result.append("   Role: ROLE_HOCSINH\n\n");

            // ==========================================
            // 3. TẠO THÊM TÀI KHOẢN TEST
            // ==========================================
            
            String[] testUsers = {"user1", "user2", "user3"};
            for (String username : testUsers) {
                taiKhoanRepository.findByTenDangNhap(username).ifPresent(user -> {
                    taiKhoanRepository.delete(user);
                });

                TaiKhoan testUser = new TaiKhoan();
                testUser.setTenDangNhap(username);
                testUser.setEmail(username + "@example.com");
                testUser.setMatKhau(passwordEncoder.encode("123456"));
                testUser.setVaiTro("ROLE_HOCSINH");
                
                taiKhoanRepository.save(testUser);
                
                result.append("✅ Đã tạo tài khoản TEST: ")
                      .append(username)
                      .append(" / 123456\n");
            }

            result.append("\n========================================\n");
            result.append("✅ HOÀN TẤT! Đã tạo ").append(2 + testUsers.length).append(" tài khoản\n\n");
            
            result.append("📋 DANH SÁCH TÀI KHOẢN:\n");
            result.append("┌────────────┬──────────────┬───────────────┐\n");
            result.append("│ Username   │ Password     │ Role          │\n");
            result.append("├────────────┼──────────────┼───────────────┤\n");
            result.append("│ admin      │ admin123     │ ROLE_ADMIN    │\n");
            result.append("│ hocsinh    │ hocsinh123   │ ROLE_HOCSINH  │\n");
            result.append("│ user1      │ 123456       │ ROLE_HOCSINH  │\n");
            result.append("│ user2      │ 123456       │ ROLE_HOCSINH  │\n");
            result.append("│ user3      │ 123456       │ ROLE_HOCSINH  │\n");
            result.append("└────────────┴──────────────┴───────────────┘\n\n");
            
            result.append("🔗 Đăng nhập tại: http://localhost:8080/dang-nhap\n");

        } catch (Exception e) {
            result.append("\n❌ LỖI: ").append(e.getMessage()).append("\n");
            e.printStackTrace();
        }

        return result.toString();
    }

    /**
     * Tạo tài khoản tùy chỉnh
     * URL: /create-account?username=abc&password=123&role=ADMIN
     */
    @GetMapping("/create-account")
    @ResponseBody
    public String createAccount(
            String username,
            String password,
            String email,
            String role) {
        
        try {
            // Validate input
            if (username == null || password == null || role == null) {
                return "❌ Thiếu tham số! Cần: username, password, role\n" +
                       "Ví dụ: /create-account?username=test&password=123&email=test@mail.com&role=ADMIN";
            }

            // Chuẩn hóa role
            String finalRole = role.toUpperCase();
            if (!finalRole.startsWith("ROLE_")) {
                finalRole = "ROLE_" + finalRole;
            }

            // Validate role
            if (!finalRole.equals("ROLE_ADMIN") && !finalRole.equals("ROLE_HOCSINH")) {
                return "❌ Role không hợp lệ! Chỉ chấp nhận: ADMIN hoặc HOCSINH";
            }

            // Kiểm tra username đã tồn tại
            if (taiKhoanRepository.findByTenDangNhap(username).isPresent()) {
                return "❌ Username '" + username + "' đã tồn tại!";
            }

            // Tạo tài khoản
            TaiKhoan newUser = new TaiKhoan();
            newUser.setTenDangNhap(username);
            newUser.setEmail(email != null ? email : username + "@example.com");
            newUser.setMatKhau(passwordEncoder.encode(password));
            newUser.setVaiTro(finalRole);

            taiKhoanRepository.save(newUser);

            return "✅ Đã tạo tài khoản thành công!\n\n" +
                   "Username: " + username + "\n" +
                   "Password: " + password + "\n" +
                   "Email: " + newUser.getEmail() + "\n" +
                   "Role: " + finalRole + "\n\n" +
                   "🔗 Đăng nhập tại: http://localhost:8080/dang-nhap";

        } catch (Exception e) {
            return "❌ LỖI: " + e.getMessage();
        }
    }

    /**
     * Xem danh sách tất cả tài khoản
     */
    @GetMapping("/list-accounts")
    @ResponseBody
    public String listAccounts() {
        StringBuilder result = new StringBuilder();
        result.append("========== DANH SÁCH TÀI KHOẢN ==========\n\n");

        var accounts = taiKhoanRepository.findAll();
        
        if (accounts.isEmpty()) {
            result.append("⚠️ Chưa có tài khoản nào!\n");
            result.append("Tạo tài khoản tại: http://localhost:8080/init-accounts\n");
        } else {
            result.append("Tổng số: ").append(accounts.size()).append(" tài khoản\n\n");
            
            int i = 1;
            for (TaiKhoan account : accounts) {
                result.append(i++).append(". Username: ").append(account.getTenDangNhap()).append("\n");
                result.append("   Email: ").append(account.getEmail()).append("\n");
                result.append("   Role: ").append(account.getVaiTro()).append("\n");
                result.append("   Password Hash: ").append(
                    account.getMatKhau().substring(0, Math.min(30, account.getMatKhau().length()))
                ).append("...\n\n");
            }
        }

        return result.toString();
    }
}