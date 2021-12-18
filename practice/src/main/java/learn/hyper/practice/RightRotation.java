package learn.hyper.practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
A right rotation is an operation that shifts each element of an array to the right.
For example, if an array is {1,2,3,4,5} and we right rotate it by 1, the new array will be {5,1,2,3,4}.
If we rotate it by 2, the new array will be {4,5,1,2,3}.
It goes like this: {1,2,3,4,5} -> {5,1,2,3,4} -> {4,5,1,2,3}.

Write a program that performs a right rotation on an array by a given number.

Input format:
The first line is an array of numbers.
The second line is the number of rotations.

Output format:
Resulting array
 */
public class RightRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = readArrayInLine(in);
        int shift = in.nextInt();
        int[] result = rotate(array, shift);
        print(result);
    }

    public static int[] rotate(int[] array, int shift) {
        int[] result = new int[array.length];
        int rightPart = shift % array.length;
        int leftPart = array.length - rightPart;
        System.arraycopy(array, 0, result, rightPart, leftPart);
        System.arraycopy(array, leftPart, result, 0, rightPart);
        return result;
    }

    private static int[] readArrayInLine(Scanner in) {
        return Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void print(int[] array) {
        IntStream.of(array).forEach(n -> System.out.printf("%d ", n));
    }
}
