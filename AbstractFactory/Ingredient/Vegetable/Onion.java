package Ingredient.Vegetable;

public class Onion extends Vegetable {
  public Onion() {
    name = "onion";
  }
  public String getVegetable() {
    System.out.println("The vegetable is :" + name);
    return this.name;
  }
}