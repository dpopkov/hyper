package learn.hyper.practice;

import java.util.Scanner;

public class TheStarFigure {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(star(n));
    }

    public static String star(int size) {
        StringBuilder sb = new StringBuilder();
        final String nl = System.lineSeparator();
        final int middle = size / 2;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (col > 0) {
                    sb.append(" ");
                }
                boolean draw = col == row || (size - row - 1) == col
                        || col == middle || row == middle;
                sb.append(draw ? "*" : ".");
            }
            sb.append(nl);
        }
        return sb.toString();
    }
}
