package com.example.servingwebcontent.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import com.example.servingwebcontent.Repository.TruongDaiHocRepository;
import com.example.servingwebcontent.Service.TruongDaiHocService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
    @Autowired
    private TruongDaiHocService truongService;
    @GetMapping("/home")
    public String adminHome(Model model) {
        System.out.println("\n=====  ADMIN HOME CONTROLLER =====");
        
        // Lấy thông tin user đang đăng nhập
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        System.out.println(" Username: " + username);
        System.out.println(" Authorities: " + auth.getAuthorities());
        
        // Truyền username vào model để hiển thị trong view
        model.addAttribute("username", username);
        
        return "admin/home";
    }

    @GetMapping("/universities")
    public String manageUniversities(Model model) {
        System.out.println("\n=====  ADMIN UNIVERSITIES CONTROLLER =====");
        
        // 1. Lấy thông tin user (để hiển thị "Xin chào admin")
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());

        // 2. Lấy TẤT CẢ danh sách trường (KHÔNG GIỚI HẠN)
        System.out.println("Đang lấy TẤT CẢ danh sách trường...");
        List<TruongDaiHoc> allSchools = truongService.getAllTruong(); 
        
        // 3. Đưa danh sách vào model
        model.addAttribute("truongList", allSchools);
        System.out.println("Đã thêm " + allSchools.size() + " trường vào model.");

        System.out.println(" Returning view: admin/home (Với dữ liệu trường)");
        System.out.println("=====================================\n");
        
        // Vẫn return "admin/home" vì 2 method dùng chung 1 file HTML
        return "admin/home";
    }
    
    @PostMapping("/university/add")
    public String addUniversityFromAdmin(@ModelAttribute TruongDaiHoc truong, Authentication auth) {
        // Kiểm tra quyền admin
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        
        System.out.println("Admin đang thêm trường: " + truong.getTenTruong());
        truongService.saveTruong(truong);
        
        // Redirect về trang admin home với tab universities
        return "redirect:/admin/home#universities";
    }
    
    // Tương tự cho update và delete
    @PostMapping("/university/update")
    public String updateUniversityFromAdmin(@ModelAttribute TruongDaiHoc truong, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        truongService.saveTruong(truong);
        return "redirect:/admin/home#universities";
    }
    
    @GetMapping("/university/delete/{id}")
    public String deleteUniversityFromAdmin(@PathVariable int id, Authentication auth) {
        if (auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "error/403";
        }
        truongService.deleteTruong(id);
        return "redirect:/admin/home#universities";
    }
}
