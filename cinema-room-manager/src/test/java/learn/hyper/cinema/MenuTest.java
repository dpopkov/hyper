package learn.hyper.cinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void testAsString() {
        Menu menu = new Menu(null, null);
        menu.addAction("Add action", null);
        menu.addAction("Execute action", null);
        String representation = menu.asString();
        String expected = "\n"
                + "1. Add action\n"
                + "2. Execute action\n"
                + "0. Exit";
        assertEquals(expected, representation);
    }
}
