package learn.hyper.chattybot;

import java.util.Scanner;

public class SimpleBot {
    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    public static void main(String[] args) {
        greet("Aid", "2020");
        remindName();
        guessAge();
        count();
        test();
        end();
    }

    private static void end() {
        System.out.println("Congratulations, have a nice day!");
    }

    static void greet(String assistantName, String birthYear) {
        System.out.println("Hello! My name is " + assistantName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    private static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int r3 = scanner.nextInt();
        int r5 = scanner.nextInt();
        int r7 = scanner.nextInt();
        // age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
        int age = (r3 * 70 + r5 * 21 + r7 * 15) % 105;
        System.out.printf("Your age is %d; that's a good time to start programming!%n", age);
    }

    private static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int countLimit = scanner.nextInt();
        for (int i = 0; i <= countLimit; i++) {
            System.out.println(i + "!");
        }
    }

    private static void remindName() {
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    private static void test() {
        System.out.println("Let's test your programming knowledge.");
        QuizTest test = new QuizTest("Why do we use methods?", new String[] {
                "To repeat a statement multiple times.",
                "To decompose a program into several small subroutines.",
                "To determine the execution time of a program.",
                "To interrupt the execution of a program."
        }, 2);
        test.print(System.out);
        boolean reading = true;
        while (reading) {
            int answer = scanner.nextInt();
            scanner.nextLine();
            if (test.isCorrect(answer)) {
                reading = false;
            } else {
                System.out.println("Please, try again.");
            }
        }
    }
}
