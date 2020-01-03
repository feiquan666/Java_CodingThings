package designPattern.singleton;

public class MySingleton {
    private static String name;
    private static volatile MySingleton mySingleton = null;
    private MySingleton(String name){
        this.name = name;
    }
    public static synchronized MySingleton getInstance(String myName){
        if (mySingleton == null) {
            mySingleton = new MySingleton(myName);
            System.out.println("产生实例："+name);
        }else {
            System.out.println("实例已存在，它的名字是："+name);
        }
        return mySingleton;
    }
}
