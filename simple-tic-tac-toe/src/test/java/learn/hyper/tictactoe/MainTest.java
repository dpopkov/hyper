package learn.hyper.tictactoe;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @CsvSource({
            "example01-input.txt,example01-output.txt",
            "example02-input.txt,example02-output.txt",
            "example03-input.txt,example03-output.txt"
    })
    void testMain(String inputFile, String expectedOutputFilename) throws IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        InputStream savedIn = System.in;
        PrintStream savedOut = System.out;
        String actual;
        String expected;

        try (
                InputStream input = Main.class.getResourceAsStream(inputFile);
                InputStream expectedOutput = Main.class.getResourceAsStream(expectedOutputFilename)
        ) {
            System.setIn(input);
            System.setOut(new PrintStream(buffer));

            Main.main(null);

            expected = new String(expectedOutput.readAllBytes());
        }
        System.setIn(savedIn);
        System.setOut(savedOut);
        actual = buffer.toString();
        assertEquals(expected, actual);
    }
}
