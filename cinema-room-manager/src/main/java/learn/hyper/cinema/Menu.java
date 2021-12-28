package learn.hyper.cinema;

import java.io.PrintStream;
import java.util.*;

public class Menu {

    private final List<String> names = new ArrayList<>();
    private final List<Action> actions = new ArrayList<>();
    private final Scanner in;
    private final PrintStream out;

    public Menu(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    public void addAction(String name, Action action) {
        names.add(name);
        actions.add(action);
    }

    public void run() {
        boolean running = true;
        while (running) {
            out.println();
            for (int i = 0; i < actions.size(); i++) {
                out.printf("%d. %s%n", (i + 1), names.get(i));
            }
            out.println("0. Exit");
            int cmd = in.nextInt();
            if (cmd == 0) {
                running = false;
            } else {
                Action action = actions.get(cmd - 1);
                action.execute();
            }
        }
    }
}
