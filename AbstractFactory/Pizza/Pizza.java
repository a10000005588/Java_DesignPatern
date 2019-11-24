package Pizza;

import Ingredient.Sauce.*;
import Ingredient.Vegetable.*;

public abstract class Pizza {
  String name;
  
  Sauce sauce;
  Vegetable vegetable;
  
  // 將prepare修改成抽象，該方法需要收集Pizza所需的原料，原料來自於原料工廠！
  public abstract void prepare();

  public void bake() {
    System.out.println("Bake for 30 mins");
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}