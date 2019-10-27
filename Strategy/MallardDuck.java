import quackBehavior.Quack;
import flyBehavior.FlyWithWings;

public class MallardDuck extends Duck {
    // constructor
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I am a real Mallard duck");
    }
}