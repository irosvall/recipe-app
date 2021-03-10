package recipeApp;

public class Ingredient {
  private String name;
  private String unit;
  private Double price;

  Ingredient(String name, String unit, Double price) {
    this.name = name;
    this.unit = unit;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public String getUnit() {
    return unit;
  }

  @Override
  public String toString() {
    return "Ingredient: " + name + ", unit: " + unit + ", price: " + price;
  }
}
