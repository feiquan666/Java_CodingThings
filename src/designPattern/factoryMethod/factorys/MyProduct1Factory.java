package designPattern.factoryMethod.factorys;

import designPattern.factoryMethod.MyAbstractFactory;
import designPattern.factoryMethod.MyAbstractProduct;
import designPattern.factoryMethod.products.MyProduct1;

public class MyProduct1Factory implements MyAbstractFactory {
    @Override
    public MyAbstractProduct createProduct(String productName) {
        System.out.println(this.getClass().getName()+"生产："+productName);
        return new MyProduct1();
    }
}
