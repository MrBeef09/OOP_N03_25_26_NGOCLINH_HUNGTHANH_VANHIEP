package com.example.servingwebcontent.Model.User;

import jakarta.persistence.Embeddable;

@Embeddable
public class KetQuaHocTap {
    private float diemThi;
    private String hocLuc;
    private String toHopMon;

    public KetQuaHocTap() {}

    public KetQuaHocTap(float diemThi, String hocLuc, String toHopMon) {
        this.diemThi = diemThi;
        this.hocLuc = hocLuc;
        this.toHopMon = toHopMon;
    }

    public float getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(float diemThi) {
        this.diemThi = diemThi;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    public String getToHopMon() {
        return toHopMon;
    }

    public void setToHopMon(String toHopMon) {
        this.toHopMon = toHopMon;
    }

    //method 
    public void capNhatDiemThi(float diemThi, String hocLuc, String toHopMon) {
        this.diemThi = diemThi;
        this.hocLuc = hocLuc;
        this.toHopMon = toHopMon;
    }
    @Override
    public String toString() {
        return "KetQuaHocTap{" +
                "diemThi=" + diemThi +
                ", hocLuc='" + hocLuc + '\'' +
                ", toHopMon='" + toHopMon + '\'' +
                '}';
    }
}
