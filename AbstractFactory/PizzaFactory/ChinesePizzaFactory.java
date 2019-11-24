package PizzaFactory;

import Pizza.*;
import AbstractIngredientFactory.*;

public class ChinesePizzaFactory extends PizzaFactory {
  protected Pizza createPizza(String style) {
    Pizza pizza = null;

    // 使用了中式原料工廠
    PizzaIngredientFactory ingredientFactory = new ChineseIngredientFactory();

    if(style.equals("Chinese")) {
      pizza = new ChinesePizza(ingredientFactory);
      pizza.setName("Chinese style pizza");
    } 

    return pizza;
  }
}