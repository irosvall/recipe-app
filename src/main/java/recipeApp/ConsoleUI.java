package recipeApp;

import java.util.Scanner;

public class ConsoleUI {
  private Scanner scanner;

  ConsoleUI(Scanner scanner) {
    this.scanner = scanner;
  }

  /**
   * Represents the actions a user can perform from the menu.
   */
  public enum MenuAction {
    ADD, DELETE, LIST, SEARCH, QUIT, None,
  }

  /**
   * Represents the actions a user can perform from when choosing recipe or
   * ingredient.
   */
  public enum RecipeOrIngredientAction {
    RECIPE, INGREDIENT, None,
  }

  /**
   * Represents the actions a user can perform from during yes or no questions.
   */
  public enum YesOrNoAction {
    YES, NO, None,
  }

  public void print(String value) {
    System.out.println(value);
  }

  /**
   * Let's the user choose a menu action.
   */
  public MenuAction promptForMenuAction() {
    printMenu();

    int answer;

    do {
      answer = getInputInteger();
    } while (answer < 1 || answer > 5);

    switch (answer) {
    case 1:
      return MenuAction.ADD;
    case 2:
      return MenuAction.DELETE;
    case 3:
      return MenuAction.LIST;
    case 4:
      return MenuAction.SEARCH;
    case 5:
      return MenuAction.QUIT;
    default:
      return MenuAction.None;
    }
  }

  private void printMenu() {
    System.out.println("");
    String[] actions = new String[] { "Add a recipe or ingredient", "Remove a recipe or ingredient",
        "List all recipes or ingredients", "Search for recipes", "Quit the application" };
    printList(actions);
  }

  public RecipeOrIngredientAction promptForRecipeOrIngredient() {
    printRecipeOrIngredient();

    int answer;

    do {
      answer = getInputInteger();
    } while (answer < 1 || answer > 3);

    switch (answer) {
    case 1:
      return RecipeOrIngredientAction.RECIPE;
    case 2:
      return RecipeOrIngredientAction.INGREDIENT;
    default:
      return RecipeOrIngredientAction.None;
    }
  }

  public YesOrNoAction promptForYesOrNo() {
    String[] yesOrNo = new String[] { "yes", "no" };
    printList(yesOrNo);

    int answer;
    do {
      answer = getInputInteger();
    } while (answer < 1 || answer > 2);

    switch (answer) {
    case 1:
      return YesOrNoAction.YES;
    case 2:
      return YesOrNoAction.NO;
    default:
      return YesOrNoAction.None;
    }
  }

  private void printRecipeOrIngredient() {
    System.out.println("Choose between:");
    String[] actions = new String[] { "Recipe", "Ingredient", "Go back to main menu" };
    printList(actions);
  }

  private void printList(String[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.println((i + 1) + ". " + values[i]);
    }
  }

  private int getInputInteger() {
    if (scanner.hasNextInt()) {
      int answer = scanner.nextInt();
      scanner.nextLine();
      return answer;
    } else {
      scanner.next();
      return -1;
    }
  }

  private Double getInputDouble() {
    if (scanner.hasNextDouble()) {
      Double answer = scanner.nextDouble();
      scanner.nextLine();
      return answer;
    } else {
      scanner.next();
      return -1.0;
    }
  }

  private String getInputString() {
    return scanner.nextLine();
  }

  /**
   * Returns the index of the chosen value from an array.
   */
  public int promptChooseValue(String[] values) {
    System.out.println("Choose one:");
    System.out.println("0. Go back to main menu");
    printList(values);

    int answer;
    do {
      answer = getInputInteger();
    } while (answer < 0 || answer > values.length);

    return answer - 1;
  }

  public String promptForName() {
    System.out.println("Give a name:");

    String name;
    do {
      name = getInputString();
    } while (name.length() < 1);

    return name;
  }

  public Ingredient.Unit promptForMeasureUnit() {
    System.out.println("Choose a unit of measure:");
    String[] units = new String[] { "Grams", "Litre", "Piece", "Cup", "Tablespoon", "Teaspoon" };
    printList(units);

    int answer;
    do {
      answer = getInputInteger();
    } while (answer < 1 || answer > units.length);

    switch (answer) {
    case 1:
      return Ingredient.Unit.GRAMS;
    case 2:
      return Ingredient.Unit.LITRE;
    case 3:
      return Ingredient.Unit.PIECE;
    case 4:
      return Ingredient.Unit.CUP;
    case 5:
      return Ingredient.Unit.TABLESPOON;
    case 6:
      return Ingredient.Unit.TEASPOON;
    default:
      return Ingredient.Unit.GRAMS;
    }
  }

  public Double promptForPrice() {
    System.out.println("Give a positive number of how much it should cost:");

    Double price;
    do {
      price = getInputDouble();
    } while (price < 0);

    return price;
  }

  public int promptForPortions() {
    System.out.println("Enter how many portions the recipe should be for:");

    int answer;
    do {
      answer = getInputInteger();
    } while (answer < 1);

    return answer;
  }

  public String promptForInstructions() {
    System.out.println("Enter instructions for the recipe:");

    String instructions;
    do {
      instructions = getInputString();
    } while (instructions.length() < 1);

    return instructions;
  }

  public int promptForIngredientAmount() {
    System.out.println("Enter the amount of the ingredient:");

    int answer;
    do {
      answer = getInputInteger();
    } while (answer < 1);

    return answer;
  }

  public String promptForIngredientComments() {
    System.out.println("If you wish to add any comments to the ingredient enter it now, otherwise enter blank:");

    String answer = getInputString();
    return answer;
  }

  public Double promptForMaxPrice() {
    System.out.println("Enter the maximum price for recipes you want to see:");

    Double answer;
    do {
      answer = getInputDouble();
    } while (answer < 0);

    return answer;
  }

  public Searcher.SearchStrategyAction promptForSearchStrategy() {
    System.out.println("Choose search strategy:");
    String[] strategies = new String[] { "By ingredient name", "By max price", "Go back to main menu" };
    printList(strategies);

    int answer;
    do {
      answer = getInputInteger();
    } while (answer < 1 || answer > strategies.length);

    switch (answer) {
    case 1:
      return Searcher.SearchStrategyAction.INGREDIENT_NAME;
    case 2:
      return Searcher.SearchStrategyAction.MAX_PRICE;
    default:
      return Searcher.SearchStrategyAction.None;
    }
  }
}
