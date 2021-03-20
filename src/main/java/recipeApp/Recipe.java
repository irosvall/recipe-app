package recipeApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
  private static final long serialVersionUID = 754188805358468565L;

  private String name;
  private int portions;
  private String instructions;
  private ArrayList<RecipeIngredient> ingredients;

  Recipe(String name, int portions, String instructions) {
    this.name = name;
    this.portions = portions;
    this.instructions = instructions;
    ingredients = new ArrayList<>();
  }

  public ArrayList<RecipeIngredient> getIngredients() {
    return ingredients;
  }

  public String getInstructions() {
    return instructions;
  }

  public String getName() {
    return name;
  }

  public int getPortions() {
    return portions;
  }

  public Double getPrice() {
    Double price = 0.0;

    for (RecipeIngredient recipeIngredient : ingredients) {
      price += recipeIngredient.getPrice();
    }

    return price;
  }

  public Double getPrice(Double multiplier) {
    Double price = 0.0;

    for (RecipeIngredient recipeIngredient : ingredients) {
      price += recipeIngredient.getPrice(multiplier);
    }

    return price;
  }

  public void addIngredient(RecipeIngredient ingredient) {
    ingredients.add(ingredient);
  }

  @Override
  public String toString() {
    String details = "\nRecipe: " + getName() + "\n" + getPortions() + " portions, cost: " + getPrice() + "\n";

    for (RecipeIngredient recipeIngredient : ingredients) {
      details += recipeIngredient.toString() + "\n";
    }
    details += "\n" + getInstructions();

    return details;
  }

  /**
   * Returns a string with details of the recipe depending on how many portions is wanted.
   * If recipe contains non-divideable ingredients,
   * then the nearest even divisor above the desired number of portions is used.
   */
  public String toString(int portions) {
    int finalPortions = portions;

    while (!isValidPortions(finalPortions)) {
      finalPortions++;
    }

    Double multiplier = ((double) finalPortions) / getPortions();

    String details = "\nRecipe: " + getName() + "\n" + finalPortions + " portions, cost: " + getPrice(multiplier) + "\n";

    for (RecipeIngredient recipeIngredient : ingredients) {
      details += recipeIngredient.toString(multiplier) + "\n";
    }
    details += "\n" + getInstructions();

    return details;
  }

  private boolean isValidPortions(int portions) {
    Double multiplier = ((double) portions) / getPortions();

    for (RecipeIngredient recipeIngredient : ingredients) {
      if (recipeIngredient.getUnit().equals("piece")) {
        if (recipeIngredient.getAmount(multiplier) % 1 != 0) {
          return false;
        }
      }
    }
    return true;
  }
}
