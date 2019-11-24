package Pizza;

public abstract class Pizza {
  String name;
  String ingridient;
  
  public void prepare() {
    System.out.println("Preparing: " + name);
    System.out.println("Ingredient: " + ingridient);
  }

  public void bake() {
    System.out.println("Bake for 20 mins");
  }

  String getName() {
    return name;
  }
}