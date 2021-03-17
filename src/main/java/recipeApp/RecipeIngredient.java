package recipeApp;

import java.io.Serializable;

public class RecipeIngredient implements Serializable {
  private static final long serialVersionUID = -8009562172289137924L;
  
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

  public String getUnit() {
    return ingredient.getUnit();
  }

  public int getAmount() {
    return amount;
  }

  public String getComments() {
    return comments;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }

  @Override
  public String toString() {
    return getAmount() + " " + getUnit() + " " + getName() + " (" + getComments() + ")";
  }
}
