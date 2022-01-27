package learn.hyper.tictactoe;

public class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getRowIndex() {
        return row - 1;
    }

    public int getColIndex() {
        return col - 1;
    }
}
