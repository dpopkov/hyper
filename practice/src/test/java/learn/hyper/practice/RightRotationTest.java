package learn.hyper.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RightRotationTest {

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {1}, new int[] {1}, 1),
                Arguments.of(new int[] {2, 1}, new int[] {1, 2}, 1),
                Arguments.of(new int[] {4, 5, 1, 2, 3}, new int[] {1, 2, 3, 4, 5}, 2),
                Arguments.of(new int[] {3, 4, 5, 1, 2}, new int[] {1, 2, 3, 4, 5}, 8),
                Arguments.of(new int[] {41, 51, 78, 90, 11, 21, 1}, new int[] {11, 21, 1, 41, 51, 78, 90}, 10000)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void testRotate(int[] expected, int[] input, int shift) {
        int[] rst = RightRotation.rotate(input, shift);
        assertArrayEquals(expected, rst);
    }
}
