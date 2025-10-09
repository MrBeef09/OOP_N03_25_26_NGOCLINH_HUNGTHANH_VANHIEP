public class CanTin implements TienIch {
    private String MaCanTin;
    private int SucChua;

    public CanTin(String MaCanTin, int SucChua) {
        this.MaCanTin = MaCanTin;
        this.SucChua = SucChua;
    }

    public String GetMaCanTin() { return MaCanTin; }
    public int GetSucChua() { return SucChua; }

    @Override
    public void XemThongTin() {
        System.out.println("Căn tin | Mã: " + MaCanTin +
                           " | Sức chứa: " + SucChua);
    }

    @Override
    public int DanhGia() {
        return SucChua / 100; // cứ 100 chỗ = 1 điểm
    }
}
