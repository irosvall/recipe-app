package recipeApp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO {
  private final String INGREDIENT_FILE_NAME = "ingredients.ser";
  private final String RECIPE_FILE_NAME = "recipes.ser";

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

  public void saveIngredients(ArrayList<Ingredient> ingredients) {
    save(ingredients, INGREDIENT_FILE_NAME);
  }

  public void saveRecipes(ArrayList<Recipe> recipes) {
    save(recipes, RECIPE_FILE_NAME);
  }

  /**
   * Loads recipes from file.
   */
  private ArrayList<?> load(String filePath) {
    try {
      FileInputStream fileIn = new FileInputStream(filePath);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      ArrayList<?> objects = (ArrayList<?>) in.readObject();

      in.close();
      fileIn.close();
      return objects;
    } catch (IOException e) {
      return null;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Saves objects to file.
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
