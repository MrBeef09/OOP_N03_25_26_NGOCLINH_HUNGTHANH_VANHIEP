package com.example.servingwebcontent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user") // (Tùy chọn) Nhóm các URL của user lại với nhau
public class UserController {

    // Đây là phương thức sẽ "đón" yêu cầu đến "/user/home"
    @GetMapping("/home")
    public String userHomePage() {
        // Trả về tên của file HTML trong thư mục templates
        // Ví dụ: templates/user/home.html
        return "user/home"; 
    }

    // Bạn có thể thêm các trang khác cho học sinh ở đây
    // Ví dụ: @GetMapping("/profile"), @GetMapping("/courses"), etc.
}