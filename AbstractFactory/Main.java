
import PizzaFactory.*;

public class Main {
  public static void main(String[] args) {
    PizzaFactory AmericaPizzaFactory = new AmericaPizzaFactory();
    
    AmericaPizzaFactory.orderPizza("America");

    PizzaFactory ChinesePizzaFactory = new ChinesePizzaFactory();

    ChinesePizzaFactory.orderPizza("Chinese");
  }
}