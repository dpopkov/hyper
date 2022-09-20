package learn.hyper.coffeemachine;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console {
    private final PrintStream out;
    private final Scanner in;

    public Console(PrintStream out, InputStream in) {
        this.out = out;
        this.in = new Scanner(in);
    }

    public int readInt(String prompt) {
        out.println(prompt);
        return in.nextInt();
    }

    public String readString(String prompt) {
        out.println(prompt);
        return in.nextLine();
    }

    public void println(String s) {
        out.println(s);
    }

    public void println() {
        out.println();
    }
}
