package flyBehavior;

// 各種實踐Fly的類別

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I cannot fly");
    }
}