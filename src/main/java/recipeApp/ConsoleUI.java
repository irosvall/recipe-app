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
}
