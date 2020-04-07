package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final String YES_NO_HINT =
            "(press 'y' for \"yes\" answer, other key for no)";
    private static final String CORRECT_YES_ANSWER = "y";
    private static ConsoleHelper instance;

    public static ConsoleHelper getInstance() {
        if (instance == null) {
            instance = new ConsoleHelper();
        }
        return instance;
    }

    public String readNotEmptyLine() {
        try {
            String line;
            do {
                line = new BufferedReader(new InputStreamReader(System.in)).readLine();
            } while (line.isEmpty());
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean askYesNoQuestion(String question) {
        System.out.println(question);
        System.out.println(YES_NO_HINT);
        return readNotEmptyLine().toLowerCase().equals(CORRECT_YES_ANSWER);
    }
}
