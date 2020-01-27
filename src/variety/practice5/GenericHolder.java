package variety.practice5;

public class GenericHolder<T> {
    private T obj;
    public void set(T obj){
        if(obj instanceof String){}
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
