package learn.hyper.cinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testFormatAsString() {
        Room room = new Room(3, 4);
        String expected = ""
                + "Cinema:\n"
                + "  1 2 3 4\n"
                + "1 S S S S\n"
                + "2 S S S S\n"
                + "3 S S S S\n";
        String actual = room.formatAsString("Cinema:");
        assertEquals(expected, actual);
    }

    @Test
    void testFormatAsStringWhenSeatIsReserved() {
        Room room = new Room(3, 4);
        room.reserveSeat(2, 3);
        String expected = ""
                + "Cinema:\n"
                + "  1 2 3 4\n"
                + "1 S S S S\n"
                + "2 S S B S\n"
                + "3 S S S S\n";
        String actual = room.formatAsString("Cinema:");
        assertEquals(expected, actual);
    }

    @Test
    void testIsPurchased() {
        Room room = new Room(3, 4);
        room.reserveSeat(2, 3);
        assertTrue(room.isPurchased(2, 3));
    }
}
