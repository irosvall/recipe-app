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
    ADD, REMOVE, LIST, QUIT, None
  }

  /**
   * Represents the actions a user can perform from when choosing recipe or
   * ingredient.
   */
  public enum RecipeOrIngredientAction {
    RECIPE, INGREDIENT, None
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
    } while (answer < 1 || answer > 4);

    switch (answer) {
    case 1:
      return MenuAction.ADD;
    case 2:
      return MenuAction.REMOVE;
    case 3:
      return MenuAction.LIST;
    case 4:
      return MenuAction.QUIT;
    default:
      return MenuAction.None;
    }
  }

  private void printMenu() {
    String[] actions = new String[] { "Add a recipe or ingredient", "Remove a recipe or ingredient",
        "List all recipes or ingredients", "Quit the application" };
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
      return scanner.nextInt();
    } else {
      scanner.next();
      return -1;
    }
  }

  private String getInputString() {
    if (scanner.hasNextLine()) {
      return scanner.nextLine();
    } else {
      scanner.next();
      return "";
    }
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
}
