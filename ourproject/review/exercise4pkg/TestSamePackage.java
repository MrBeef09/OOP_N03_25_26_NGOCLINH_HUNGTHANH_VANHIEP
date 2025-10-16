package review.exercise4pkg;

public class TestSamePackage {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.protectedMethod(); //  chạy được vì cùng package
    }
}

