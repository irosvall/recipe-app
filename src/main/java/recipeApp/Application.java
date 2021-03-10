package recipeApp;

import java.util.ArrayList;

public class Application {
  private FileIO fileHandler;
  private ConsoleUI ui;
  private Searcher searcher;
  private ArrayList<Recipe> recipes;
  private ArrayList<Ingredient> ingredients;

  Application() {
    fileHandler = new FileIO();
    ui = new ConsoleUI();
    searcher = new Searcher();
    recipes = new ArrayList<>();
    ingredients = new ArrayList<>();
  }

  private void run() {
    start();
  }

  private void start() {
    
  }

  public static void main(String[] args) {
    try {
      Application app = new Application();
      app.run();
    } catch (Exception error) {
      error.printStackTrace();
    }
  } 
}
