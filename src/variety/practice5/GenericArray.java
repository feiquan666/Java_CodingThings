package variety.practice5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArray<T> {
    public final T a;
    private T[] array;

    public GenericArray(Class<T>  type,int size){
        this.a = null;
        this.array =  (T[])Array.newInstance(type,size);
    }
    public void put(int index,T item){
        this.array[index] = item;
    }
    public T get(int index){
        return this.array[index];
    }
    public T[] rep(){
        return this.array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray = new GenericArray<>(Integer.class,12);
        for (int i  =0;i<genericArray.rep().length;i++){
            genericArray.put(i,i);
        }
        int sum =  0;
        for (Integer item: genericArray.rep()){
            sum+=item;
        }
        System.out.println(sum);
        Integer[] integers = genericArray.rep();
        System.out.println(Arrays.toString(integers));
    }
}
