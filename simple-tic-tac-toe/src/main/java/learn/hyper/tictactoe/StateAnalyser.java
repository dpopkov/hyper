package learn.hyper.tictactoe;

public class StateAnalyser {
    private final char symbolX;
    private final char symbolO;
    private final char symbolEmpty;

    public StateAnalyser(char symbolX, char symbolO, char symbolEmpty) {
        this.symbolX = symbolX;
        this.symbolO = symbolO;
        this.symbolEmpty = symbolEmpty;
    }

    public GameState analyze(char[][] fields) {
        GameState result = GameState.NONE;
        boolean xWins = false;
        boolean oWins = false;
        int totalX = 0;
        int totalO = 0;
        // check rows
        for (char[] row : fields) {
            totalX += countSymbol(row, symbolX);
            totalO += countSymbol(row, symbolO);
            char cell = row[0];
            if (cell == row[1] && cell == row[2] && cell != symbolEmpty) {
                if (cell == symbolX) {
                    xWins = true;
                } else if (cell == symbolO) {
                    oWins = true;
                }
            }
        }
        // check columns
        final int numColumns = fields[0].length;
        for (int col = 0; col < numColumns; col++) {
            char cell = fields[0][col];
            if (cell == fields[1][col] && cell == fields[2][col] && cell != symbolEmpty) {
                result = cell == symbolX ? GameState.X_WINS : GameState.O_WINS;
                if (cell == symbolX) {
                    xWins = true;
                } else if (cell == symbolO) {
                    oWins = true;
                }
            }
        }
        // check diagonals
        char left = fields[0][0];
        if (left == fields[1][1] && left == fields[2][2] && left != symbolEmpty) {
            if (left == symbolX) {
                xWins = true;
            } else if (left == symbolO) {
                oWins = true;
            }
        }
        char right = fields[0][2];
        if (right == fields[1][1] && right == fields[2][0] && right != symbolEmpty) {
            if (right == symbolX) {
                xWins = true;
            } else if (right == symbolO) {
                oWins = true;
            }
        }
        if (xWins && oWins) {
            result = GameState.IMPOSSIBLE;
        } else if (xWins) {
            result = GameState.X_WINS;
        } else if (oWins) {
            result = GameState.O_WINS;
        } else { // nobody wins
            final int capacity = fields.length * fields[0].length;
            int total = totalX + totalO;
            if (total == capacity) {
                result = GameState.DRAW;
            } else if (Math.abs(totalX - totalO) > 1) {
                result = GameState.IMPOSSIBLE;
            } else if ((capacity - total) > 0) {
                result = GameState.NOT_FINISHED;
            }
        }
        return result;
    }

    private int countSymbol(char[] row, char symbol) {
        int total = 0;
        for (char ch : row) {
            if (ch == symbol) {
                total++;
            }
        }
        return total;
    }
}
