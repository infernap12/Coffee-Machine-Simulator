package machine;

public class Drink {
    int menuIndex;
    String name;
    int price;
    Ingredient[] ingredients;

    public Drink(int menuIndex, String name, int price, Ingredient... ingredients) {
        this.name = name;
        this.price = price;
        this.menuIndex = menuIndex;
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
                return ingredient.getAmountUnit();
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

    String getMenuString() {
        return "%d - %s".formatted(this.menuIndex,this.name);
    }
}
