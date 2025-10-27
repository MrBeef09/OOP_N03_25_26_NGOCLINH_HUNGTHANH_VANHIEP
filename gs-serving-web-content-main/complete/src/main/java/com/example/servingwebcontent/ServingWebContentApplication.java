package com.example.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.servingwebcontent.Repository.TaiKhoanRepository;
import com.example.servingwebcontent.Model.User.TaiKhoan;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    // @Bean
    // CommandLineRunner init(TaiKhoanRepository repo, PasswordEncoder encoder) {
    //     return args -> {
    //         if (repo.findByTenDangNhap("admin") == null) {
    //             TaiKhoan tk = new TaiKhoan();
    //             tk.setTenDangNhap("admin");
    //             tk.setMatKhau(encoder.encode("admin123")); // mã hóa trước khi lưu
    //             // set roles...
    //             repo.save(tk);
    //         }
    //     };
    // }

}

