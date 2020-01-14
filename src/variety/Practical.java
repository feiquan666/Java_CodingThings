package variety;

import org.junit.Test;
import variety.interfaces.Coffee;

import java.time.LocalDateTime;
import java.util.*;

public class Practical{

    @Test
    public void test001(){
        toPrint("i",28,this.getClass().getName());
        toPrint(1, this.getClass().getMethods(),15);
        toPrint(LocalDateTime.now(),5.6d,7.0);
        toPrint(this.getClass().getMethods(),32,99999);
    }
    public <X> void toPrint(X... x){
        Arrays.stream(x).forEach(System.out::print);
    }
}
