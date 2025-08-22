public class Universities {

    public String maTruong;
    public String tenTruong;
    public String diaDiem;

    //Phuogn thuc
    public void print(String ma, String ten, String diadiem){
        maTruong = ma;
        tenTruong = ten;
        diaDiem = diadiem;

        System.out.println("Ma Truong : " + maTruong +" ten truong : "+ tenTruong + " dia diem : " + diadiem);
    }

}
