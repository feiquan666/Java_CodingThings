package designPattern.builder;

public class MyBuilder extends MyAbstractBuilder {
    @Override
    public void buildPartA() {
        myProduct.setPartA("建造A");
    }

    @Override
    public void buildPartB() {
        myProduct.setPartB("建造B");
    }

    @Override
    public void buildPartC() {
        myProduct.setPartC("建造C");
    }
}
