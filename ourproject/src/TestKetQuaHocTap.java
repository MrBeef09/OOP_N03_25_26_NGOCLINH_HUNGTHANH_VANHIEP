public class TestKetQuaHocTap {
    public static void main(String[] args) {
        // Tạo đối tượng KetQuaHocTap
        KetQuaHocTap kq = new KetQuaHocTap(7.5f, "Khá", "A00");

        // In ra thông tin ban đầu
        System.out.println("=== Thông tin ban đầu ===");
        System.out.println("Điểm thi: " + kq.getDiemThi());
        System.out.println("Học lực: " + kq.getHocLuc());
        System.out.println("Tổ hợp môn: " + kq.getToHopMon());

        // Cập nhật điểm thi
        System.out.println("\n=== Cập nhật kết quả học tập ===");
        kq.CapNhatDiemThi(8.8f, "Giỏi", "D01");

        // In ra thông tin sau cập nhật
        System.out.println("Điểm thi: " + kq.getDiemThi());
        System.out.println("Học lực: " + kq.getHocLuc());
        System.out.println("Tổ hợp môn: " + kq.getToHopMon());

        // Test method Tinhhocluc (hiện đang để trống)
        System.out.println("\n=== Test Tinhhocluc() ===");
        kq.Tinhhocluc(); // Hiện tại chưa có logic nên sẽ không in gì
    }
}
