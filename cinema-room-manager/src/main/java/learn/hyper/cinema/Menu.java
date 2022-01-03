package learn.hyper.cinema;

import java.io.PrintStream;
import java.util.*;

public class Menu {
    private static final String NL = System.lineSeparator();

    private final List<String> names = new ArrayList<>();
    private final List<Action> actions = new ArrayList<>();
    private final Scanner in;
    private final PrintStream out;
    private boolean dirty;
    private String representation;

    public Menu(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    public void addAction(String name, Action action) {
        names.add(name);
        actions.add(action);
        dirty = true;
    }

    public void run() {
        boolean running = true;
        while (running) {
            out.println(asString());
            int cmd = in.nextInt();
            if (cmd == 0) {
                running = false;
            } else {
                Action action = actions.get(cmd - 1);
                action.execute();
            }
        }
    }

    public String asString() {
        if (dirty) {
            StringBuilder sb = new StringBuilder();
            sb.append(NL);
            for (int i = 0; i < actions.size(); i++) {
                sb.append(String.format("%d. %s%n", (i + 1), names.get(i)));
            }
            sb.append("0. Exit");
            representation = sb.toString();
            dirty = false;
        }
        return representation;
    }
}
