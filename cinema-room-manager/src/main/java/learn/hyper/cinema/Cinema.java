package learn.hyper.cinema;

import java.util.Scanner;

public class Cinema {

    private static final int FRONT_SEATS_PRICE = 10;
    private static final int BACK_SEATS_PRICE = 8;
    private static final int NUM_SEATS_FOR_SMALL_ROOM = 60;
    private static final String NL = System.lineSeparator();
    private static final String SEAT = " S";
    private static final String RESERVED_SEAT = " B";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = in.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = in.nextInt();
        System.out.println();

        // Print seating arrangement
        System.out.println(makeRoom(rows, seats));

        // Read coordinates of the seat to print the ticket price
        System.out.println("Enter a row number:");
        int rowNumber = in.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = in.nextInt();
        System.out.println();

        // Print the ticket price
        int price = ticketPrice(rows, seats, rowNumber);
        System.out.printf("Ticket price: $%d%n", price);
        System.out.println();

        // Print cinema with chosen seat marked 'B'
        System.out.println(makeRoom(rows, seats, rowNumber, seatNumber));
    }

    public static int ticketPrice(int rows, int seats, int rowNumber) {
        int price = FRONT_SEATS_PRICE;
        if (roomIsBig(rows, seats)) {
            int numFrontRows = rows / 2;
            if (rowNumber > numFrontRows) {
                price = BACK_SEATS_PRICE;
            }
        }
        return price;
    }

    public static int calculateIncome(int rows, int seats) {
        int income;
        if (roomIsBig(rows, seats)) {
            int numFrontRows = rows / 2;
            int numBackRows = rows - numFrontRows;
            income = seats * (numFrontRows * FRONT_SEATS_PRICE + numBackRows * BACK_SEATS_PRICE);
        } else {
            income = rows * seats * FRONT_SEATS_PRICE;

        }
        return income;
    }

    private static boolean roomIsBig(int rows, int seats) {
        return rows * seats > NUM_SEATS_FOR_SMALL_ROOM;
    }

    public static String makeRoom(int rows, int seats, int rowNumber, int seatNumber) {
        StringBuilder sb = makeHeader(seats);
        for (int i = 1; i <= rows; i++) {
            sb.append(String.format("%d", i));
            if (i == rowNumber) {
                for (int j = 1; j <= seats; j++) {
                    sb.append(j != seatNumber ? SEAT : RESERVED_SEAT);
                }
            } else {
                sb.append(SEAT.repeat(Math.max(0, seats)));
            }
            sb.append(NL);
        }
        return sb.toString();
    }

    public static String makeRoom(int rows, int seats) {
        StringBuilder sb = makeHeader(seats);
        for (int i = 1; i <= rows; i++) {
            sb.append(String.format("%d", i));
            sb.append(SEAT.repeat(Math.max(0, seats)));
            sb.append(NL);
        }
        return sb.toString();
    }

    private static StringBuilder makeHeader(int seats) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cinema:").append(NL);
        sb.append(" ");
        for (int i = 1; i <= seats; i++) {
            sb.append(String.format("%2d", i));
        }
        sb.append(NL);
        return sb;
    }
}
