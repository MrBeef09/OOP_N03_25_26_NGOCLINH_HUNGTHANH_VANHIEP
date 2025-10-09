package com.example.servingwebcontent.Model.Truongdaihoc;
public class DieuHoa implements TrangThietBi {
    private String congSuatLanh;
    private int soLuong;

    public DieuHoa(String congSuatLanh, int soLuong) {
        this.congSuatLanh = congSuatLanh;
        this.soLuong = soLuong;
    }

    @Override
    public void XemThongTin() {
        System.out.println("Điều Hòa | Công suất lạnh: " + congSuatLanh +
                           " | Số lượng: " + soLuong);
    }

    @Override
    public int danhGia() {
        return soLuong * 2; // mỗi điều hòa cộng 2 điểm
    }
}
