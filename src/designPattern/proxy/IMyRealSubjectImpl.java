package designPattern.proxy;

public class IMyRealSubjectImpl implements IMySubject {
    @Override
    public void request() {
        System.out.println("我是真实主题");
    }
}
