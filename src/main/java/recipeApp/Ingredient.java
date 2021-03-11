package recipeApp;

public class Ingredient {
  private String name;
  private Unit unit;
  private Double price;

  Ingredient(String name, Unit unit, Double price) {
    this.name = name;
    this.unit = unit;
    this.price = price;
  }

  public enum Unit {
    GRAMS, LITRE, PIECE, CUP, TABLESPOON, TEASPOON
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public Unit getUnit() {
    return unit;
  }

  @Override
  public String toString() {
    return "Ingredient: " + name + ", unit: " + unit + ", price: " + price;
  }
}
