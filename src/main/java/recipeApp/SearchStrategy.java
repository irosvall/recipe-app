package recipeApp;

import java.util.ArrayList;

public interface SearchStrategy {
  public ArrayList<Recipe> search(String value, ArrayList<Recipe> recipes);
}
