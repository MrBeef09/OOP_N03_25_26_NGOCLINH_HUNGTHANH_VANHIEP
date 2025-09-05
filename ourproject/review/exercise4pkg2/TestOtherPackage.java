package review.exercise4pkg2;

import review.exercise4pkg.MyClass;

public class TestOtherPackage extends MyClass {
    public static void main(String[] args) {
        TestOtherPackage obj = new TestOtherPackage();
        obj.protectedMethod(); //  chạy được vì ở subclass
        System.out.println("Protected method is accessible within package or subclass.");
    }
}

