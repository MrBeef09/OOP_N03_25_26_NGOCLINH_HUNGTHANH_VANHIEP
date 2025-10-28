package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.Truongdaihoc.NganhHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NganhHocRepository extends JpaRepository<NganhHoc, Long> {
   
}
