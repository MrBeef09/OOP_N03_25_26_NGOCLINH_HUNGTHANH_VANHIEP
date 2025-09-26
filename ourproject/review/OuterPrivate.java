public class OuterPrivate {
    private class InnerPrivate{
        public void show(){
            System.out.println("day la private inner class)");
        }
    }

    public void useInner(){
        InnerPrivate ip = new InnerPrivate();
        ip.show();
    }
}
