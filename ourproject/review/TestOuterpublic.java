public class TestOuterpublic {
    public static void main(String[] args) {
        Outerpublic op = new Outerpublic();
        Outerpublic.InnerPublic ip = op.new InnerPublic();
        ip.show();
    }
}
