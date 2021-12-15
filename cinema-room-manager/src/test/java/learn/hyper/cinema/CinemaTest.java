package learn.hyper.cinema;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CinemaTest {

    @ParameterizedTest
    @CsvSource({
            "4, 5, 200",
            "8, 9, 648",
            "9, 7, 560"
    })
    void testCalculateIncome(int rows, int seats, int expectedIncome) {
        int income = Cinema.calculateIncome(rows, seats);
        assertEquals(expectedIncome, income);
    }

    @Test
    void testMakeRoom() {
        String expected = ""
                + "Cinema:\n"
                + "  1 2 3 4\n"
                + "1 S S S S\n"
                + "2 S S S S\n"
                + "3 S S S S\n";
        String actual = Cinema.makeRoom(3, 4);
        assertEquals(expected, actual);
    }
}
