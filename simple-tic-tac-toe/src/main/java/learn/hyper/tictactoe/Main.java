package learn.hyper.tictactoe;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(3);
        grid.init("X O X\nO X O\nX X O");
        System.out.print(grid.asString());
    }
}
