package recipeApp;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import recipeApp.ConsoleUI.RecipeOrIngredientAction;

public class Application {
  private FileIO fileHandler;
  private ConsoleUI ui;
  private Searcher searcher;
  private ArrayList<Recipe> recipes;
  private ArrayList<Ingredient> ingredients;
  private Scanner scanner;

  Application(Scanner scanner) {
    this.scanner = scanner;
    fileHandler = new FileIO();
    ui = new ConsoleUI(scanner);
    searcher = new Searcher();
    recipes = new ArrayList<>();
    ingredients = new ArrayList<>();
  }

  private void run() {
    start();
  }

  private void start() {
    ConsoleUI.MenuAction action;
    do {
      action = ui.promptForMenuAction();
      switch (action) {
      case ADD:
        ConsoleUI.RecipeOrIngredientAction addChoice = ui.promptForRecipeOrIngredient();
        if (addChoice == RecipeOrIngredientAction.RECIPE) {
          addRecipe();
        } else if (addChoice == RecipeOrIngredientAction.INGREDIENT) {
          addIngredient();
        }
        break;
      case DELETE:
        ConsoleUI.RecipeOrIngredientAction removeChoice = ui.promptForRecipeOrIngredient();
        if (removeChoice == RecipeOrIngredientAction.RECIPE) {
          deleteRecipe();
        } else if (removeChoice == RecipeOrIngredientAction.INGREDIENT) {
          deleteIngredient();
        }
        break;
      }
    } while (action != ConsoleUI.MenuAction.QUIT);
  }

  private Recipe addRecipe() {
    String name = ui.promptForName();
    int portions = ui.promptForPortions();
    String instructions = ui.promptForInstructions();

    Recipe recipe = new Recipe(name, portions, instructions);
    recipes.add(recipe);
    return recipe;
  }

  private Ingredient addIngredient() {
    String name = ui.promptForName();
    while (!IngredientIsUnique(name)) {
      ui.print("The ingredient already exist.");
      name = ui.promptForName();
    }
    Ingredient.Unit unit = ui.promptForMeasureUnit();
    Double price = ui.promptForPrice();

    Ingredient ingredient = new Ingredient(name, unit, price);
    ingredients.add(ingredient);
    return ingredient;
  }

  /**
   * Checks if the ingredient is unique by comparing its name to other ingredients
   * names.
   */
  private boolean IngredientIsUnique(String name) {
    for (Ingredient ingredient : ingredients) {
      if (ingredient.getName().equalsIgnoreCase(name)) {
        return false;
      }
    }
    return true;
  }

  private void deleteIngredient() {
    String[] ingredientNames = getIngredientNames();

    if (ingredientNames.length > 0) {
      int index = ui.promptChooseValue(ingredientNames);
      if (isNegative(index)) {
        return;
      }
      ingredients.remove(index);
    } else {
      ui.print("There are no ingredients to delete.");
    }
  }

  private String[] getIngredientNames() {
    String[] ingredientNames = new String[ingredients.size()];
    for (int i = 0; i < ingredients.size(); i++) {
      ingredientNames[i] = ingredients.get(i).getName();
    }
    return ingredientNames;
  }

  private void deleteRecipe() {
    String[] recipeNames = getRecipeNames();

    if (recipeNames.length > 0) {
      int index = ui.promptChooseValue(recipeNames);
      if (isNegative(index)) {
        return;
      }
      recipes.remove(index);
    } else {
      ui.print("There are no recipes to delete.");
    }
  }

  private String[] getRecipeNames() {
    String[] recipeNames = new String[recipes.size()];
    for (int i = 0; i < recipes.size(); i++) {
      recipeNames[i] = recipes.get(i).getName();
    }
    return recipeNames;
  }

  /**
   * Checks if an integer is under 0. Is used to determinate if the user want go
   * back to the main menu.
   */
  private boolean isNegative(int value) {
    if (value < 0) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      Application app = new Application(scanner);
      app.run();
      scanner.close();
    } catch (Exception error) {
      error.printStackTrace();
    }
  }
}
