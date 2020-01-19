package variety.practice4;

import java.util.ArrayList;
import java.util.List;

public class EraseWeak<R>  {
    List<String> strings = new ArrayList<>();
    List<Integer> integers = new ArrayList<>();
    R i;
    public void setI(R r){
        r = this.i;
    }
    public static void main(String[] args) {
        EraseWeak d = new EraseWeak();
        Object o = new Object();
        d.setI(o);
    }
}
