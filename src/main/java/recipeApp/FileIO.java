package recipeApp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO {
  private static final String INGREDIENT_FILE_NAME = "tmp/ingredients.ser";
  private static final String RECIPE_FILE_NAME = "tmp/recipes.ser";

  public ArrayList<Ingredient> loadIngredients() {
    try {
      FileInputStream fileIn = new FileInputStream(INGREDIENT_FILE_NAME);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      ArrayList<Ingredient> ingredients = (ArrayList<Ingredient>) in.readObject();
      in.close();
      fileIn.close();

      return ingredients;
    } catch (IOException i) {
      i.printStackTrace();
      return new ArrayList<Ingredient>();
    } catch (ClassNotFoundException c) {
      System.out.println("Ingredient class not found");
      c.printStackTrace();
      return new ArrayList<Ingredient>();
    }
  }

  public ArrayList<Recipe> loadRecipes() {
    try {
      FileInputStream fileIn = new FileInputStream(RECIPE_FILE_NAME);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      ArrayList<Recipe> recipes = (ArrayList<Recipe>) in.readObject();
      in.close();
      fileIn.close();

      return recipes;
    } catch (IOException i) {
      i.printStackTrace();
      return new ArrayList<Recipe>();
    } catch (ClassNotFoundException c) {
      System.out.println("Recipe class not found");
      c.printStackTrace();
      return new ArrayList<Recipe>();
    }
  }

  public void saveIngredients(ArrayList<Ingredient> ingredients) {
    try {
      FileOutputStream fileOut = new FileOutputStream(INGREDIENT_FILE_NAME);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(ingredients);

      out.close();
      fileOut.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void saveRecipes(ArrayList<Recipe> recipes) {
    try {
      FileOutputStream fileOut = new FileOutputStream(RECIPE_FILE_NAME);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(recipes);

      out.close();
      fileOut.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
