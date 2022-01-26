package learn.hyper.tictactoe;

public enum GameState {
    NOT_FINISHED("Game not finished"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    IMPOSSIBLE("Impossible"),
    NONE("No such state");

    private final String name;

    GameState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
