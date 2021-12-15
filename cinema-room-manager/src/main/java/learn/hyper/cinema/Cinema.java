package learn.hyper.cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = in.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = in.nextInt();
        System.out.println("Total income:");
        int income = calculateIncome(rows, seats);
        System.out.println("$" + income);
    }

    public static int calculateIncome(int rows, int seats) {
        final int frontSeatsPrice = 10;
        final int backSeatsPrice = 8;
        int income;
        if (rows * seats <= 60) {
            income = rows * seats * frontSeatsPrice;
        } else {
            int numFrontRows = rows / 2;
            int numBackRows = rows - numFrontRows;
            income = seats * (numFrontRows * frontSeatsPrice + numBackRows * backSeatsPrice);
        }
        return income;
    }

    public static String makeRoom(int rows, int seats) {
        StringBuilder sb = new StringBuilder();
        final String nl = System.lineSeparator();
        sb.append("Cinema:").append(nl);
        sb.append(" ");
        for (int i = 1; i <= seats; i++) {
            sb.append(String.format("%2d", i));
        }
        sb.append(nl);
        for (int i = 1; i <= rows; i++) {
            sb.append(String.format("%d", i));
            sb.append(" S".repeat(Math.max(0, seats)));
            sb.append(nl);
        }
        return sb.toString();
    }
}
