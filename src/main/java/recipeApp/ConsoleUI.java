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
  public enum Action {
    ADD, REMOVE, LIST, QUIT, None
  }

  public Action promptForMenuAction() {
    printMenu();

    int answer;

    do {
      answer = getInputInteger();
    } while (answer < 1 || answer > 4);

    switch (answer) {
    case 1:
      return Action.ADD;
    case 2:
      return Action.REMOVE;
    case 3:
      return Action.LIST;
    case 4:
      return Action.QUIT;
    default:
      return Action.None;
    }
  }

  private void printMenu() {
    String[] actions = new String[] { "Add a recipe or ingredient", "Remove a recipe or ingredient",
        "List all recipes or ingredients", "Quit the application" };
    printList(actions);
  }

  private void printList(String[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.println((i + 1) + ". " + values[i]);
    }
  }

  private int getInputInteger() {
    return scanner.nextInt();
  }
}
