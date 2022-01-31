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
    }
}
