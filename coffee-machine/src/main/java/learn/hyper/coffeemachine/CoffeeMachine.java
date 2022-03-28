package learn.hyper.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int numCups = in.nextInt();
        IngredientCalculator calculator = new IngredientCalculator(200, 50, 15);
        Ingredients ingredients = calculator.calculate(numCups);
        String format = String.join(System.lineSeparator(),
                "For %d cups of coffee you will need:",
                "%d ml of water",
                "%d ml of milk",
                "%d g of coffee beans",
                ""
        );
        System.out.printf(format, numCups,
                ingredients.get(Ingredient.WATER),
                ingredients.get(Ingredient.MILK),
                ingredients.get(Ingredient.COFFEE_BEANS));
    }
}
