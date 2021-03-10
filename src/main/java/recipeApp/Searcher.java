package recipeApp;

import java.util.ArrayList;

public class Searcher {
  private SearchStrategy strategy;

  Searcher() {
    strategy = new IngredientName();
  }

  public void setStrategy(SearchStrategy strategy) {
    this.strategy = strategy;
  }

  public ArrayList<Recipe> search(String value, ArrayList<Recipe> recipes) {
    return strategy.search(value, recipes);
  }
}
