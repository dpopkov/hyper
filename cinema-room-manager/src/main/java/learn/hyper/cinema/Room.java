package learn.hyper.cinema;

public class Room {
    private static final String DEFAULT_FREE_SEAT_SYMBOL = " S";
    private static final String DEFAULT_RESERVED_SEAT_SYMBOL = " B";
    private static final String NL = System.lineSeparator();

    private final int numRows;
    private final int numSeats;
    private final String freeSeatSymbol;
    private final String reservedSeatSymbol;
    private final String[][] seats;
    private int numberOfPurchased;

    public Room(int numRows, int numSeats) {
        this(numRows, numSeats, DEFAULT_FREE_SEAT_SYMBOL, DEFAULT_RESERVED_SEAT_SYMBOL);
    }

    public Room(int numRows, int numSeats, String freeSeatSymbol, String reservedSeatSymbol) {
        this.numRows = numRows;
        this.numSeats = numSeats;
        this.freeSeatSymbol = freeSeatSymbol;
        this.reservedSeatSymbol = reservedSeatSymbol;
        seats = new String[numRows][numSeats];
        fillFree(seats);
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int totalSeats() {
        return numRows * numSeats;
    }

    public int getNumberOfPurchased() {
        return numberOfPurchased;
    }

    private void fillFree(String[][] allRows) {
        for (String[] row : allRows) {
            java.util.Arrays.fill(row, freeSeatSymbol);
        }
    }

    public boolean isPurchased(int row, int seat) {
        final String place = seats[row - 1][seat - 1];
        return place != null && place.equals(reservedSeatSymbol);
    }

    public void reserveSeat(int row, int seat) {
        seats[row - 1][seat - 1] = this.reservedSeatSymbol;
        numberOfPurchased++;
    }

    public String formatAsString(String title) {
        StringBuilder sb = makeHeader(title);
        for (int i = 0; i < numRows; i++) {
            sb.append(String.format("%d", (i + 1)));
            for (int j = 0; j < numSeats; j++) {
                sb.append(seats[i][j]);
            }
            sb.append(NL);
        }
        return sb.toString();
    }

    private StringBuilder makeHeader(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(NL);
        sb.append(" ");
        for (int i = 1; i <= numSeats; i++) {
            sb.append(String.format("%2d", i));
        }
        sb.append(NL);
        return sb;
    }
}
