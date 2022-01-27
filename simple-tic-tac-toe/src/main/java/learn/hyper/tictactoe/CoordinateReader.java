package learn.hyper.tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public class CoordinateReader {
    private final PrintStream out;
    private final Scanner in;
    private final int lowerBound;
    private final int higherBound;

    public CoordinateReader(PrintStream out, Scanner in, int lowerBound, int higherBound) {
        this.out = out;
        this.in = in;
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
    }

    public Coordinates read() {
        int row = -1;
        int col = -1;
        boolean reading = true;
        while (reading) {
            out.print("Enter the coordinates: ");
            String input = in.nextLine();
            String[] splitted = input.split("\\s+");
            try {
                row = Integer.parseInt(splitted[0]);
                col = Integer.parseInt(splitted[1]);
                if (lowerBound <= row && row <= higherBound && lowerBound <= col && col <= higherBound) {
                    reading = false;
                } else {
                    out.printf("Coordinates should be from %d to %d!%n", lowerBound, higherBound);
                }
            } catch (NumberFormatException numberFormatException) {
                out.println("You should enter numbers!");
            }
        }
        return new Coordinates(row, col);
    }
}
