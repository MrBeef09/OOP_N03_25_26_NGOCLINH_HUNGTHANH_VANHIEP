public class Caller {
    private Incrementable callbackReference;
Caller(Incrementable cbr) {
callbackReference = cbr;
}
void go() {
callbackReference.increment();
}
}
