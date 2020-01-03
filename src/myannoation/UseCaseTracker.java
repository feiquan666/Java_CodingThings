package myannoation;



import myannoation.sqlAnnotation.Constraints;
import myannoation.sqlAnnotation.DBTable;
import myannoation.sqlAnnotation.SQLInteger;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {

    @SQLInteger(name = "age" ,constraints = @Constraints(primaryKey = true,allowNull = false,unique = true))
    private Integer id;
    public static void trackUseCases(List<Integer> useCases, Class<?> cl){
        for(Method m : cl.getDeclaredMethods()){// 反射方法之一，返回类中声明的所有访问权限的方法，不包括父类对象
            UseCase uc = m.getAnnotation(UseCase.class); // 返回指定类型的注解对象
            if(uc != null){
                System.out.println("Found Use Case:"+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));// 移除指定id的元素
            }
        }
        for(int i : useCases){
            System.out.println("Warning:Missing use case-"+i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50,51);
        trackUseCases(useCases,PasswordUtils.class);
    }
}
