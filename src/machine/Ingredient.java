package machine;
/**
 * Class representing an ingredient with a specific type and amount.
 * <p>
 * Example of creating a new Ingredient instance for coffee beans:
 * <pre>{@code
 * Ingredient coffeeBeans = new Ingredient(IngredientType.COFFEE_BEANS, 120);
 * }</pre>
 */
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
    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * Gets the name of the ingredient.
     * This is a convenience method that calls {@link IngredientType#getName()}.
     *
     * @return The ingredient's name.
     */
    public String getName() {
        return type.getName();
    }
    /**
     * Gets the amount of the ingredient with its unit.
     * This method formats the amount with the unit display string from {@link IngredientType#getUnitDisplay()}.
     *
     * Example usage:
     * <pre>{@code
     * String amountUnit = coffeeBeans.getAmountUnit();
     * // Output might be "120 g" for coffee beans
     * }</pre>
     *
     * @return A string representing the amount with unit.
     */
    public String getAmountUnit() {
        return type.getUnitDisplay().formatted(getAmount());
    }

    private String getFormatString() {
        return type.getFormatString();
    }
    /**
     * Gets a formatted string representing the ingredient.
     * This method uses the format string from {@link IngredientType#getFormatString()}.
     *
     * Example usage:
     * <pre>{@code
     * String displayString = coffeeBeans.getDisplayString();
     * // Output might be "120 g of coffee beans"
     * }</pre>
     *
     * @return A formatted display string of the ingredient.
     */
    public String getDisplayString() {
        return getFormatString().formatted(getAmountUnit(),getName());
    }
    /**
     * Gets a long formatted string representing the ingredient with its unit.
     * This method uses the format string from {@link IngredientType#getFormatString()} and includes the unit.
     *
     * Example usage:
     * <pre>{@code
     * String longDisplayString = coffeeBeans.getLongDisplayString();
     * // Output might be "grams of coffee beans"
     * }</pre>
     *
     * @return A long formatted display string of the ingredient.
     */
    public String getLongDisplayString() {
        return getFormatString().formatted(type.getUnit(),getName());
    }
    public void add(int amount) {
        this.amount += amount;
    }
    public void take(int amount) {
        this.amount -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}

