package learn.hyper.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = in.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = in.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = in.nextInt();
        Ingredients haveIngredients = new Ingredients(water, milk, beans);
        System.out.println("Write how many cups of coffee you will need:");
        int numCups = in.nextInt();
        final Ingredients perCup = new Ingredients(200, 50, 15);
        IngredientCalculator calculator = new IngredientCalculator(perCup);
        Ingredients needIngredients = calculator.calculate(numCups);

        int canMakeCups = haveIngredients.canProduceCups(perCup);
        if (haveIngredients.strictlyGreaterOrEqual(needIngredients)) {
            if (canMakeCups == numCups) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n",
                        (canMakeCups - numCups));
            }
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", canMakeCups);
        }
    }
}
