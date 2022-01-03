package learn.hyper.cinema;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Cinema {

    public static final int FRONT_SEATS_PRICE = 10;
    public static final int BACK_SEATS_PRICE = 8;
    public static final int NUM_SEATS_FOR_SMALL_ROOM = 60;

    private final Room room;
    private final Calculator calculator;
    private final Scanner in;
    private final PrintStream out;
    private int currentIncome;

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

    public void printStatistics() {
        out.println();
        final int purchased = room.getNumberOfPurchased();
        out.println("Number of purchased tickets: " + purchased);
        out.printf(Locale.US, "Percentage: %.2f%%%n", (purchased * 100.0 / room.totalSeats()));
        out.printf("Current income: $%d%n", currentIncome);
        out.printf("Total income: $%d%n", calculator.calculateIncome(room));
    }

    private void buyTicket() {
        int rowNumber = -1;
        int seatNumber = -1;
        boolean inputInProgress = true;
        while (inputInProgress) {
            out.println();
            rowNumber = readInt("Enter a row number:", in);
            seatNumber = readInt("Enter a seat number in that row:", in);
            if (rowNumber < 0 || rowNumber > room.getNumRows() || seatNumber < 0 || seatNumber > room.getNumSeats()) {
                out.println();
                out.println("Wrong input!");
            } else if (room.isPurchased(rowNumber, seatNumber)) {
                out.println();
                out.println("That ticket has already been purchased!");
            } else {
                inputInProgress = false;
            }
        }
        int price = priceForSeat(rowNumber);
        reserveSeat(rowNumber, seatNumber);
        currentIncome += price;
        out.printf("%nTicket price: $%d%n", price);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int rows = readInt("Enter the number of rows:", in);
        int seats = readInt("Enter the number of seats in each row:", in);

        Cinema cinema = new Cinema(rows, seats, in, System.out);
        Menu menu = new Menu(in, System.out);
        menu.addAction("Show the seats", cinema::printArrangement);
        menu.addAction("Buy a ticket", cinema::buyTicket);
        menu.addAction("Statistics", cinema::printStatistics);
        menu.run();
    }

    private static int readInt(String prompt, Scanner in) {
        System.out.println(prompt);
        return in.nextInt();
    }
}
