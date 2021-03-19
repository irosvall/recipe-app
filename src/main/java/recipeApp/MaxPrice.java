package recipeApp;

import java.util.ArrayList;

public class MaxPrice implements SearchStrategy {
  private ConsoleUI ui;

  MaxPrice(ConsoleUI ui) {
    this.ui = ui;
  }

  @Override
  public ArrayList<Recipe> search(ArrayList<Recipe> recipes) {
    Double maxPrice = ui.promptForMaxPrice();
    
    ArrayList<Recipe> matchingRecipes = new ArrayList<Recipe>();
    for (Recipe recipe : recipes) {
      if (recipe.getPrice() <= maxPrice) {
        matchingRecipes.add(recipe);
      }
    }

    return matchingRecipes;
  }
}
