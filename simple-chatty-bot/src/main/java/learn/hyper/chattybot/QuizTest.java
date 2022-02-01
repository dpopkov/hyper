package learn.hyper.chattybot;

import java.io.PrintStream;

public class QuizTest {
    private final String title;
    private final String[] options;
    private final int correctOption;

    public QuizTest(String title, String[] options, int correctOption) {
        this.title = title;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int option) {
        return correctOption == option;
    }

    public void print(PrintStream out) {
        out.println(title);
        for (int i = 0; i < options.length; i++) {
            out.printf("%d. %s%n", i + 1, options[i]);
        }
    }
}
