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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
// 1. Import Service thay vì Repository
import com.example.servingwebcontent.Service.TruongDaiHocService; 
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin") // Đặt tiền tố /admin cho tất cả các hàm
public class AdminDashboardController {

    // 2. Inject Service để đồng bộ logic
    @Autowired
    private TruongDaiHocService truongService;

    /**
     * Đây là hàm DUY NHẤT bạn cần.
     * Nó sẽ tải trang admin/home.html và nạp sẵn
     * danh sách các trường đại học ban đầu.
     */
    @GetMapping("/home")
    public String adminHome(Model model) {
        System.out.println("\n=====  ADMIN HOME CONTROLLER =====");
        
        // Lấy thông tin user đang đăng nhập
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        // Truyền username vào model
        model.addAttribute("username", username);
        
        // 3. Lấy danh sách trường (đã gộp logic từ hàm manageUniversities)
        // Sử dụng Service thay vì Repository
        List<TruongDaiHoc> truongList = truongService.findAll();
        
        // 4. Tên "universities" phải khớp với vòng lặp trong admin/home.html
        model.addAttribute("universities", truongList); 
        
        System.out.println(" Returning view: admin/home");
        System.out.println("=====================================\n");
        
        // Trả về file /resources/templates/admin/home.html
        return "admin/home";
    }

    // CREATE (ADMIN): Xử lý POST /admin/university/add
    @PostMapping("/admin/university/add")
    public String addUniversity(@ModelAttribute TruongDaiHoc truong, RedirectAttributes redirectAttributes) {
        // Entity sẽ tự động tính điểm khi hàm save() được gọi
        truongService.save(truong);
        redirectAttributes.addFlashAttribute("successMessage", "Thêm trường mới thành công!");
        return "redirect:/admin#universities";
    }

    // UPDATE (ADMIN): Xử lý POST /admin/university/update
    
    @PostMapping("/admin/university/update")
    public String updateUniversity(@ModelAttribute TruongDaiHoc truong, RedirectAttributes redirectAttributes) {
        // Entity sẽ tự động tính điểm khi hàm save() được gọi (nhờ @PreUpdate)
        truongService.save(truong);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật trường thành công!");
        return "redirect:/admin#universities";
    }

    //DELETE (ADMIN): Xử lý GET /admin/university/delete/{id}
     
    @GetMapping("/admin/university/delete/{id}")
    public String deleteUniversity(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            truongService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa trường thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Xóa thất bại: " + e.getMessage());
        }
        return "redirect:/admin#universities";
    }

    
    //API EDIT (ADMIN): Lấy thông tin chi tiết của 1 trường (API)
    
    @GetMapping("/admin/university/api/{id}")
    @ResponseBody // Trả về JSON
    public Optional<TruongDaiHoc> getUniversityById(@PathVariable("id") Integer id) {
        return truongService.findByIdOptional(id);
    }

    
    //API SEARCH (ADMIN): Xử lý GET /admin/university/search
    @GetMapping("/admin/university/search")
    public String searchAdminUniversities(
            @RequestParam(value = "query", required = false) String query,
            Model model) {
        
        List<TruongDaiHoc> searchResults = truongService.searchByTenTruong(query);
        model.addAttribute("universities", searchResults); // Tên "universities" phải khớp với vòng lặp
        
        // Trả về file "admin" VÀ chỉ lấy fragment tên là "universityTableFragment"
        // (Bạn phải đặt th:fragment="universityTableFragment" trong admin.html)
        return "admin :: universityTableFragment";
    }
}