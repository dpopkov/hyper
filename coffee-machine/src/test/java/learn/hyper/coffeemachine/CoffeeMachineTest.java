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
    void testMain() throws IOException {
        Result result = super.runMainWithTestOutput(CoffeeMachine::main, null,
                "expected-output.txt");
        assertEquals(result.expected(), result.actual());
    }

    @AfterEach
    void tearDown() {
        super.tearDownTest();
    }
}