package PizzaFactory;

import PizzaFactory.Factory.*;

public class Main {
  public static void main(String[] args) {
    PizzaFactory originalPizzaFactory = new OriginalPizzaFactory();
    
    originalPizzaFactory.orderPizza("cheese");
    originalPizzaFactory.orderPizza("potato");

    PizzaFactory specialPizzaFactory = new SpecialPizzaFactory();
    specialPizzaFactory.orderPizza("onion");
  }
}