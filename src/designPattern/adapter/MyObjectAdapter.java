package designPattern.adapter;

public class MyObjectAdapter implements MyTarget {
    private MyAdaptee myAdaptee;

    public MyObjectAdapter(MyAdaptee myAdaptee) {
        this.myAdaptee = myAdaptee;
    }

    @Override
    public void request() {
        myAdaptee.specificRequest();
    }
}
