package learn.hyper.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheStarFigureTest {

    @Test
    void testStar() {
        String expected = "" +
                "* . . . * . . . *\n" +
                ". * . . * . . * .\n" +
                ". . * . * . * . .\n" +
                ". . . * * * . . .\n" +
                "* * * * * * * * *\n" +
                ". . . * * * . . .\n" +
                ". . * . * . * . .\n" +
                ". * . . * . . * .\n" +
                "* . . . * . . . *\n";
        String actual = TheStarFigure.star(9);
        assertEquals(expected, actual);
    }
}
