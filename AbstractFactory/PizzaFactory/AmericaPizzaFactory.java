package PizzaFactory;

import Pizza.*;
import AbstractIngredientFactory.*;

public class AmericaPizzaFactory extends PizzaFactory {
  protected Pizza createPizza(String style) {
    Pizza pizza = null;
    
    // 使用了美式原料工廠
    PizzaIngredientFactory ingredientFactory = new AmericaIngredientFactory();

    if(style.equals("America")) {
      pizza = new AmericaPizza(ingredientFactory);
      pizza.setName("America style pizza");
    } 

    return pizza;
  }
}