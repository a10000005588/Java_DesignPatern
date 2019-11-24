package SimplePizzaFactory;

import Pizza.Pizza;
import Pizza.CheesePizza;
import Pizza.PotatoPizza;

public class SimplePizzaFactory {
  public void orderPizza(String type) {
    Pizza pizza = null;
    pizza = createPizza(type);
    pizza.prepare();
    pizza.bake();
  }

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