package learn.hyper.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public String getState() {
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffeeBeans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money";
    }

    public void run() {
        System.out.println(getState());
        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.print("Write action (buy, fill, take):\n> ");
        String action = in.nextLine();
    }

    public static void main(String[] args) {
        /*
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

         */
    }
}
