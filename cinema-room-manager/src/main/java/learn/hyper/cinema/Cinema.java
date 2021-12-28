package learn.hyper.cinema;

import java.io.PrintStream;
import java.util.Scanner;

public class Cinema {

    public static final int FRONT_SEATS_PRICE = 10;
    public static final int BACK_SEATS_PRICE = 8;
    public static final int NUM_SEATS_FOR_SMALL_ROOM = 60;

    private final Room room;
    private final Calculator calculator;
    private final Scanner in;
    private final PrintStream out;

    public Cinema(int rows, int seats, Scanner in, PrintStream out) {
        room = new Room(rows, seats);
        calculator = new Calculator(FRONT_SEATS_PRICE, BACK_SEATS_PRICE, NUM_SEATS_FOR_SMALL_ROOM);
        this.in = in;
        this.out = out;
    }

    public void printArrangement() {
        out.println();
        out.print(room.formatAsString("Cinema:"));
    }

    public int priceForSeat(int rowNumber) {
        return calculator.ticketPrice(rowNumber, room);
    }

    public void reserveSeat(int rowNumber, int seatNumber) {
        room.reserveSeat(rowNumber, seatNumber);
    }

    private void buyTicket() {
        out.println();
        int rowNumber = readInt("Enter a row number:", in);
        int seatNumber = readInt("Enter a seat number in that row:", in);
        int price = priceForSeat(rowNumber);
        reserveSeat(rowNumber, seatNumber);
        out.printf("Ticket price: $%d%n", price);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int rows = readInt("Enter the number of rows:", in);
        int seats = readInt("Enter the number of seats in each row:", in);

        Cinema cinema = new Cinema(rows, seats, in, System.out);
        Menu menu = new Menu(in, System.out);
        menu.addAction("Show the seats", cinema::printArrangement);
        menu.addAction("Buy a ticket", cinema::buyTicket);
        menu.run();
    }

    private static int readInt(String prompt, Scanner in) {
        System.out.println(prompt);
        return in.nextInt();
    }
}
