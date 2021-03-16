package recipeApp;

import java.io.Serializable;

public class Ingredient implements Serializable {
  private static final long serialVersionUID = 4982160459632845008L;

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

  public String getUnit() {
    return unit.name().toLowerCase();
  }

  @Override
  public String toString() {
    return "Ingredient: " + name + ", unit: " + unit + ", price: " + price;
  }
}
