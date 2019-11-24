package PizzaFactory.Factory;

import Pizza.*;

public class OriginalPizzaFactory extends PizzaFactory {

  public Pizza createPizza(String type) {
    Pizza pizza = null;
    if(type.equals("cheese")) {
      pizza = new CheesePizza();
    } else if (type.equals("potato")) {
      pizza = new PotatoPizza();
    }
    return pizza;
  }
}