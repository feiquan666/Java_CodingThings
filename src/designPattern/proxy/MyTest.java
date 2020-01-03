package designPattern.proxy;

import org.junit.Test;

public class MyTest {
    @Test
    public void testProxy(){
        MyProxy myProxy = new MyProxy();
        myProxy.request();
    }
}
