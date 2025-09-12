public class Main1 {
    public static void main(String[] args) {
        // Tạo đối tượng CRUD cho giáo viên
        GiaovienCrud gvCrud = new GiaovienCrud();

        // Tạo vài đối tượng giáo viên (giả sử Nguoi có constructor setHoten, Ngaysinh, Gioitinh)
        Giaovien gv1 = new Giaovien();
        gv1.setMagiaovien("GV01");
        gv1.setHoten("Nguyen Van A");
        gv1.setNgaysinh(1980);
        gv1.setGioitinh("Nam");

        Giaovien gv2 = new Giaovien();
        gv2.setMagiaovien("GV02");
        gv2.setHoten("Tran Thi B");
        gv2.setNgaysinh(1985);
        gv2.setGioitinh("Nu");

        // CREATE
        gvCrud.addGiaovien(gv1);
        gvCrud.addGiaovien(gv2);

        // READ
        gvCrud.getGiaoviens();

        // READ - tìm theo mã
        Giaovien found = gvCrud.getByMagiaovien("GV01");
        System.out.println("Tìm thấy: " + found);

        // // UPDATE - đổi trường công tác
        // Truongdaihoc truong1 = new Truongdaihoc("DHQG Ha Noi");
        // gvCrud.updateTruongcongtac("GV01", truong1);

        // DELETE - xóa giáo viên
        gvCrud.deleteGiaovien("GV02");

        // Xem lại danh sách sau khi xóa
        gvCrud.getGiaoviens();
    }
}
