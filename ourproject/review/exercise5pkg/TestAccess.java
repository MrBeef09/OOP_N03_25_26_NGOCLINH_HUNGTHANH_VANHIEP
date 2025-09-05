package review.exercise5pkg;

public class TestAccess {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        //  Accessible
        System.out.println("Public field = " + obj.publicField);
        System.out.println("Protected field = " + obj.protectedField);
        System.out.println("Package field = " + obj.packageField);

        obj.publicMethod();
        obj.protectedMethod();
        obj.packageMethod();

        //  Uncomment để thấy lỗi compile
        // System.out.println(obj.privateField);
        // obj.privateMethod();
    }
}
