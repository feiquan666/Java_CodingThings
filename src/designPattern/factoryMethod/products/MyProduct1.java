package designPattern.factoryMethod.products;

import designPattern.factoryMethod.MyAbstractProduct;

public class MyProduct1 implements MyAbstractProduct {
    Double price = 6.08;
    @Override
    public void showPrice() {
        System.out.println("Product1.Price："+price);
    }
}
