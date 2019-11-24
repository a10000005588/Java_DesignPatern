package PizzaFactory.Factory;

import Pizza.*;

public class SpecialPizzaFactory extends PizzaFactory {

  public Pizza createPizza(String type) {
    Pizza pizza = null;
    if(type.equals("onion")) {
      pizza = new OnionPizza();
    }
    return pizza;
  }
}