public class TestCallback {
    public static void main(String[] args) {
        // Tạo 1 Callee
        Callee callee = new Callee();

        // Lấy callback (Closure) từ Callee
        Incrementable callback = callee.getCallbackReference();

        // Tạo Caller, truyền vào callback
        Caller caller = new Caller(callback);

        // Gọi caller.go() 10 lần
        for (int i = 0; i < 10; i++) {
            caller.go();
        }
    }
}

