package AbstractIngredientFactory;

import Ingredient.Sauce.*;
import Ingredient.Vegetable.*;

public interface PizzaIngredientFactory {
  Sauce createSauce();
  Vegetable createVegetable();
}