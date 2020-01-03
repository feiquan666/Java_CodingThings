package designPattern.proxy.jdkProxy;

public class MyRealSubject implements MySubject {
    @Override
    public void sayHi() {
        System.out.println("hi");
    }

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
