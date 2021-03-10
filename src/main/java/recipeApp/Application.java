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
    
  }

  public static void main(String[] args) {
    Application app = new Application();
    app.run();
  }
}
