package learn.hyper.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestAscendingSequenceTest {

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1, new int[] {99}),
                Arguments.of(2, new int[] {1, 2}),
                Arguments.of(3, new int[] {1, 2, 1, 2, 3, 1}),
                Arguments.of(5, new int[] {1, 2, 4, 1, 2, 3, 5, 7, 4, 3}),
                Arguments.of(9, new int[] {1, 2, 4, 1, 2, 3, 5, 7, 8, 9, 10, 11}),
                Arguments.of(9, new int[] {1, 2, 4, 1, 2, 3, 5, 7, 8, 9, 10, 11, 10})
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void test(int expected, int[] array) {
        int actual = LongestAscendingSequence.calculate(array);
        assertEquals(expected, actual);
    }
}
