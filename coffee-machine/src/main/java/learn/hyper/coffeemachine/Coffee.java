package learn.hyper.coffeemachine;

public enum Coffee {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final Ingredients ingredients;
    private final int cost;

    Coffee(int water, int milk, int coffeeBeans, int cost) {
        ingredients = new Ingredients(water, milk, coffeeBeans);
        this.cost = cost;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public int getCost() {
        return cost;
    }

    public static Coffee ordinal(int n) {
        return Coffee.values()[n - 1];
    }
}
