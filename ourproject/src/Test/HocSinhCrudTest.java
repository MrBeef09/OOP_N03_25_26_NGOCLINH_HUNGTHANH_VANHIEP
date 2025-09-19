import src.Controller.HocsinhCrud.java;
public class HocSinhCrudTest{
    public static void main(String[] args) {
        HocSinhCrud crud = new HocSinhCrud();

        // CREATE
        crud.addHocsinh(new HocSinh("0717", "Mai Ngoc Linh", 04, "Nữ"));
        crud.addHocsinh(new HocSinh("N2301","Nguyen Hung Thanh", 24 ,"Nam"));
        crud.addHocsinh(new HocSinh("T5632","Nguyen Van Hiep",30,"Nam"));


        // READ
        crud.getHocsinh();

        // UPDATE
        crud.updateHocsinh("HS01", "Nguyen Van A Updated", 19 ,"Nam");

        // DELETE
        crud.deleteHocsinh("HS02");

        // READ again
        crud.getHocsinh();
    }
}
