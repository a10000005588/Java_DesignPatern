package AbstractIngredientFactory;

import Ingredient.Sauce.*;
import Ingredient.Vegetable.*;

public class ChineseIngredientFactory implements PizzaIngredientFactory {
  public Sauce createSauce() {
    return new SoySauce();
  }
  public Vegetable createVegetable() {
    return new Onion();
  }
}