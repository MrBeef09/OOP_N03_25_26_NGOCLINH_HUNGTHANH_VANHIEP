packege Controller;
import Interfaces.HendInterface;
import Interfaces.LegInterface;

public class Dog implements HendInterface, LegInterface, Animal{
    @Override
    public void test(){
        System.out.println("woof");
    }
    @Override
    public void walk(){
        System.out.println("The dog is walking by feet");
    }
    @Override
    public void grab(){
        System.out.println("Grabbed by hand");
    }
    @Override
    public void noOfLegs(){
    throw new UnsupportedOperationException("Unimplemented method 'noOfLegs'");
    }
    @Override
    public void noOfHands(){
        throw new UnsupportedOperationException("Unimplemented method 'noOfhands'");
    }
}