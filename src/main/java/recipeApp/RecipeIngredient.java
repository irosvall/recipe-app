package recipeApp;

import java.io.Serializable;

public class RecipeIngredient implements Serializable {
  private static final long serialVersionUID = -8285754010969778555L;

  private Ingredient ingredient;
  private int amount;
  private String comments;

  RecipeIngredient(Ingredient ingredient, int amount, String comments) {
    this.ingredient = ingredient;
    this.amount = amount;
    this.comments = comments;
  }

  public String getName() {
    return ingredient.getName();
  }

  public Double getPrice() {
    return ingredient.getPrice() * amount;
  }

  public Double getPrice(Double multiplier) {
    return ingredient.getPrice() * amount * multiplier;
  }

  public String getUnit() {
    return ingredient.getUnit();
  }

  public int getAmount() {
    return amount;
  }

  public Double getAmount(Double multiplier) {
    return getAmount() * multiplier;
  }

  public String getComments() {
    return comments;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }

  @Override
  public String toString() {
    String details = getAmount() + " " + getUnit() + " " + getName();

    if (getComments().equals("")) {
      details += " " + getComments();
    } else {
      details += " (" + getComments() + ")";
    }

    return details;
  }

  public String toString(Double multiplier) {
    String details;

    Double amount = getAmount(multiplier);
    if (amount % 1 == 0) {
      details = "" + amount.intValue();
    } else {
      details = "" + amount;
    }

    details += " " + getUnit() + " " + getName();

    if (getComments().equals("")) {
      details += " " + getComments();
    } else {
      details += " (" + getComments() + ")";
    }

    return details;
  }
}
