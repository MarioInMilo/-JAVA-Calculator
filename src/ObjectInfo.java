public class ObjectInfo {
    protected SymbolType type;
    protected String value;

    public ObjectInfo(SymbolType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ObjectInfo(SymbolType type, Character value) {
        this.type = type;
        this.value = value.toString();
    }

    @Override
    public String toString() {
        return "ObjectInfo{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
