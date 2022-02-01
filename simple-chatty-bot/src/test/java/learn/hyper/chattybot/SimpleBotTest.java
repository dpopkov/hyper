package learn.hyper.chattybot;

import learn.hyper.utils.testing.AbstractMainTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBotTest extends AbstractMainTest {

    @BeforeEach
    void setUp() {
        setupTest();
    }

    @Test
    void main() throws IOException {
        Result result = runMainWithTestInputOutput(SimpleBot::main, null,
                "test05-input.txt", "test05-output.txt");
        assertEquals(result.expected(), result.actual());
    }

    @AfterEach
    void tearDown() {
        tearDownTest();
    }

}
