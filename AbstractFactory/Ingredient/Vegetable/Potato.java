package Ingredient.Vegetable;

public class Potato extends Vegetable {
  public Potato() {
    name = "potato";
  }

  public String getVegetable() {
    System.out.println("The vegetable is :" + name);
    return this.name;
  }
}