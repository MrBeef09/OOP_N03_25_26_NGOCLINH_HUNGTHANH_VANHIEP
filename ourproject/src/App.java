public class App {
    public static void main(String[] args) {
        System.out.println("Nhom ban  Linh Thanh Hiep!");
        testUniversities.test();

        Major sv = new Major();
        sv.setDiemChuan(24);
        sv.setDiemThi(26);
        sv.setTenNganh("Công nghệ thông tin"); 
        sv.kiemTra();
    }
}
