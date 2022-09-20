package learn.hyper.coffeemachine;

public class CoffeeMachine {
    private final Console console;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine(Console console, int water, int milk, int coffeeBeans, int cups, int money) {
        this.console = console;
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

    public void sellCupOf(Coffee coffee) {
        water -= coffee.getWater();
        milk -= coffee.getMilk();
        coffeeBeans -= coffee.getCoffeeBeans();
        cups--;
        money += coffee.getCost();
    }

    public void fill(Ingredients ingredients, int numCups) {
        water += ingredients.get(Ingredient.WATER);
        milk += ingredients.get(Ingredient.MILK);
        coffeeBeans += ingredients.get(Ingredient.COFFEE_BEANS);
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

    int getWater() {
        return water;
    }

    int getMilk() {
        return milk;
    }

    int getCoffeeBeans() {
        return coffeeBeans;
    }

    int getCups() {
        return cups;
    }

    int getMoney() {
        return money;
    }

    public static void main(String[] args) {
        Console console = new Console(System.out, System.in);
        CoffeeMachine machine = new CoffeeMachine(console, 400, 540, 120, 9, 550);
        machine.run();
    }
}
