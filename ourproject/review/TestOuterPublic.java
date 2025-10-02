// TestOuterPublic.java
public class TestOuterPublic {
    public static void main(String[] args) {
        OuterPublic outer = new OuterPublic();
        OuterPublic.InnerPublic inner = outer.new InnerPublic();
        inner.show();
    }
}

