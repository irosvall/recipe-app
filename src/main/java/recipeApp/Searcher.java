package recipeApp;

import java.util.ArrayList;

public class Searcher {
  private SearchStrategy strategy;

  Searcher(SearchStrategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Represents the strategies a user can choose from.
   */
  public enum SearchStrategyAction {
    INGREDIENT_NAME, MAX_PRICE, None,
  }

  public void setStrategy(SearchStrategy strategy) {
    this.strategy = strategy;
  }

  public ArrayList<Recipe> search(ArrayList<Recipe> recipes) {
    return strategy.search(recipes);
  }
}
