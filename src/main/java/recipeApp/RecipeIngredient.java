package recipeApp;

import java.io.Serializable;

public class RecipeIngredient implements Serializable {
  private static final long serialVersionUID = -8009562172289137924L;
  
  private Ingredient ingredient;
  private Double amount;
  private String comments;

  RecipeIngredient(Ingredient ingredient, Double amount, String comments) {
    this.ingredient = ingredient;
    this.amount = amount;
    this.comments = comments;
  }

  public Double getAmount() {
    return amount;
  }

  public String getComments() {
    return comments;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }
}
