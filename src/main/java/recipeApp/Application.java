package recipeApp;

import java.util.ArrayList;
import java.util.Scanner;

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
        ui.promptForRecipeOrIngredient();
        break;
      case REMOVE:
        ui.promptForRecipeOrIngredient();
        break;
    }
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
