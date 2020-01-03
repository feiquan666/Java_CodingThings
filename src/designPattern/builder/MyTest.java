package designPattern.builder;

import org.junit.Test;

public class MyTest {
    @Test
    public void testBuilder(){
        MyAbstractBuilder myAbstractBuilder = new MyBuilder();//创建一个建造者
        MyDirectory myDirectory = new MyDirectory(myAbstractBuilder);//把建造者交给指挥者
        MyProduct myProduct = myDirectory.build();//通过指挥者生成产品
        myProduct.show();//产品展示
    }
}
