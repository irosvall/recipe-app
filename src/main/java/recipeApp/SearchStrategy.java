package recipeApp;

import java.util.ArrayList;

public interface SearchStrategy {
  public ArrayList<Recipe> search(ArrayList<Recipe> recipes);
}
