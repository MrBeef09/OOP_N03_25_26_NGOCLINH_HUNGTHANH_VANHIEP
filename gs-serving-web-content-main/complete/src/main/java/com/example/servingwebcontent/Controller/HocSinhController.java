// package com.example.servingwebcontent.Controller;

// import com.example.servingwebcontent.Model.User.HocSinh;
// import com.example.servingwebcontent.Service.HocSinhService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/hocsinh")
// public class HocSinhController {
//     @Autowired
//     private HocSinhService hocSinhService;

//     @GetMapping
//     public List<HocSinh> getAllHocSinh() {
//         return hocSinhService.getAllHocSinh();
//     }

//     @GetMapping("/{maHocSinh}")
//     public HocSinh getHocSinh(@PathVariable String maHocSinh) {
//         return hocSinhService.getHocSinhByMa(maHocSinh);
//     }

//     @PostMapping
//     public HocSinh createHocSinh(@RequestBody HocSinh hocSinh) {
//         return hocSinhService.saveHocSinh(hocSinh);
//     }
// }