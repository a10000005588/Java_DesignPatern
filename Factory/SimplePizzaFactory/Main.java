package SimplePizzaFactory;

public class Main {
  public static void main(String[] args) {
    SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
    
    simplePizzaFactory.orderPizza("cheese");
    simplePizzaFactory.orderPizza("potato");
  }
}