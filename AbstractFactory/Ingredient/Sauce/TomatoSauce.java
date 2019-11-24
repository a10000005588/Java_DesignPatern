package Ingredient.Sauce;

public class TomatoSauce extends Sauce {
  public TomatoSauce() {
    name = "tomato sauce";
  }

  public String getSauce() {
    System.out.println("The sauce is :" + name);
    return this.name;
  }
}