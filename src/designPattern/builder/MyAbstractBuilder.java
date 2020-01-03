package designPattern.builder;

public abstract class MyAbstractBuilder {
    protected MyProduct myProduct = new MyProduct();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public MyProduct getMyProduct(){
        return myProduct;
    }
}
