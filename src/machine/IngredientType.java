package machine;

public enum IngredientType {
    MILK("ml"),
    WATER("ml"),
    COFFEE_BEANS("g");
    private final String defaultUnit;

    IngredientType(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }
    public String getName() {
        return this.toString().toLowerCase().replace('_',' ');
    }
}
