package designPattern.factoryMethod.products;

import designPattern.factoryMethod.MyAbstractProduct;

public class MyProduct2 implements MyAbstractProduct {
    Double price = 62.31;
    @Override
    public void showPrice() {
        System.out.println("Product2.Price："+price);
    }
}
