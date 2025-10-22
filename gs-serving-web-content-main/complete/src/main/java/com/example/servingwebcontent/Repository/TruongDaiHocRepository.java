package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface này tự động kế thừa các phương thức CRUD cơ bản (findAll, save, findById,...)
// Long là kiểu dữ liệu của khóa chính (id) trong lớp TruongDaiHoc
@Repository
public interface TruongDaiHocRepository extends JpaRepository<TruongDaiHoc, Integer> {
    
}