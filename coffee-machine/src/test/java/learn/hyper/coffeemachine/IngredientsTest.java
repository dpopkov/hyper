package learn.hyper.coffeemachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientsTest {

    @Test
    void strictlyGreaterOrEqual() {
        Ingredients less = new Ingredients(50, 20, 10);
        Ingredients greater = new Ingredients(60, 30, 20);
        assertTrue(greater.strictlyGreaterOrEqual(less));
    }

    @Test
    void notGreater() {
        Ingredients less = new Ingredients(50, 20, 10);
        Ingredients greater = new Ingredients(40, 10, 2);
        assertFalse(greater.strictlyGreaterOrEqual(less));
    }

    @Test
    void notStrictlyGreater() {
        Ingredients less = new Ingredients(50, 20, 10);
        Ingredients greater = new Ingredients(60, 10, 20);
        assertFalse(greater.strictlyGreaterOrEqual(less));
    }

    @Test
    void greaterOrEqual() {
        Ingredients less = new Ingredients(50, 20, 10);
        Ingredients greater = new Ingredients(60, 20, 20);
        assertTrue(greater.strictlyGreaterOrEqual(less));
    }

    @Test
    void canProduceCups() {
        Ingredients perCup = new Ingredients(20, 10, 5);
        Ingredients have = new Ingredients(60, 40, 500);
        int actual = have.canProduceCups(perCup);
        assertEquals(3, actual);
    }

    @Test
    void testSubtract() {
        Ingredients target = new Ingredients(2, 3, 4);
        Ingredients other = new Ingredients(1, 2, 3);
        target.subtract(other);
        assertEquals(1, target.get(Ingredient.WATER));
        assertEquals(1, target.get(Ingredient.MILK));
        assertEquals(1, target.get(Ingredient.COFFEE_BEANS));
    }

    @Test
    void testAdd() {
        Ingredients target = new Ingredients(2, 3, 4);
        Ingredients other = new Ingredients(1, 2, 3);
        target.add(other);
        assertEquals(3, target.get(Ingredient.WATER));
        assertEquals(5, target.get(Ingredient.MILK));
        assertEquals(7, target.get(Ingredient.COFFEE_BEANS));
    }
}
