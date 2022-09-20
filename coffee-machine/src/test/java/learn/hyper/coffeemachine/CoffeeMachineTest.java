package learn.hyper.coffeemachine;

import learn.hyper.utils.testing.AbstractMainTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
                Arguments.of("test-03-input-01.txt", "test-03-output-01.txt"),
                Arguments.of("test-03-input-02.txt", "test-03-output-02.txt"),
                Arguments.of("test-03-input-03.txt", "test-03-output-03.txt")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testMain(String inputFile, String outputFile) throws IOException {
        Result result = super.runMainWithTestInputOutput(CoffeeMachine::main, null,
                inputFile, outputFile);
        assertEquals(result.expected(), result.actual());
    }

    @Test
    void testState() {
        CoffeeMachine machine = new CoffeeMachine(null, 400, 540, 120, 9, 550);
        String expected = "The coffee machine has:\n" +
                "400 ml of water\n" +
                "540 ml of milk\n" +
                "120 g of coffee beans\n" +
                "9 disposable cups\n" +
                "$550 of money";
        String actual = machine.getState();
        assertEquals(expected, actual);
    }

    @Test
    void testSellCupOf() {
        CoffeeMachine machine = new CoffeeMachine(null, 400, 540, 120, 9, 550);

        machine.sellCupOf(Coffee.CAPPUCCINO);

        assertEquals(200, machine.getWater());
        assertEquals(440, machine.getMilk());
        assertEquals(108, machine.getCoffeeBeans());
        assertEquals(8, machine.getCups());
        assertEquals(556, machine.getMoney());
    }

    @AfterEach
    void tearDown() {
        super.tearDownTest();
    }
}
