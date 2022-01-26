package learn.hyper.tictactoe;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StateAnalyserTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("XXXOO____", GameState.X_WINS),    // row X
                Arguments.of("XX_OOO___", GameState.O_WINS),    // row O
                Arguments.of("XOXOXOXXO", GameState.X_WINS),    // right diagonal X
                Arguments.of("OXOXOXXXO", GameState.O_WINS),    // left diagonal O
                Arguments.of("XOOOXOXXO", GameState.O_WINS),    // column O
                Arguments.of("XOXXOOXXO", GameState.X_WINS),    // column X
                Arguments.of("XOXOOXXXO", GameState.DRAW),
                Arguments.of("XO_OOX_X_", GameState.NOT_FINISHED),
                Arguments.of("XO_XO_XOX", GameState.IMPOSSIBLE),
                Arguments.of("_O_X__X_X", GameState.IMPOSSIBLE),
                Arguments.of("_OOOO_X_X", GameState.IMPOSSIBLE)
        );
    }

    private final StateAnalyser analyser = new StateAnalyser(Grid.X, Grid.O, Grid.EMPTY);

    @ParameterizedTest
    @MethodSource("data")
    void testAnalyze(String input, GameState expected) {
        char[][] fields = new Grid().init(input).getFields();
        GameState actual = analyser.analyze(fields);
        assertSame(expected, actual);
    }
}
