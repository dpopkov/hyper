package learn.hyper.cinema;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CinemaTest {

    @ParameterizedTest
    @CsvSource({
            "input.txt,expectedOutput.txt",
            "input2.txt,expectedOutput2.txt"
    })
    void testMain(String inputFilename, String expectedOutputFilename) throws IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        InputStream savedIn = System.in;
        PrintStream savedOut = System.out;
        String actual;
        String expected;
        try (
                InputStream input = CinemaTest.class.getResourceAsStream(inputFilename);
                InputStream expectedOutput = CinemaTest.class.getResourceAsStream(expectedOutputFilename)) {
            System.setIn(input);
            System.setOut(new PrintStream(buffer));

            Cinema.main(null);

            expected = new String(expectedOutput.readAllBytes());
        }
        System.setIn(savedIn);
        System.setOut(savedOut);
        actual = buffer.toString();
        assertEquals(expected, actual);
    }
}
