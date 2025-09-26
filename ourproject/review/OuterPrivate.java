// OuterPrivate.java
public class OuterPrivate {
    private class InnerPrivate {
        public void show() {
            System.out.println("Đây là private inner class");
        }
    }

    public void useInner() {
        InnerPrivate inner = new InnerPrivate();
        inner.show();
    }
}
