package learn.hyper.chattybot;

import java.util.Scanner;

public class SimpleBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is Aid.");
        System.out.println("I was created in 2020.");
        System.out.println("Please, remind me your name.");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.printf("What a great name you have, %s!%n", name);
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int r3 = in.nextInt();
        int r5 = in.nextInt();
        int r7 = in.nextInt();
        // age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
        int age = (r3 * 70 + r5 * 21 + r7 * 15) % 105;
        System.out.printf("Your age is %d; that's a good time to start programming!%n", age);
    }
}
