package designPattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {
    private Object target;
    public MyProxy (Object object){
        this.target = object;
    }

    public Object createProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                ,target.getClass().getInterfaces(),new MyProxy(target));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if(method.getName().equals("sayHi")){
            before();
            result = method.invoke(target,args);
            after();
        }else {
            result = method.invoke(target,args);
        }
        return result;
    }

    private void before(){
        System.out.println("方法执行前");
    }
    private void after(){
        System.out.println("方法执行后");
    }
}
