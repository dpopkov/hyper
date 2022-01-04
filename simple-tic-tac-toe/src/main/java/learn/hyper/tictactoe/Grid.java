package learn.hyper.tictactoe;

import java.util.Arrays;

public class Grid {
    private static final String NL = System.lineSeparator();
    public static final char EMPTY = ' ';
    public static final char X = 'X';
    public static final char O = 'O';

    private final int gridSize;
    private final char[][] fields;

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        fields = new char[gridSize][gridSize];
        fillFieldsAsEmpty();
    }

    private void fillFieldsAsEmpty() {
        for (char[] row : fields) {
            Arrays.fill(row, EMPTY);
        }
    }

    public char getField(int row, int col) {
        return fields[row][col];
    }

    public void init(String input) {
        String[] lines = input.toUpperCase().split("\n");
        if (lines.length != gridSize) {
            throw new IllegalArgumentException("Cannot break input for " + gridSize + " rows");
        }
        for (int row = 0; row < gridSize; row++) {
            String[] symbols = lines[row].split(" ");
            if (symbols.length != gridSize) {
                throw new IllegalArgumentException("Cannot break row input for " + gridSize + " columns");
            }
            for (int col = 0; col < gridSize; col++) {
                char symbol = symbols[col].charAt(0);
                if (symbol == X || symbol == O) {
                    fields[row][col] = symbol;
                } else {
                    throw new IllegalArgumentException("Invalid character for grid: " + symbol);
                }
            }
        }
    }

    public String asString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (col > 0) {
                    sb.append(' ');
                }
                sb.append(fields[row][col]);
            }
            sb.append(NL);
        }
        return sb.toString();
    }
}
