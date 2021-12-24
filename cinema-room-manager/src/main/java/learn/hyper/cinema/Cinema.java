package learn.hyper.cinema;

import java.util.Scanner;

public class Cinema {

    public static final int FRONT_SEATS_PRICE = 10;
    public static final int BACK_SEATS_PRICE = 8;
    public static final int NUM_SEATS_FOR_SMALL_ROOM = 60;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = in.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = in.nextInt();
        System.out.println();

        // Print seating arrangement
        Room room = new Room(rows, seats);
        System.out.println(room.formatAsString("Cinema:"));

        // Read coordinates of the seat to print the ticket price
        System.out.println("Enter a row number:");
        int rowNumber = in.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = in.nextInt();
        System.out.println();

        // Print the ticket price
        Calculator calculator = new Calculator(FRONT_SEATS_PRICE, BACK_SEATS_PRICE, NUM_SEATS_FOR_SMALL_ROOM);
        int price = calculator.ticketPrice(rowNumber, room);
        System.out.printf("Ticket price: $%d%n", price);
        System.out.println();

        // Print cinema with chosen seat marked 'B'
        room.reserveSeat(rowNumber, seatNumber);
        System.out.println(room.formatAsString("Cinema:"));
    }
}
