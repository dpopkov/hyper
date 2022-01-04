package learn.hyper.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private static final String NL = System.lineSeparator();

    @Test
    void testInit() {
        String representation = "X O\nO X";
        Grid grid = new Grid(2);
        grid.init(representation);
        assertEquals(Grid.X, grid.getField(0, 0));
        assertEquals(Grid.O, grid.getField(0, 1));
        assertEquals(Grid.O, grid.getField(1, 0));
        assertEquals(Grid.X, grid.getField(1, 1));
    }

    @Test
    void testAsString() {
        String representation = "X O X\nO X O\nX X O";
        Grid grid = new Grid(3);
        grid.init(representation);
        String expected = ""
                + "X O X" + NL
                + "O X O" + NL
                + "X X O" + NL;
        String actual = grid.asString();
        assertEquals(expected, actual);
    }
}
