package com.example.servingwebcontent.Model.User;

import jakarta.persistence.Embeddable;

@Embeddable
public class SoThichNganhHoc {
    private String nganhQuanTam;
    private String soThich;
    private String taiNang;

    public SoThichNganhHoc() {}

    public SoThichNganhHoc(String nganhQuanTam, String soThich, String taiNang) {
        this.nganhQuanTam = nganhQuanTam;
        this.soThich = soThich;
        this.taiNang = taiNang;
    }

    public String getNganhQuanTam() {
        return nganhQuanTam;
    }

    public void setNganhQuanTam(String nganhQuanTam) {
        this.nganhQuanTam = nganhQuanTam;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

    public String getTaiNang() {
        return taiNang;
    }

    public void setTaiNang(String taiNang) {
        this.taiNang = taiNang;
    }

    @Override
    public String toString() {
        return "SoThichNganhHoc{" +
                "nganhQuanTam='" + nganhQuanTam + '\'' +
                ", soThich='" + soThich + '\'' +
                ", taiNang='" + taiNang + '\'' +
                '}';
    }
}
