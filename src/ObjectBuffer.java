import java.util.List;

public class ObjectBuffer {
    private List<ObjectInfo> list;
    private int count;

    public ObjectBuffer(List<ObjectInfo> list) {
        this.list = list;
    }

    public void back(){
        count--;
    }

    public ObjectInfo next(){
        return list.get(count++);
    }
}
