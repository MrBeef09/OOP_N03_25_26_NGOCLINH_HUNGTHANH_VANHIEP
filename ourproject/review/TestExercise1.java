package review;

import review.exercise1pkg.MyClass; // import từ package khác

public class TestExercise1 {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.sayHello();
    }
}
