package learn.hyper.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private static final String NL = System.lineSeparator();

    @Test
    void testInit() {
        String representation = "XOOX";
        Grid grid = new Grid(2);
        grid.init(representation);
        assertEquals(Grid.X, grid.getField(0, 0));
        assertEquals(Grid.O, grid.getField(0, 1));
        assertEquals(Grid.O, grid.getField(1, 0));
        assertEquals(Grid.X, grid.getField(1, 1));
    }

    @Test
    void testAsString() {
        String representation = "XOXO_OXXO";
        Grid grid = new Grid(3);
        grid.init(representation);
        String expected = ""
                + "X O X" + NL
                + "O _ O" + NL
                + "X X O" + NL;
        String actual = grid.asString(false);
        assertEquals(expected, actual);
    }

    @Test
    void testAsStringFramed() {
        String representation = "XOXO_OXXO";
        Grid grid = new Grid(3);
        grid.init(representation);
        String expected = ""
                + "---------" + NL
                + "| X O X |" + NL
                + "| O _ O |" + NL
                + "| X X O |" + NL
                + "---------" + NL;
        String actual = grid.asString(true);
        assertEquals(expected, actual);
    }

    @Test
    void testAsStringFramedSize4() {
        String representation = "XOXO" + "_OXX" + "XXOO" + "_XO_";
        Grid grid = new Grid(4);
        grid.init(representation);
        String expected = ""
                + "-----------" + NL
                + "| X O X O |" + NL
                + "| _ O X X |" + NL
                + "| X X O O |" + NL
                + "| _ X O _ |" + NL
                + "-----------" + NL;
        String actual = grid.asString(true);
        assertEquals(expected, actual);
    }
}
