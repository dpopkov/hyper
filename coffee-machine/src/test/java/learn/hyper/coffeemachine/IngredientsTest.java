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
}
