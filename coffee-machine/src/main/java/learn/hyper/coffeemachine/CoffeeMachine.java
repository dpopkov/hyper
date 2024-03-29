package learn.hyper.coffeemachine;

import static learn.hyper.coffeemachine.Ingredient.*;

public class CoffeeMachine {
    private final Console console;
    private final Ingredients ingredients = new Ingredients();
    private int cups;
    private int money;

    public CoffeeMachine(Console console, Ingredients initial, int cups, int money) {
        this.console = console;
        ingredients.add(initial);
        this.cups = cups;
        this.money = money;
    }

    public String getState() {
        return "The coffee machine has:\n" +
                ingredients.get(WATER) + " ml of water\n" +
                ingredients.get(MILK) + " ml of milk\n" +
                ingredients.get(COFFEE_BEANS) + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money";
    }

    public void sellCupOf(Coffee coffee) {
        ingredients.subtract(coffee.getIngredients());
        cups--;
        money += coffee.getCost();
    }

    public void fill(Ingredients other, int numCups) {
        ingredients.add(other);
        cups += numCups;
    }

    public int take() {
        int result = money;
        money = 0;
        return result;
    }

    public void run() {
        console.println(getState());
        console.println();

        String action = console.readString("Write action (buy, fill, take):");

        if ("buy".equals(action)) {
            int option = console.readInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            sellCupOf(Coffee.ordinal(option));
        } else if ("fill".equals(action)) {
            int water = console.readInt("Write how many ml of water you want to add:");
            int milk = console.readInt("Write how many ml of milk you want to add:");
            int beans = console.readInt("Write how many grams of coffee beans you want to add:");
            int cups = console.readInt("Write how many disposable cups you want to add:");
            Ingredients ingredients = new Ingredients(water, milk, beans);
            fill(ingredients, cups);
        } else if ("take".equals(action)) {
            int taken = take();
            console.println("I gave you $" + taken);
        }
        console.println();
        console.println(getState());
    }

    Ingredients getIngredients() {
        return ingredients;
    }

    int getCups() {
        return cups;
    }

    int getMoney() {
        return money;
    }

    public static void main(String[] args) {
        Console console = new Console(System.out, System.in);
        Ingredients initialIngredients = new Ingredients(400, 540, 120);
        CoffeeMachine machine = new CoffeeMachine(console, initialIngredients, 9, 550);
        machine.run();
    }
}
