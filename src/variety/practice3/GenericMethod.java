package variety.practice3;

import variety.interfaces.Coffee;

public class GenericMethod {
    private static <T,E,V> void fun(T item,E every,V value){
        try {
            Class.forName("").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(item.getClass().getName()+"\t"+every.getClass().getName()+"\t"+value.getClass().getName());
    }

    public static void main(String[] args) {
        fun(1,2.0,new Coffee());
        fun("String",'h',new String[]{"12"});
        fun(new GenericMethod(),12,0);
        fun(12.0f,"null",new NullPointerException());
        fun(0x1239aff,"",new Class[]{});

    }
}
