package designPattern.proxy;

public class MyProxy implements IMySubject {
    private IMyRealSubjectImpl myRealSubject = new IMyRealSubjectImpl();

    @Override
    public void request() {
        System.out.println("访问真实主题前");
        myRealSubject.request();
        System.out.println("访问真实主题后");
    }
}
