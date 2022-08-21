import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class CalculatorMenu {
    private final StringBuilder stringBuilder = new StringBuilder();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void Calculator() {
        boolean choice = false;
        do {
            System.out.println("Enter the expression: ");
            if (choice) System.out.print(stringBuilder);
            String userText = queryToInput();
            checkInvalidSymbolAndEmptyExp(choice? stringBuilder + userText : userText);
            int result = calcMethod(choice? stringBuilder + userText : userText);
            stringBuilder.setLength(0);
            stringBuilder.append(result);
            System.out.println(stringBuilder);
            System.out.println("""
                    TYPE IN THE CONSOLE:
                    "YES" if you wish to continue.
                    "BYE" if you want to exit.
                    "RES" if you want to erase everything
                    """);
            String tempReader = null;
            try {
                tempReader = reader.readLine().toUpperCase(Locale.ROOT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (Objects.requireNonNull(tempReader)){
                case "YES" -> choice = true;
                case "BYE" -> {
                    choice = false;
                    stringBuilder.setLength(0);
                }
                case "RES" -> Calculator();
                default -> {
                    System.err.println("YOU ENTERED A NON-EXISTENT COMMAND");
                    Calculator();
                }
            }

        } while (choice);
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
