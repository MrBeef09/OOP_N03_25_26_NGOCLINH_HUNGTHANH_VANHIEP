public class TestSoThichNganhHoc {
    public static void main (String[] args) {
        SoThichNganhHoc st = new SoThichNganhHoc();
        st.setNganhQuanTam("Cong nghe thong tin");
        st.setSoThich("Lap trinh, AI, game");
        st.setTaiNang("Gioi toan va Logic");

        System.out.println("---Test chon nganh hoc---");
        st.chonNganhHoc();

        System.out.println("\n---Test xem so thich");
        st.Xemsothich();

        System.out.println("\n---Thong tin tu getter---");
        System.out.println("Nganh quan tam:"+ st.getNganhQuanTam());
        System.out.println("So thich:" + st.getSoThich);
        System.out.println("Tai nang:" + st.getTaiNang);
    }
}
