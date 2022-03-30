package learn.hyper.coffeemachine;

import java.util.EnumMap;
import java.util.Objects;

public class Ingredients {
    private final EnumMap<Ingredient, Integer> all;

    public Ingredients(EnumMap<Ingredient, Integer> allIngredients) {
        all = allIngredients;
    }

    public Ingredients(int water, int milk, int beans) {
        all = new EnumMap<>(Ingredient.class);
        all.put(Ingredient.WATER, water);
        all.put(Ingredient.MILK, milk);
        all.put(Ingredient.COFFEE_BEANS, beans);
    }

    public boolean strictlyGreaterOrEqual(Ingredients other) {
        for (Ingredient i : Ingredient.values()) {
            if (this.get(i) < other.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int canProduceCups(Ingredients perCup) {
        int result = 0;
        for (Ingredient i : Ingredient.values()) {
            int tmp = this.get(i) / perCup.get(i);
            if (result == 0 || tmp < result) {
                result = tmp;
            }
        }
        return result;
    }

    public int get(Ingredient ingredient) {
        return all.get(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return all.equals(that.all);
    }

    @Override
    public int hashCode() {
        return Objects.hash(all);
    }
}
