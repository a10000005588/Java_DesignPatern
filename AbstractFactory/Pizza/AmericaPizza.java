package Pizza;

import AbstractIngredientFactory.*;

public class AmericaPizza extends Pizza {
  PizzaIngredientFactory ingredientFactory;

  public AmericaPizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  public void prepare() {
    System.out.println("Preparing: " + name);

    sauce = ingredientFactory.createSauce();
    sauce.getSauce();

    vegetable = ingredientFactory.createVegetable();
    vegetable.getVegetable();
  }
}