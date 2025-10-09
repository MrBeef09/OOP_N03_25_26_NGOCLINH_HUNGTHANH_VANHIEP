package com.example.servingwebcontent.Model.Truongdaihoc;
public abstract class PhongHoc{
    protected String maPhong;
    protected int sucChua;
    protected int soMayChieu;
    protected int soDieuHoa;
    protected int soQuat;
    
    public PhongHoc(String maPhong,int sucChua){
        this.maPhong = maPhong;
        this.sucChua = sucChua;
    }
    public String getMaPhong(){
        return maPhong;
    }

    public int getSucChua(){
        return sucChua;
    }

    public abstract int danhGia();

    public void xemThongTin(){
        System.out.println("Mã Phòng: " + maPhong + ",Sức Chứa : " + sucChua);
    }

}

