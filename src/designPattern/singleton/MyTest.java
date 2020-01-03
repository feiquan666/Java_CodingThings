package designPattern.singleton;

import org.junit.Test;

public class MyTest {
    @Test
    public void testSingleton(){
        MySingleton mySingleton1 = MySingleton.getInstance("实例1");
        MySingleton mySingleton2 = MySingleton.getInstance("实例2");
    }
}
