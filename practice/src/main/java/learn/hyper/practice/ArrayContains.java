package learn.hyper.practice;

import java.util.Scanner;

public class ArrayContains {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        int n = in.nextInt();
        int m = in.nextInt();
        boolean result = twoNumbersNextToEachOther(arr, n, m);
        System.out.println(result);
    }

    public static boolean twoNumbersNextToEachOther(int[] arr, int a, int b) {
        boolean prevA = false;
        boolean prevB = false;
        for (int value : arr) {
            if (prevA && value == b || prevB && value == a) {
                return true;
            } else if (value == a) {
                prevA = true;
                prevB = false;
            } else if (value == b) {
                prevA = false;
                prevB = true;
            } else {
                prevA = false;
                prevB = false;
            }
        }
        return false;
    }
}
