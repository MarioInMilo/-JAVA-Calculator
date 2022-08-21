import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CalculatorMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void Calculator() {

    }

    private void checkInvalidSymbolAndEmptyExp(String text) {
        if (text.length() == 0) {
            System.err.println("U DIDN'T ENTER ANYTHING");
            Calculator();
        }
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!((symbol >= 40 && symbol <= 57 || symbol == 32)
                    && (symbol != 44 && symbol != 46))) {
                System.err.println("AN INVALID EXPRESSION IS ENTERED: " + text);
                Calculator();
            }
        }
    }

    private int calcMethod(String text) {
        SymbolSwitcher symbolSwitcher = new SymbolSwitcher();
        ArrayList<ObjectInfo> list = symbolSwitcher.getSymbolArray(text);
        ObjectBuffer buffer = new ObjectBuffer(list);
        SymbolSolution symbolSolution = new SymbolSolution();
        return symbolSolution.expr(buffer);
    }

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
