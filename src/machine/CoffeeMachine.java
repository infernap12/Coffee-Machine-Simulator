package machine;

import static machine.CoffeeMachine.drinksMenu.Menu;
import static machine.CoffeeMachine.drinksMenu.drinksMenuInit;
import static machine.IngredientType.*;

public class CoffeeMachine {
    public static Ingredient waterTank = new Ingredient(WATER, 400);
    public static Ingredient milkTank = new Ingredient(MILK,540);
    public static Ingredient coffeeTank = new Ingredient(COFFEE_BEANS, 120);
    public static Ingredient moneyTank = new Ingredient(MONEY,550);
    public static Ingredient cupTank = new Ingredient(DISPOSABLE_CUPS,9);
    public static Ingredient[] tank = {waterTank,milkTank,coffeeTank,moneyTank,cupTank};
    public static void main(String[] args) {
        drinksMenuInit();
        //while true *menu* will go here
        userMenu();
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int water = scanner.nextInt();//waterTank.amount;
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milk = scanner.nextInt();//milkTank.amount;
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int beans = scanner.nextInt();//coffeeTank.amount;
//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsWanted = scanner.nextInt();//InputUtils.getInt();
//        int possibleCupsWater = water / 200;//cupOfCoffee.getAmount(WATER);
//        int possibleCupsMilk = milk / 50;//cupOfCoffee.getAmount(MILK);
//        int possibleCupsBeans = beans / 15;//cupOfCoffee.getAmount(COFFEE_BEANS);
//        int possibleCups = Math.min(possibleCupsMilk,Math.min(possibleCupsWater,possibleCupsBeans));
//        if (cupsWanted == possibleCups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        }
//        if (cupsWanted < possibleCups) {
//            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", possibleCups - cupsWanted);
//        }
//        if (cupsWanted > possibleCups) {
//            System.out.printf("No, I can make only %d cup(s) of coffee%n", possibleCups);
//        }
//        System.out.println();
//        System.out.printf("For %d cups of coffee you will need:\n",input);
//        System.out.printf("%d %s of %s\n", cupOfCoffee.getAmount(WATER) * input, cupOfCoffee.getUnit(WATER), cupOfCoffee.getName(WATER));
//        System.out.printf("%d %s of %s\n", cupOfCoffee.getAmount(MILK) * input, cupOfCoffee.getUnit(MILK), cupOfCoffee.getName(MILK));
//        System.out.printf("%d %s of %s\n", cupOfCoffee.getAmount(COFFEE_BEANS) * input, cupOfCoffee.getUnit(COFFEE_BEANS), cupOfCoffee.getName(COFFEE_BEANS));
    }

    private static void userMenu() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = InputUtils.getString("buy","fill","take","remaining","exit");
            System.out.println();
            switch (action) {
                case "buy" -> buyMenu();
                case "fill" -> refill(waterTank,milkTank,coffeeTank,cupTank);
                case "take" -> {
                    System.out.println("I gave you " + moneyTank.getAmountUnit());
                    moneyTank.take(moneyTank.amount);
                }
                case "remaining" -> printStatus(waterTank,milkTank,coffeeTank,cupTank,moneyTank);
                case "exit" -> {
                    return;
                }
            }
            System.out.println();
        }
    }

    private static void buyMenu() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String input = InputUtils.getString("1","2","3","back");
        switch (input) {
            case "1", "2", "3" -> {
                int i = Integer.parseInt(input);
               Drink drink = Menu[i-1];
                if (testTank(drink)) {
                    makeCoffee(drink);
                }
            }
            case "back" -> {
            }
        }
    }

    private static boolean testTank(Drink drink) {
        for (Ingredient ing : drink.ingredients) {
            for (Ingredient tankIng : tank) {
                if (tankIng.equals(ing)) {
                    if (tankIng.amount < ing.amount) {
                        System.out.printf("Sorry, not enough %s!%n", tankIng.getName());
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    private static void makeCoffee(Drink drink) {
        for (Ingredient ingredient : drink.ingredients) {
            for (Ingredient tank : tank) {
                if (ingredient.equals(tank)) {
                    tank.take(ingredient.amount);
                    break;
                }
            }
        }
        moneyTank.add(drink.price);
        cupTank.take(1);
        System.out.println("I have enough resources, making you a coffee!");
    }

    private static void refill(Ingredient... args) {
        for (Ingredient arg : args) {
            System.out.printf("Write how many %s you want to add:%n", arg.getLongDisplayString());
            int input = InputUtils.getClampedInt(0,Integer.MAX_VALUE-arg.amount);
            arg.add(input);
        }
    }

    private static void printStatus(Ingredient... args) {
        System.out.println("The coffee machine has:");
        for (Ingredient arg : args) {
            System.out.println(arg.getDisplayString());
        }

    }

    static class drinksMenu {
        public static Drink ESPRESSO;
        public static Drink LATTE;
        public static Drink CAPPUCCINO;
        public static Drink[] Menu;
        public static void drinksMenuInit() {
            ESPRESSO = new Drink(1,
                    "espresso",
                    4,
                    new Ingredient(WATER,250),
                    new Ingredient(COFFEE_BEANS,16));
            LATTE = new Drink(2,
                    "latte",
                    7,
                    new Ingredient(WATER,350),
                    new Ingredient(MILK,75),
                    new Ingredient(COFFEE_BEANS,20));
            CAPPUCCINO = new Drink(3,
                    "cappuccino",
                    6,
                    new Ingredient(WATER,200),
                    new Ingredient(MILK,100),
                    new Ingredient(COFFEE_BEANS,12));
            Menu = new Drink[]{ESPRESSO, LATTE, CAPPUCCINO};

        }
    }
}
//Large amount of over prep in preparation for insanity.
