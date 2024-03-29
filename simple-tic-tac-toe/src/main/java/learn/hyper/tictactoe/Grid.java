package learn.hyper.tictactoe;

import java.util.Arrays;

public class Grid {
    private static final String NL = System.lineSeparator();
    public static final char EMPTY_IN = '_';
    public static final char EMPTY = ' ';
    public static final char X = 'X';
    public static final char O = 'O';
    public static final String HORIZONTAL = "-";
    public static final String VERTICAL = "|";
    public static final char SPACE = ' ';
    public static final int DEFAULT_GRID_SIZE = 3;

    private final int gridSize;
    private final char[][] fields;

    public Grid() {
        this(DEFAULT_GRID_SIZE);
    }

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        fields = new char[gridSize][gridSize];
        fillFieldsAsEmpty();
    }

    public char[][] getFields() {
        return fields;
    }

    private void fillFieldsAsEmpty() {
        for (char[] row : fields) {
            Arrays.fill(row, EMPTY);
        }
    }

    public char getField(int rowIndex, int colIndex) {
        return fields[rowIndex][colIndex];
    }

    public void setField(int rowIndex, int colIndex, char symbol) {
        fields[rowIndex][colIndex] = symbol;
    }

    public boolean isFree(int rowIndex, int colIndex) {
        return fields[rowIndex][colIndex] == EMPTY;
    }

    public Grid init(String input) {
        if (input.length() != gridSize * gridSize) {
            throw new IllegalArgumentException(
                    String.format("Cannot use input length %d for grid size %d", input.length(), gridSize));
        }
        int row = 0;
        int col = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == EMPTY_IN) {
                symbol = EMPTY;
            }
            if (symbol == X || symbol == O || symbol == EMPTY) {
                fields[row][col] = symbol;
                col++;
                if (col % gridSize == 0) {
                    row++;
                    col = 0;
                }
            } else {
                throw new IllegalArgumentException("Invalid character for grid: " + symbol);
            }
        }
        return this;
    }

    public String asString() {
        return asString(true);
    }

    public String asString(boolean framed) {
        StringBuilder sb = new StringBuilder();
        String horizontalLine = null;
        if (framed) {
            int width = gridSize * 2 + 3;
            horizontalLine = HORIZONTAL.repeat(width);
            sb.append(horizontalLine).append(NL);
        }
        for (int row = 0; row < gridSize; row++) {
            if (framed) {
                sb.append(VERTICAL).append(SPACE);
            }
            for (int col = 0; col < gridSize; col++) {
                if (col > 0) {
                    sb.append(SPACE);
                }
                sb.append(fields[row][col]);
            }
            if (framed) {
                sb.append(SPACE).append(VERTICAL);
            }
            sb.append(NL);
        }
        if (framed) {
            sb.append(horizontalLine).append(NL);
        }
        return sb.toString();
    }
}
