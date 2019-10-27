import flyBehavior.FlyRocketPowered;

public class Main {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();

        // 會呼叫 MallardDuck繼承來的performQuack()
        // 進而委託 quackBehavior處理quack行為，而非在自己class內處理
        mallard.performQuack();
        mallard.performFly();

        /**
         * 具有噴射動力的模型鴨子
         */
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly(); // 不會飛
        // 動態地更換飛行的行為
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly(); // 噴射！
    }
}
