package recipeApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
  private static final long serialVersionUID = -1895452190258298515L;

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

  @Override
  public String toString() {
    String details = "\nRecipe: " + getName() + "\n" + getPortions() + " portions, cost: " + getPrice() + "\n";

    for (RecipeIngredient recipeIngredient : ingredients) {
      details += recipeIngredient.toString() + "\n";
    }
    details += "\n" + getInstructions();

    return details;
  }
}
