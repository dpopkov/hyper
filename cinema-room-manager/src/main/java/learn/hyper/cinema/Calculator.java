package learn.hyper.cinema;

public class Calculator {
    private final int frontSeatPrice;
    private final int backSeatPrice;
    private final int smallRoomLimit;

    public Calculator(int frontSeatPrice, int backSeatPrice, int smallRoomLimit) {
        this.frontSeatPrice = frontSeatPrice;
        this.backSeatPrice = backSeatPrice;
        this.smallRoomLimit = smallRoomLimit;
    }

    public int ticketPrice(int rowNumber, Room room) {
        int price = frontSeatPrice;
        if (roomIsBig(room)) {
            int numFrontRows = room.getNumRows() / 2;
            if (rowNumber > numFrontRows) {
                price = backSeatPrice;
            }
        }
        return price;
    }

    public int calculateIncome(Room room) {
        int income;
        if (roomIsBig(room)) {
            int numFrontRows = room.getNumRows() / 2;
            int numBackRows = room.getNumRows() - numFrontRows;
            income = room.getNumSeats() * (numFrontRows * frontSeatPrice + numBackRows * backSeatPrice);
        } else {
            income = room.totalSeats() * frontSeatPrice;

        }
        return income;
    }

    private boolean roomIsBig(Room room) {
        return room.totalSeats() > smallRoomLimit;
    }
}
