package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.NganhHoc;
import com.example.servingwebcontent.Repository.NganhHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TuvanService {

    @Autowired
    private NganhHocRepository nganhHocRepository;

    // Tính toán tư vấn dựa trên dữ liệu DB
    public List<NganhHoc> tuVanTatCaNganh(double diemThiHS, String toHopHS, List<String> soThichHS) {
        List<NganhHoc> dsNganh = nganhHocRepository.findAll();
        List<NganhHoc> ketQua = new ArrayList<>();

        for (NganhHoc n : dsNganh) {
            double diem = n.tinhDiemNganh(diemThiHS, toHopHS, soThichHS);
            n.setDiemPhuHop(diem);
            ketQua.add(n);
        }

        // Lấy top 5 ngành phù hợp nhất
        return ketQua.stream()
                .sorted((a, b) -> Double.compare(b.getDiemPhuHop(), a.getDiemPhuHop()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
