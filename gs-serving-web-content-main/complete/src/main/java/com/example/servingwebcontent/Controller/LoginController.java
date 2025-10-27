package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.servingwebcontent.Model.User.TaiKhoan;
import com.example.servingwebcontent.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
@Controller
public class LoginController {

    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/dang-nhap")
    public String loginPage() {
        return "login"; // tên file HTML (không cần .html)
    }
    
    @GetMapping("/dang-ky")
    public String registerPage() {
        return "register"; // hoặc cùng file với login
    }
    
    @PostMapping("/register")
    public String register(@RequestParam String username,
                          @RequestParam String email,
                          @RequestParam String password,
                          @RequestParam String confirmPassword,
                          @RequestParam String role,
                          Model model) {
        try {
            // Kiểm tra mật khẩu khớp (double-check ở backend)
            if (!password.equals(confirmPassword)) {
                model.addAttribute("error", "Mật khẩu xác nhận không khớp!");
                return "login";
            }
            
            // Đăng ký tài khoản
            taiKhoanService.register(username, email, password, role);
            
            // Redirect về trang đăng nhập với thông báo thành công
            return "redirect:/dang-nhap?registered=true";
            
        } catch (RuntimeException e) {
            // Lỗi từ service (username đã tồn tại, v.v.)
            model.addAttribute("error", e.getMessage());
            return "login";
        } catch (Exception e) {
            // Lỗi khác
            model.addAttribute("error", "Đăng ký thất bại. Vui lòng thử lại!");
            e.printStackTrace();
            return "login";
        }
}
}