package recipeApp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO {
  private final String INGREDIENT_FILE_NAME = "tmp/ingredients.ser";
  private final String RECIPE_FILE_NAME = "tmp/recipes.ser";

  public ArrayList<Ingredient> loadIngredients() {
    ArrayList<?> ingredients = load(INGREDIENT_FILE_NAME);

    if (ingredients == null) {
      return new ArrayList<Ingredient>();
    }

    return (ArrayList<Ingredient>) ingredients;
  }

  public ArrayList<Recipe> loadRecipes() {
    ArrayList<?> recipes = load(RECIPE_FILE_NAME);

    if (recipes == null) {
      return new ArrayList<Recipe>();
    }

    return (ArrayList<Recipe>) recipes;
  }

  /**
   * Loads recipes from file. Code inspiration gathered from:
   * https://www.tutorialspoint.com/java/java_serialization.htm.
   */
  private ArrayList<?> load(String filePath) {
    try {
      FileInputStream fileIn = new FileInputStream(filePath);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      ArrayList<?> objects = (ArrayList<?>) in.readObject();
      in.close();
      fileIn.close();

      return objects;
    } catch (IOException i) {
      i.printStackTrace();
      return null;
    } catch (ClassNotFoundException c) {
      c.printStackTrace();
      return null;
    }
  }

  public void saveIngredients(ArrayList<Ingredient> ingredients) {
    save(ingredients, INGREDIENT_FILE_NAME);
  }

  public void saveRecipes(ArrayList<Recipe> recipes) {
    save(recipes, RECIPE_FILE_NAME);
  }

  /**
   * Saves objects to file. Code inspiration gathered from:
   * https://www.tutorialspoint.com/java/java_serialization.htm.
   */
  private void save(Iterable<?> objects, String filePath) {
    try {
      FileOutputStream fileOut = new FileOutputStream(filePath);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(objects);

      out.close();
      fileOut.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
