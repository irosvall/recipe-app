package recipeApp;

import java.util.ArrayList;
import java.util.Scanner;

import recipeApp.ConsoleUI.RecipeOrIngredientAction;

public class Application {
  private FileIO fileHandler;
  private ConsoleUI ui;
  private Searcher searcher;
  private ArrayList<Recipe> recipes;
  private ArrayList<Ingredient> ingredients;

  Application(Scanner scanner) {
    fileHandler = new FileIO();
    ui = new ConsoleUI(scanner);
    searcher = new Searcher();

    recipes = fileHandler.loadRecipes();
    ingredients = fileHandler.loadIngredients();
  }

  private void run() {
    start();
  }

  private void start() {
    ConsoleUI.MenuAction action;
    do {
      action = ui.promptForMenuAction();
      switch (action) {
      case ADD: {
        ConsoleUI.RecipeOrIngredientAction choice = ui.promptForRecipeOrIngredient();
        if (choice == RecipeOrIngredientAction.RECIPE) {
          addRecipe();
        } else if (choice == RecipeOrIngredientAction.INGREDIENT) {
          addIngredient();
        }
        break;
      }
      case DELETE: {
        ConsoleUI.RecipeOrIngredientAction choice = ui.promptForRecipeOrIngredient();
        if (choice == RecipeOrIngredientAction.RECIPE) {
          deleteRecipe();
        } else if (choice == RecipeOrIngredientAction.INGREDIENT) {
          deleteIngredient();
        }
        break;
      }
      case LIST: {
        ConsoleUI.RecipeOrIngredientAction choice = ui.promptForRecipeOrIngredient();
        if (choice == RecipeOrIngredientAction.RECIPE) {
          listRecipes();
        } else if (choice == RecipeOrIngredientAction.INGREDIENT) {
          listIngredients();
        }
        break;
      }
      case None:
        break;
      case QUIT: {
        fileHandler.saveIngredients(ingredients);
        fileHandler.saveRecipes(recipes);
        break;
      }
      default:
        break;
      }
    } while (action != ConsoleUI.MenuAction.QUIT);
  }

  private void listIngredients() {
  }

  private void listRecipes() {
    ui.print("Choose one for details");

  }

  private void addRecipe() {
    String name = ui.promptForName();
    int portions = ui.promptForPortions();
    String instructions = ui.promptForInstructions();

    Recipe recipe = new Recipe(name, portions, instructions);

    String[] yesOrNo = new String[] { "yes", "no" };
    int answer;

    do {
      answer = ui.promptChooseValue(yesOrNo);
      if (shouldGoBackToMenu(answer)) {
        return;
      }
      if (answer == 0) {

      }
    } while (answer != 1);

    recipes.add(recipe);
  }

  /**
   * Returns the index if a recipe is choosen, otherwise -1.
   */
  private int chooseRecipe() {
    String[] recipeNames = getRecipeNames();

    if (recipeNames.length > 0) {
      int index = ui.promptChooseValue(recipeNames);
      if (shouldGoBackToMenu(index)) {
        return -1;
      }
      return index;
    } else {
      ui.print("There are no recipes.");
      return -1;
    }
  }

  /**
   * Returns the index if a ingredient is choosen, otherwise -1.
   */
  private int chooseIngredient() {
    String[] ingredientNames = getIngredientNames();

    if (ingredientNames.length > 0) {
      int index = ui.promptChooseValue(ingredientNames);
      if (shouldGoBackToMenu(index)) {
        return -1;
      }
      return index;
    } else {
      ui.print("There are no ingredients.");
      return -1;
    }
  }

  private void addIngredient() {
    String name = ui.promptForName();
    while (!IngredientIsUnique(name)) {
      ui.print("The ingredient already exist.");
      name = ui.promptForName();
    }
    Ingredient.Unit unit = ui.promptForMeasureUnit();
    Double price = ui.promptForPrice();

    Ingredient ingredient = new Ingredient(name, unit, price);
    ingredients.add(ingredient);
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
    int index = chooseIngredient();
    if (index != -1) {
      ingredients.remove(index);
    }
  }

  private void deleteRecipe() {
    int index = chooseRecipe();
    if (index != -1) {
      recipes.remove(index);
    }
  }

  private String[] getIngredientNames() {
    String[] ingredientNames = new String[ingredients.size()];
    for (int i = 0; i < ingredients.size(); i++) {
      ingredientNames[i] = ingredients.get(i).getName();
    }
    return ingredientNames;
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
  private boolean shouldGoBackToMenu(int value) {
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
