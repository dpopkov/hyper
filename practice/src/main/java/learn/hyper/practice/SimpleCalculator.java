package learn.hyper.practice;

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arguments = scanner.nextLine().split(" ");
        String result = calculate(arguments);
        System.out.println(result);
    }

    public static String calculate(String[] args) {
        String result;
        try {
            result = Long.toString(calculateLongs(args[0], args[1], args[2]));
        } catch (IllegalArgumentException ex) {
            result = ex.getMessage();
        }
        return result;
    }

    public static long calculateLongs(String operand1, String operation, String operand2)
            throws IllegalArgumentException {
        long first = Long.parseLong(operand1);
        long second = Long.parseLong(operand2);
        switch (operation) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second == 0) {
                    throw new IllegalArgumentException("Division by 0!");
                }
                return first / second;
            default:
                throw new IllegalArgumentException("Unknown operator");
        }
    }
}
