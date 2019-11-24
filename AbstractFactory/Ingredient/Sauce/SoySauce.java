package Ingredient.Sauce;

public class SoySauce extends Sauce {
    public SoySauce() {
        name = "soy sauce";
    }

    public String getSauce() {
        System.out.println("The sauce is :" + name);
        return this.name;
    }
}