package machine;

import java.util.Arrays;

import static machine.CoffeeMachine.menu.*;
import static machine.IngredientType.*;

public class CoffeeMachine {
//    Ingredient milkTank = new Ingredient(IngredientType.MILK,1000);
//    Ingredient waterTank = new Ingredient(IngredientType.WATER, 1000);
//    Ingredient coffeeTank = new Ingredient(IngredientType.COFFEE_BEANS, 1000);
    public static void main(String[] args) {
        menuInit();
        int input = InputUtils.getInt();
        System.out.printf("For %d cups of coffee you will need:\n",input);
        System.out.printf("%d %s of %s\n", cupOfCoffee.getAmount(WATER) * input, cupOfCoffee.getUnit(WATER), cupOfCoffee.getName(WATER));
        System.out.printf("%d %s of %s\n", cupOfCoffee.getAmount(MILK) * input, cupOfCoffee.getUnit(MILK), cupOfCoffee.getName(MILK));
        System.out.printf("%d %s of %s\n", cupOfCoffee.getAmount(COFFEE_BEANS) * input, cupOfCoffee.getUnit(COFFEE_BEANS), cupOfCoffee.getName(COFFEE_BEANS));
    }

    static class menu {
        public static Drink cupOfCoffee;
        public static void menuInit() {
            Ingredient water = new Ingredient(WATER,200);
            Ingredient milk = new Ingredient(IngredientType.MILK,50);
            Ingredient beans = new Ingredient(IngredientType.COFFEE_BEANS,15);
            cupOfCoffee = new Drink("cups of coffee", Arrays.asList(water, milk, beans));
        }
//        public static int getAmount(Drink drink, IngredientType ingredientName) {
//            return drink.getAmount(ingredientName);
//        }
    }
}
//Large amount of over prep in preparation for insanity.
