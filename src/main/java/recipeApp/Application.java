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
    ConsoleUI.MenuAction action = ui.promptForMenuAction();
    switch (action) {
    case ADD:
      ConsoleUI.RecipeOrIngredientAction choice = ui.promptForRecipeOrIngredient();
      if (choice == RecipeOrIngredientAction.RECIPE) {

      } else if (choice == RecipeOrIngredientAction.INGREDIENT) {
        addIngredient();
      }
      break;
    case REMOVE:
      ui.promptForRecipeOrIngredient();
      break;
    }
  }

  private void addIngredient() {
    String name = ui.promptForName();
    while (!IngredientIsUnique(name)) {
      ui.print("The ingredient already exist.");
      name = ui.promptForName();
    }
    Ingredient.Unit unit = ui.promptForMeasureUnit();
  }

  private boolean IngredientIsUnique(String name) {
    for (Ingredient ingredient : ingredients) {
      if (ingredient.getName().equalsIgnoreCase(name)) {
        return false;
      }
    }
    return true;
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
