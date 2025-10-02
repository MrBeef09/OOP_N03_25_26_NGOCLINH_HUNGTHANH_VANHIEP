public class TestCallback {
public static void main(String[] args) {
    Calle callee = new Calle();
    Caller caller = new Caller(callee);
    for(int i = 0; i < 10; i++){
        caller.go();
    }
}
}
