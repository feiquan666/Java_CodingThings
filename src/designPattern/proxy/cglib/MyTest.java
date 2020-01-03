package designPattern.proxy.cglib;

import org.junit.Test;


public class MyTest {
    @Test
    public void testCglibProxy(){
        UserDao userDao = new UserDaoImpl();
        MyCglibProxy myCglibProxy = new MyCglibProxy(userDao);
        UserDao myProxy = (UserDao) myCglibProxy.createProxy() ;
        myProxy.save();
        myProxy.delete();
    }
}
