package learn.hyper.coffeemachine;

import learn.hyper.utils.testing.AbstractMainTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeMachineTest extends AbstractMainTest {

    @BeforeEach
    void setUp() {
        super.setupTest();
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("test-02-input-01.txt", "test-02-output-01.txt"),
                Arguments.of("test-02-input-02.txt", "test-02-output-02.txt"),
                Arguments.of("test-02-input-03.txt", "test-02-output-03.txt"),
                Arguments.of("test-02-input-04.txt", "test-02-output-04.txt"),
                Arguments.of("test-02-input-05.txt", "test-02-output-05.txt"),
                Arguments.of("test-02-input-06.txt", "test-02-output-06.txt")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testMain(String inputFile, String outputFile) throws IOException {
        Result result = super.runMainWithTestInputOutput(CoffeeMachine::main, null,
                inputFile, outputFile);
        assertEquals(result.expected(), result.actual());
    }

    @AfterEach
    void tearDown() {
        super.tearDownTest();
    }
}
