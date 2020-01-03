package designPattern.adapter;

public class MyClassAdapter extends MyAdaptee implements MyTarget {
    @Override
    public void request() {
        specificRequest();
    }
}
