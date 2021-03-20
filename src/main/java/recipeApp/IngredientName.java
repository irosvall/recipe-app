package recipeApp;

import java.util.ArrayList;

public class IngredientName implements SearchStrategy {
  private ConsoleUI ui;

  IngredientName(ConsoleUI ui) {
    this.ui = ui;
  }

  @Override
  public ArrayList<Recipe> search(ArrayList<Recipe> recipes) {
    String name = ui.promptForName();

    ArrayList<Recipe> matchingRecipes = new ArrayList<Recipe>();
    for (Recipe recipe : recipes) {
      ArrayList<RecipeIngredient> ingredients = recipe.getIngredients();
      for (RecipeIngredient ingredient : ingredients) {
        if (ingredient.getName().equalsIgnoreCase(name)) {
          matchingRecipes.add(recipe);
          break;
        }
      }
    }

    return matchingRecipes;
  }

}
