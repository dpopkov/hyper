package learn.hyper.cinema;

public class Cinema {
    public static void main(String[] args) {
        System.out.println("Cinema:");
        printRoom(7, 8);
    }

    public static void printRoom(int rows, int seats) {
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.printf("%2d", i);
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.printf("%d", i);
            for (int j = 0; j < seats; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }
    }
}
