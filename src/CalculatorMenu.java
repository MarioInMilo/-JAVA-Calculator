import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CalculatorMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


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
