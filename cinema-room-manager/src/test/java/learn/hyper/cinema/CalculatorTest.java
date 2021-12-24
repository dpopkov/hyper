package learn.hyper.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(Cinema.FRONT_SEATS_PRICE,
                Cinema.BACK_SEATS_PRICE,
                Cinema.NUM_SEATS_FOR_SMALL_ROOM);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 6, 3",
            "10, 11, 7, 5",
            "8, 11, 7, 6"
    })
    void testTicketPrice(int expected, int rows, int seats, int rowNumber) {
        Room room = new Room(rows, seats);
        int price = calculator.ticketPrice(rowNumber, room);
        assertEquals(expected, price);
    }

    @ParameterizedTest
    @CsvSource({
            "4, 5, 200",
            "8, 9, 648",
            "9, 7, 560"
    })
    void testCalculateIncome(int rows, int seats, int expectedIncome) {
        Room room = new Room(rows, seats);
        int income = calculator.calculateIncome(room);
        assertEquals(expectedIncome, income);
    }
}
