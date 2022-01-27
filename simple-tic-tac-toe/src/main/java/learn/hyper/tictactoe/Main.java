package learn.hyper.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(3);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        grid.init(input);
        System.out.print(grid.asString());

        CoordinateReader reader = new CoordinateReader(System.out, scanner, 1, 3);
        boolean notFinished = true;
        while (notFinished) {
            Coordinates coordinates = reader.read();
            final int rowIndex = coordinates.getRowIndex();
            final int colIndex = coordinates.getColIndex();
            if (!grid.isFree(rowIndex, colIndex)) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                grid.setField(rowIndex, colIndex, Grid.X);
                notFinished = false;
            }
        }
        System.out.print(grid.asString());
    }
}
