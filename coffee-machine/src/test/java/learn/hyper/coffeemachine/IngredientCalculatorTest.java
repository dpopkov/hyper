package learn.hyper.coffeemachine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientCalculatorTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(25, new Ingredients(5_000, 1_250, 375)),
                Arguments.of(125, new Ingredients(25_000, 6_250, 1_875))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void calculate(int numCups, Ingredients expected) {
        Ingredients actual = new IngredientCalculator(200, 50, 15).calculate(numCups);
        assertEquals(expected, actual);
    }
}
