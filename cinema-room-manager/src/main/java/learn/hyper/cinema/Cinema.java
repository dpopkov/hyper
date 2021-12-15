package learn.hyper.cinema;

public class Cinema {
    public static void main(String[] args) {
        System.out.print(makeRoom(7, 8));
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
