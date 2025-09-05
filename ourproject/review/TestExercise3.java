package review;

// static import từ debug hoặc debugoff
// import static review.exercise3pkg.debug.Debug.*;      // bật debug
import static review.exercise3pkg.debugoff.Debug.*;      // tắt debug

public class TestExercise3 {
    public static void main(String[] args) {
        debug("This is a debug message");
        System.out.println("Program running...");
    }
}
