package learn.hyper.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayContainsTest {

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {1, 3, 2}, 2, 3, true),
                Arguments.of(new int[] {2, 1, 2}, 2, 3, false),
                Arguments.of(new int[] {6, 3, 4, 8, 3, 2, 6}, 8, 2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void testTwoNumbers(int[] arr, int a, int b, boolean expected) {
        assertEquals(expected, ArrayContains.twoNumbersNextToEachOther(arr, a, b));
    }
}
