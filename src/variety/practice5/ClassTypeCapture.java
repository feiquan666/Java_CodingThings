package variety.practice5;

import org.junit.Test;
import variety.MyLinkedStack;
import variety.Practical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Building{}
class House extends Building{}
public class ClassTypeCapture<T> {
    private Class<T> kind;
    public ClassTypeCapture(Class<T> args){
        this.kind = args;
    }
    public boolean f(Object arg){
        return this.kind.isInstance(arg);
    }

//    public static void main(String[] args) {
//        ClassTypeCapture<Building> classTypeCapture1 = new ClassTypeCapture<>(Building.class);
//        System.out.println(classTypeCapture1.f(new Building()));
//        System.out.println(classTypeCapture1.f(new House()));
//        ClassTypeCapture<House> classTypeCapture2 = new ClassTypeCapture<>(House.class);
//        System.out.println(classTypeCapture2.f(new Building()));
//        System.out.println(classTypeCapture2.f(new House()));
//    }


    private Map<String,Class<?>> map;

    public ClassTypeCapture(Class<T> args,Map<String,Class<?>> map){
        this.kind = args;
        this.map = map;
    }
    private void addType(String typeName,Class<?> kind){
        map.put(typeName,kind);
    }
    private Object createNew(String typeName) throws IllegalAccessException, InstantiationException {
        if(map.containsKey(typeName)){
            return map.get(typeName).newInstance();
        }
//        System.out.println(typeName + " class not available");
        return null;
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassTypeCapture<Building> classTypeCapture = new ClassTypeCapture(Building.class,new HashMap<>());
        classTypeCapture.addType("String",String.class);
        classTypeCapture.addType("ArrayList", ArrayList.class);
        classTypeCapture.addType("House",House.class);
        classTypeCapture.addType("Practical", Practical.class);
        classTypeCapture.addType("MyLinkedStack", MyLinkedStack.class);
        classTypeCapture.addType("Object",Object.class);
        System.out.println(classTypeCapture.createNew("String"));
        System.out.println(classTypeCapture.createNew("ArrayList"));
        System.out.println(classTypeCapture.createNew("House"));
        System.out.println(classTypeCapture.createNew("Practical"));
        System.out.println(classTypeCapture.createNew("MyLinkedStack"));
        System.out.println(classTypeCapture.createNew("Object"));
        System.out.println(classTypeCapture.createNew("Test"));
    }
}
