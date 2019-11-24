package AbstractIngredientFactory;

import Ingredient.Sauce.*;
import Ingredient.Vegetable.*;

public class AmericaIngredientFactory implements PizzaIngredientFactory {
  public Sauce createSauce() {
    return new TomatoSauce();
  }
  public Vegetable createVegetable() {
    return new Potato();
  }
}