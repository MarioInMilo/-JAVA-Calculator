public class SymbolSolution {
    protected int expr(ObjectBuffer buffer) {

        return 0;
    }
    private int plusMinus(ObjectBuffer buffer) {
        return 0;
    }

    private int multiplicationDividing(ObjectBuffer buffer) {

        return 0;
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
