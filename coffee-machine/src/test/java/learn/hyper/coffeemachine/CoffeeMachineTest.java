package learn.hyper.coffeemachine;

import learn.hyper.utils.testing.AbstractMainTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest extends AbstractMainTest {

    @BeforeEach
    void setUp() {
        super.setupTest();
    }

    @Test
    void testMain_01() throws IOException {
        Result result = super.runMainWithTestInputOutput(CoffeeMachine::main, null,
                "test-01-input-01.txt",
                "test-01-output-01.txt");
        assertEquals(result.expected(), result.actual());
    }

    @Test
    void testMain_02() throws IOException {
        Result result = super.runMainWithTestInputOutput(CoffeeMachine::main, null,
                "test-01-input-02.txt",
                "test-01-output-02.txt");
        assertEquals(result.expected(), result.actual());
    }

    @AfterEach
    void tearDown() {
        super.tearDownTest();
    }
}