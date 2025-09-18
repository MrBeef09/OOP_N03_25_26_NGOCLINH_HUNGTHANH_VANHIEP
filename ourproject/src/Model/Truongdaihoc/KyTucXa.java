public class KyTucXa {
    private String maKTX;
    private int soLuongPhong;
    private int sucChua;

    public KyTucXa(String maKTX, int soLuongPhong, int sucChua) {
        this.maKTX = maKTX;
        this.soLuongPhong = soLuongPhong;
        this.sucChua = sucChua;
    }

    public void xemThongTin() {
        System.out.println("KTX " + maKTX +
                           " | Phòng: " + soLuongPhong +
                           " | Sức chứa: " + sucChua);
    }

    public int danhGia() {
        return sucChua / 100;
    }
}
