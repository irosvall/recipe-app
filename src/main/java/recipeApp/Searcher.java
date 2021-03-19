package recipeApp;

import java.util.ArrayList;

public class Searcher {
  private SearchStrategy strategy;

  Searcher(SearchStrategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(SearchStrategy strategy) {
    this.strategy = strategy;
  }

  public ArrayList<Recipe> search(ArrayList<Recipe> recipes) {
    return strategy.search(recipes);
  }
}
