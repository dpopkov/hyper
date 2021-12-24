package learn.hyper.cinema;

import java.util.Scanner;

public class Cinema {

    public static final int FRONT_SEATS_PRICE = 10;
    public static final int BACK_SEATS_PRICE = 8;
    public static final int NUM_SEATS_FOR_SMALL_ROOM = 60;

    private final Room room;
    private final Calculator calculator;

    public Cinema(int rows, int seats) {
        room = new Room(rows, seats);
        calculator = new Calculator(FRONT_SEATS_PRICE, BACK_SEATS_PRICE, NUM_SEATS_FOR_SMALL_ROOM);
    }

    public void printArrangement() {
        System.out.println(room.formatAsString("Cinema:"));
    }

    public int priceForSeat(int rowNumber) {
        return calculator.ticketPrice(rowNumber, room);
    }

    public void reserveSeat(int rowNumber, int seatNumber) {
        room.reserveSeat(rowNumber, seatNumber);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int rows = readInt("Enter the number of rows:", in);
        int seats = readInt("Enter the number of seats in each row:", in);
        System.out.println();

        Cinema cinema = new Cinema(rows, seats);
        cinema.printArrangement();

        // Read coordinates of the seat to print the ticket price
        int rowNumber = readInt("Enter a row number:", in);
        int seatNumber = readInt("Enter a seat number in that row:", in);
        System.out.println();

        int price = cinema.priceForSeat(rowNumber);
        System.out.printf("Ticket price: $%d%n", price);
        System.out.println();

        cinema.reserveSeat(rowNumber, seatNumber);
        cinema.printArrangement();
    }

    private static int readInt(String prompt, Scanner in) {
        System.out.println(prompt);
        return in.nextInt();
    }
}
