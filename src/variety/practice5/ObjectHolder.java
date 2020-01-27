package variety.practice5;

public class ObjectHolder {
    private Object obj;
    public void set(Object obj){
        this.obj = obj;
    }
    public Object get(){
        return this.obj;
    }
    public static void main(String[] args) {
        ObjectHolder holder = new ObjectHolder();
        holder.set("Item");
        String s = (String) holder.get();
    }
}
