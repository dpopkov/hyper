package learn.hyper.practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "10000000000,+,20000000000,30000000000",
            "7,-,4,3",
            "7,*,3,21",
            "21,/,3,7"
    })
    void testCalculateLongs(String o1, String op, String o2, long expected) {
        long result = SimpleCalculator.calculateLongs(o1, op, o2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "21,/,0,Division by 0!",
            "21,!,3,Unknown operator",
    })
    void testCalculateLongsWithError(String o1, String op, String o2, String expectedMessage) {
        assertThrows(IllegalArgumentException.class,
                () -> SimpleCalculator.calculateLongs(o1, op, o2),
                expectedMessage);
    }

    @Test
    void testCalculate() {
        String input = "3 + 2";
        String result = SimpleCalculator.calculate(input.split(" "));
        assertEquals("5", result);
    }
}
