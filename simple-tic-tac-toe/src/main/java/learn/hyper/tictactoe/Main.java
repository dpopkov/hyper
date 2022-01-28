package learn.hyper.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(3);
        Scanner scanner = new Scanner(System.in);
        System.out.print(grid.asString());
        CoordinateReader reader = new CoordinateReader(System.out, scanner, 1, 3);
        StateAnalyser analyser = new StateAnalyser(Grid.X, Grid.O, Grid.EMPTY);
        boolean notFinished = true;
        char currentPlayer = Grid.X;
        while (notFinished) {
            Coordinates coordinates = reader.read();
            final int rowIndex = coordinates.getRowIndex();
            final int colIndex = coordinates.getColIndex();
            if (!grid.isFree(rowIndex, colIndex)) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                grid.setField(rowIndex, colIndex, currentPlayer);
                System.out.print(grid.asString());
                GameState state = analyser.analyze(grid.getFields());
                if (state == GameState.NOT_FINISHED) {
                    currentPlayer = currentPlayer == Grid.X ? Grid.O : Grid.X;
                } else {
                    notFinished = false;
                    System.out.println(state.getName());
                }
            }
        }
    }
}
