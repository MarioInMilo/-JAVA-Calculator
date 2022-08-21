import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String queryToInput() {
        String userText = null;
        try {
            userText = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userText;
    }
}
