package variety.practice5;

import org.omg.CORBA.Object;

public class GenericHolder<T> {
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }
    public T get(){
        return this.obj;
    }
    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<>();
        holder.set("Item");
        String s = holder.get();
    }
}
