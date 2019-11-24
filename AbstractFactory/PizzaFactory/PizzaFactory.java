package PizzaFactory;

import Pizza.*;

public abstract class PizzaFactory {
  public void orderPizza(String type) {
    Pizza pizza = null;
    pizza = createPizza(type);
    pizza.prepare();
    pizza.bake();
  }

  abstract Pizza createPizza(String type);
}