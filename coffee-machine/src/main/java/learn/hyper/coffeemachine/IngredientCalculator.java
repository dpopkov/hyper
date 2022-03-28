package learn.hyper.coffeemachine;

import java.util.EnumMap;

public class IngredientCalculator {

    private final Ingredients perCup;

    public IngredientCalculator(int waterPerCup, int milkPerCup, int beansPerCup) {
        perCup = new Ingredients(waterPerCup, milkPerCup, beansPerCup);
    }

    public Ingredients calculate(int numCups) {
        EnumMap<Ingredient, Integer> result = new EnumMap<>(Ingredient.class);
        for (Ingredient ingredient : Ingredient.values()) {
            calculateIngredient(numCups, ingredient, result);
        }
        return new Ingredients(result);
    }

    private void calculateIngredient(int numCups, Ingredient ingredient, EnumMap<Ingredient, Integer> result) {
        result.put(ingredient, perCup.get(ingredient) * numCups);
    }
}
