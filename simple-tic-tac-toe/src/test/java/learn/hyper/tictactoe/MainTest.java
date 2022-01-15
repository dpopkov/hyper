package learn.hyper.tictactoe;

import learn.hyper.utils.testing.AbstractMainTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends AbstractMainTest {

    @BeforeEach
    void setUp() {
        setupTest();
    }

    @ParameterizedTest
    @CsvSource({
            "example01-input.txt,example01-output.txt",
            "example02-input.txt,example02-output.txt",
            "example03-input.txt,example03-output.txt"
    })
    void testMain(String inputFilename, String expectedOutputFilename) throws IOException {
        Result result = runMainWithTestInputOutput(Main::main,
                new String[0],
                inputFilename,
                expectedOutputFilename);
        assertEquals(result.expected(), result.actual());
    }

    @AfterEach
    void tearDown() {
        tearDownTest();
    }
}
