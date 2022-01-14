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
    }
}
