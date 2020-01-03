package designPattern.adapter;

import org.junit.Test;

public class MyTest {
    @Test
    public void testAdapter(){
        System.out.println("类适配器模式测试");
        MyTarget myTarget = new MyClassAdapter();
        myTarget.request();
        System.out.println("对象适配器模式测试");
        MyAdaptee myAdaptee = new MyAdaptee();
        MyTarget myTarget1 = new MyObjectAdapter(myAdaptee);
        myTarget1.request();
    }
}
