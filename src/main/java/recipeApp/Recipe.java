package recipeApp;

import java.util.ArrayList;

public class Recipe {
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
}
