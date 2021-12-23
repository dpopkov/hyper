package learn.hyper.practice;

import java.util.Scanner;

public class AlphabeticalOrder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String[] array = in.nextLine().split(" ");
        boolean result = isAlphabetical(array);
        System.out.println(result);
    }

    public static boolean isAlphabetical(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
