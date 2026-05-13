package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.User.HocSinh;
import com.example.servingwebcontent.Repository.HocSinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocSinhService {
    @Autowired
    private HocSinhRepository hocSinhRepository;

    public List<HocSinh> getAllHocSinh() {
        return hocSinhRepository.findAll();
    }

    public HocSinh getHocSinhByMa(String maHocSinh) {
        return hocSinhRepository.findByMaHocSinh(maHocSinh);
    }

    public HocSinh saveHocSinh(HocSinh hocSinh) {
        return hocSinhRepository.save(hocSinh);
    }
}