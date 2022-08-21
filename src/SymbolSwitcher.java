import java.util.ArrayList;

public class SymbolSwitcher {

    protected ArrayList<ObjectInfo> getSymbolArray(String value) {
        ArrayList<ObjectInfo> list = new ArrayList<>();
        int counter = 0;
        while (counter < value.length()) {
            char tempSymbol = value.charAt(counter);
            switch (tempSymbol) {
                case 40:
                    list.add(new ObjectInfo(SymbolType.LEFT_BRACKET, tempSymbol));
                    counter++;
                    continue;
                case 41:
                    list.add(new ObjectInfo(SymbolType.RIGHT_BRACKET, tempSymbol));
                    counter++;
                    continue;
                case 43:
                    list.add(new ObjectInfo(SymbolType.PLUS, tempSymbol));
                    counter++;
                    continue;
                case 45:
                    list.add(new ObjectInfo(SymbolType.MINUS, tempSymbol));
                    counter++;
                    continue;
                case 42:
                    list.add(new ObjectInfo(SymbolType.MULTIPLICATION, tempSymbol));
                    counter++;
                    continue;
                case 47:
                    list.add(new ObjectInfo(SymbolType.DIVISION, tempSymbol));
                    counter++;
                    continue;
                default:
                    if (tempSymbol >= 48 && tempSymbol <= 57){
                        StringBuilder builder = new StringBuilder();
                        do {
                            builder.append(tempSymbol);
                            counter++;
                            if (counter >= value.length()) break;
                            tempSymbol = value.charAt(counter);
                        } while (tempSymbol >= 48 && tempSymbol <= 57);
                        list.add(new ObjectInfo(SymbolType.NUMBER, builder.toString()));
                    } else {
                        if (tempSymbol != ' ') throw new IllegalArgumentException();
                        counter++;
                    }

            }
        }
        list.add(new ObjectInfo(SymbolType.EOF, ""));
        return list;
    }

}
