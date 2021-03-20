package recipeApp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import recipeApp.Ingredient.Unit;

public class Tests {

  @Test
  /**
   * Controlls that if a recipe contains many of the same ingredient that it is only being returned once.
   */
  public void searchTest_ingredientName_several_same_ingredient() {
    // Setup the scanner to respond with "kokos".
    ByteArrayInputStream in = new ByteArrayInputStream("kokos".getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    ConsoleUI ui = new ConsoleUI(scanner);
    IngredientName ingredientNameSearcher = new IngredientName(ui);

    // Creates a recipe with 3 "kokos" ingredients.
    Recipe extremeRecipe = new Recipe("extreme", 4, "...");
    Ingredient kokos = new Ingredient("kokos", Unit.GRAMS, 1.0);
    Ingredient egg = new Ingredient("egg", Unit.PIECE, 2.0);
    RecipeIngredient recipeIngredient1 = new RecipeIngredient(kokos, 10, "");
    RecipeIngredient recipeIngredient2 = new RecipeIngredient(kokos, 20, "second");
    RecipeIngredient recipeIngredient3 = new RecipeIngredient(kokos, 30, "add more");
    RecipeIngredient recipeIngredient4 = new RecipeIngredient(egg, 3, "");
    extremeRecipe.addIngredient(recipeIngredient1);
    extremeRecipe.addIngredient(recipeIngredient2);
    extremeRecipe.addIngredient(recipeIngredient3);
    extremeRecipe.addIngredient(recipeIngredient4);

    // Creates a recipe with no "kokos" in it.
    Recipe normalRecipe = new Recipe("Boiled egg", 4, "Add the egg in the boiling water. Let it boil for 6 mins.");
    Ingredient water = new Ingredient("water", Unit.LITRE, 0.0);
    RecipeIngredient recipeIngredient5 = new RecipeIngredient(egg, 1, "");
    RecipeIngredient recipeIngredient6 = new RecipeIngredient(water, 1, "boiling");
    normalRecipe.addIngredient(recipeIngredient5);
    normalRecipe.addIngredient(recipeIngredient6);

    // The list of recipes to search from.
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    recipes.add(extremeRecipe);
    recipes.add(normalRecipe);

    // The expected list to be returned.
    ArrayList<Recipe> expectedRecipes = new ArrayList<Recipe>();
    expectedRecipes.add(extremeRecipe);

    assertEquals("The same recipe was added more than once", expectedRecipes, ingredientNameSearcher.search(recipes));

    scanner.close();
  }
}
