package designPattern.proxy.jdkProxy;

import org.junit.Test;


public class MyTest {
    @Test
    public void testJdbProxy(){
        MySubject mySubject = new MyRealSubject();
        MyProxy myProxy = new MyProxy(mySubject);
        MySubject mySubjectProxy = (MySubject) myProxy.createProxy() ;
        mySubjectProxy.sayHi();
        mySubjectProxy.sayHello();
    }
}
