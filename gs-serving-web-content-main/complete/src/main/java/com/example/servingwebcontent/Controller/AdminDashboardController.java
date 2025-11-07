package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    private TruongDaiHocRepository truongDaiHocRepository;

    // Trang chủ admin: load username + danh sách trường kèm thông tin chi tiết
    @GetMapping("/home")
    public String adminHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());

        // Lấy danh sách trường kèm cơ sở vật chất và đội ngũ giáo viên
        List<TruongDaiHoc> truongList = truongDaiHocRepository.findAllWithDetails();
        model.addAttribute("truongList", truongList);

        return "admin/home";
    }

    // Route để quản lý universities: cũng load lại danh sách trường
    @GetMapping("/universities")
    public String manageUniversities(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());

        // Load danh sách trường kèm thông tin chi tiết
        List<TruongDaiHoc> truongList = truongDaiHocRepository.findAllWithDetails();
        model.addAttribute("truongList", truongList);

        return "admin/home";
    }

    // Các route khác vẫn giữ nguyên
    @GetMapping("/majors")
    public String manageMajors(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/home";
    }

    @GetMapping("/consultations")
    public String manageConsultations(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/home";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/home";
    }

    @GetMapping("/notifications")
    public String notifications(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/home";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/home";
    }

    @GetMapping("/universities/add")
    public String addUniversity(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin/home";
    }
}
