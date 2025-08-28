import java.util.Random;
public class randNum {
    public static double randNum(){
        Random r = new Random();
        double num = r.nextDouble(100.0);
        return num;
    }
    public static void main(String[]args){
        System.out.println(randNum());
    }
}
