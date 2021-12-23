package learn.hyper.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlphabeticalOrderTest {

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(true, new String[] {"a"}),
                Arguments.of(true, new String[] {"a", "b", "c"}),
                Arguments.of(true, new String[] {"a", "aa", "az", "aza"}),
                Arguments.of(true, new String[] {"a", "b", "b"}),
                Arguments.of(false, new String[] {"a", "c", "b"})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void testIsAlphabetical(boolean expected, String[] array) {
        assertEquals(expected, AlphabeticalOrder.isAlphabetical(array));
    }
}
