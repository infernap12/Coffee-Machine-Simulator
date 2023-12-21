package machine;
/**
 * Enum representing different types of ingredients used in a machine.
 * Each type of ingredient has a specific unit of measurement and format for display.
 * <p>
 * Example usage with Ingredient class:
 * <pre>{@code
 * Ingredient coffeeBeans = new Ingredient(IngredientType.COFFEE_BEANS, 120);
 * }</pre>
 */
public enum IngredientType {
    MILK("%d ml","%s of %s","ml"),
    WATER("%d ml", "%s of %s","ml"),
    COFFEE_BEANS("%d g", "%s of %s","grams"),
    MONEY("$%d", "%s of %s","$"),
    DISPOSABLE_CUPS("%d", "%s %s","");
    private final String unitDisplay;
    private final String formatString;
    private final String unit;
    /**
     * Constructor for IngredientType.
     *
     * @param unitDisplay Format string for displaying the unit. See {@link #getUnitDisplay()}.
     * @param formatString Format string for displaying the ingredient. See {@link #getFormatString()}.
     * @param unit Unit of measurement for the ingredient. See {@link #getUnit()}.
     */
    IngredientType(String unitDisplay, String formatString, String unit) {
        this.unitDisplay = unitDisplay;
        this.formatString = formatString;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
    public String getUnitDisplay() {
        return unitDisplay;
    }
    /**
     * Retrieves the format string for displaying an ingredient's quantity along with its name.
     * This format string is designed for use with {@link String#format(String, Object...)} to create
     * a standardized representation of the ingredient.
     *
     * For example, for COFFEE_BEANS, the format string "%s of %s" would result in a display like
     * "120 g of coffee beans" when formatted with the quantity and ingredient name.
     *
     * @return The format string for displaying the ingredient.
     */
    public String getFormatString() {
        return formatString;
    }
    /**
     * Gets the name of the ingredient in lowercase and spaces instead of underscores.
     * This is a formatted version of the enum constant name.
     *
     * @return The formatted name of the ingredient.
     */
    public String getName() {
        return this.toString().toLowerCase().replace('_', ' ');
    }
    }
