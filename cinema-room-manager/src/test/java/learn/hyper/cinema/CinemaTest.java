package learn.hyper.cinema;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    @Test
    void testMain() {
        String expected = ""
                + "Cinema:\n"
                + "  1 2 3 4 5 6 7 8\n"
                + "1 S S S S S S S S\n"
                + "2 S S S S S S S S\n"
                + "3 S S S S S S S S\n"
                + "4 S S S S S S S S\n"
                + "5 S S S S S S S S\n"
                + "6 S S S S S S S S\n"
                + "7 S S S S S S S S\n";
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        final PrintStream savedOut = System.out;
        System.setOut(new PrintStream(buffer));
        Cinema.main(null);
        System.setOut(savedOut);
        String actual = buffer.toString();
        assertEquals(expected, actual);
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
