package com.example.servingwebcontent.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.TruongDaiHoc;

@Service
public class TruongDaiHocService {

    public List<TruongDaiHoc> getDanhSachTruong() {
        List<TruongDaiHoc> ds = new ArrayList<>();

        ds.add(new TruongDaiHoc(1, "Đại học Bách Khoa Hà Nội", "Hà Nội"));
        ds.add(new TruongDaiHoc(2, "Đại học Kinh tế Quốc dân", "Hà Nội"));
        ds.add(new TruongDaiHoc(3, "Đại học Quốc gia TP.HCM", "TP.HCM"));
        ds.add(new TruongDaiHoc(4, "Đại học FPT", "Hà Nội / TP.HCM"));

        return ds;
    }
}
