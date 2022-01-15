package learn.hyper.utils.testing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * Base class for tests that check input-output of simple console programs.
 */
public abstract class AbstractMainTest {
    protected InputStream savedIn;
    protected PrintStream savedOut;
    protected ByteArrayOutputStream buffer;

    /**
     * Should be called as a setup method using @BeforeEach annotation
     */
    protected void setupTest() {
        savedIn = System.in;
        savedOut = System.out;
        buffer = new ByteArrayOutputStream();
    }

    /**
     * Runs the specified main method reference using test data from the specified input and expected output filenames.
     * Test data files must be located in the test resources folder according to the package hierarchy.
     * <p>For example: <code>src/test/resources/learn/hyper/tictactoe/example02-output.txt</code></p>
     */
    protected Result runMainWithTestInputOutput(Consumer<String[]> mainMethodReference,
                                                String[] mainMethodArgs,
                                                String inputDataFilename,
                                                String expectedOutputDataFilename) throws IOException {
        String expected;
        try (
                InputStream input = this.getClass().getResourceAsStream(inputDataFilename);
                InputStream expectedOutput = this.getClass().getResourceAsStream(expectedOutputDataFilename)
        ) {
            System.setIn(input);
            System.setOut(new PrintStream(buffer));

            if (mainMethodArgs == null) {
                mainMethodArgs = new String[0];
            }
            mainMethodReference.accept(mainMethodArgs);

            expected = new String(expectedOutput.readAllBytes());
        }
        String actual = buffer.toString();
        return new Result(expected, actual);
    }

    /**
     * Should be called as a tearDown method using @AfterEach annotation.
     */
    protected void tearDownTest() {
        System.setIn(savedIn);
        System.setOut(savedOut);
    }

    public static class Result {
        private final String expected;
        private final String actual;

        public Result(String expected, String actual) {
            this.expected = expected;
            this.actual = actual;
        }

        public String expected() {
            return expected;
        }

        public String actual() {
            return actual;
        }
    }
}
