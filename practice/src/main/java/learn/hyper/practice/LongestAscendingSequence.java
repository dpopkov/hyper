package learn.hyper.practice;

import java.util.Scanner;

/*
Iterating over arrays - The longest ascending sequence.

Write a program that reads an array of ints and outputs the length of the longest sequence in strictly ascending order.
Elements of the sequence must go one after another.
A single number is assumed to be an ordered sequence with the length = 1.

Input data format

The first line contains the size of an array.
The second line contains elements of the array separated by spaces.

Example

The input array is 1 2 4 1 2 3 5 7 4 3.
In this case, the length of the longest sequence in ascending order is 5.
It includes the following elements: 1 2 3 5 7.
 */
public class LongestAscendingSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int result = calculate(arr);
        System.out.println(result);
    }

    public static int calculate(int[] arr) {
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 1;
            }
        }
        return maxCount;
    }
}
