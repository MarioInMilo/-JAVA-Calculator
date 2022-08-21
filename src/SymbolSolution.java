public class SymbolSolution {
    protected int expr(ObjectBuffer buffer) {

        return 0;
    }
    private int plusMinus(ObjectBuffer buffer) {
        int value = multiplicationDividing(buffer);
        while (true) {
            ObjectInfo info = buffer.next();
            switch (info.type) {
                case PLUS -> value += multiplicationDividing(buffer);
                case MINUS -> value -= multiplicationDividing(buffer);
                default -> {
                    buffer.back();
                    return value;
                }
            }
        }
    }

    private int multiplicationDividing(ObjectBuffer buffer) {
        int value = factor(buffer);
        while (true) {
            ObjectInfo info = buffer.next();
            switch (info.type) {
                case DIVISION -> value /= factor(buffer);
                case MULTIPLICATION -> value *= factor(buffer);
                default -> {
                    buffer.back();
                    return value;
                }
            }
        }
    }
    private int factor(ObjectBuffer buffer) {
        ObjectInfo info = buffer.next();
        switch (info.type) {
            case NUMBER:
                return Integer.parseInt(info.value);
            case LEFT_BRACKET:
                int value = expr(buffer);
                info = buffer.next();
                if (info.type != SymbolType.RIGHT_BRACKET) throw new IllegalArgumentException();
                return value;
            default:
                throw new IllegalArgumentException();
        }
    }
}
