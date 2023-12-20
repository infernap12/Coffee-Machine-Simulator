package machine;

import java.util.List;

public class Drink {
    String name;
    List<Ingredient> ingredients;

    public Drink(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
    public int getAmount(IngredientType ingredientName) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientName.getName())) {
                return ingredient.getAmount();
            }
        }
        return 0;
    }
    public String getUnit(IngredientType ingredientName) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientName.getName())) {
                return ingredient.getUnit();
            }
        }
        return "0";
    }
    public String getName(IngredientType ingredientName) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientName.getName())) {
                return ingredient.getName();
            }
        }
        return "0";
    }
}
