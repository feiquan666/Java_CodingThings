package designPattern.factoryMethod;

import designPattern.factoryMethod.products.MyProduct1;
import designPattern.factoryMethod.products.MyProduct2;
import org.junit.Test;

public class MyTest {
    @Test
    public void testCreateProduct1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyAbstractFactory myAbstractFactory;
        Class<?> myClass = Class.forName("designPattern.factoryMethod.factorys.MyProduct1Factory");//必须指定全类名
        myAbstractFactory = (MyAbstractFactory) myClass.newInstance();
        MyProduct1 myProduct1 = (MyProduct1) myAbstractFactory.createProduct("myProduct1");
        myProduct1.showPrice();
    }

    @Test
    public void testCreateProduct2() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        MyAbstractFactory myAbstractFactory;
        Class<?> myClass = Class.forName("designPattern.factoryMethod.factorys.MyProduct2Factory");//必须指定全类名
        myAbstractFactory = (MyAbstractFactory) myClass.newInstance();
        MyProduct2 myProduct2 = (MyProduct2) myAbstractFactory.createProduct("myProduct2");
        myProduct2.showPrice();
    }
}
