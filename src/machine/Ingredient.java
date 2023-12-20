package machine;

public class Ingredient {
    IngredientType type;
    int amount;

    public Ingredient(IngredientType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public IngredientType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return type.getName();
    }
    public String getUnit() {
        return type.getDefaultUnit();
    }

}

