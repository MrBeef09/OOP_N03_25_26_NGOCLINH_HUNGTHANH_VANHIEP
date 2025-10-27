package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.servingwebcontent.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/dang-nhap")
    public String loginPage(@RequestParam(required = false) String registered, Model model) {
        if ("true".equals(registered)) {
            model.addAttribute("successMessage", "Đăng ký thành công! Vui lòng đăng nhập.");
        }
        return "login";
    }
    
    @GetMapping("/dang-ky")
    public String registerPage() {
        return "login";
    }
    
    @PostMapping("/register")
public String register(@RequestParam(required = false) String username,
                      @RequestParam(required = false) String email,
                      @RequestParam(required = false) String password,
                      @RequestParam(required = false) String confirmPassword,
                      @RequestParam(required = false) String role,
                      HttpServletRequest request,
                      Model model) {
    try {
        // Log chi tiết
        System.out.println("===== ĐĂNG KÝ DEBUG =====");
        System.out.println("Username: [" + username + "]");
        System.out.println("Email: [" + email + "]");
        System.out.println("Password length: " + (password != null ? password.length() : "null"));
        System.out.println("Role received: [" + role + "]");
        System.out.println("Role is null? " + (role == null));
        System.out.println("Role is empty? " + (role != null && role.isEmpty()));
        System.out.println("Role trimmed: [" + (role != null ? role.trim() : "null") + "]");
        System.out.println("========================");
        
        // Kiểm tra null hoặc empty
        if (role == null || role.trim().isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn vai trò!");
            return "login";
        }
        
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Mật khẩu xác nhận không khớp!");
            return "login";
        }
        
        taiKhoanService.register(username, email, password, role.trim());
        
        // Tự động đăng nhập bằng cách load user 1 lần duy nhất
        UserDetails userDetails = taiKhoanService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = 
            new UsernamePasswordAuthenticationToken(
                userDetails, 
                null, 
                userDetails.getAuthorities()
            );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // Lưu vào session
        request.getSession().setAttribute(
            HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
            SecurityContextHolder.getContext()
        );
        
        return "redirect:/";
        
    } catch (RuntimeException e) {
        System.err.println("Lỗi đăng ký: " + e.getMessage());
        e.printStackTrace();
        model.addAttribute("error", e.getMessage());
        return "login";
    }
}
}