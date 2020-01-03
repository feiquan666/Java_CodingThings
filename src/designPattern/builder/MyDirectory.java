package designPattern.builder;

public class MyDirectory {
    private MyAbstractBuilder myAbstractBuilder;
    public MyDirectory (MyAbstractBuilder myAbstractBuilder){
        this.myAbstractBuilder = myAbstractBuilder;
    }
    public MyProduct build(){
        myAbstractBuilder.buildPartA();
        myAbstractBuilder.buildPartB();
        myAbstractBuilder.buildPartC();
        return myAbstractBuilder.getMyProduct();
    }
}
