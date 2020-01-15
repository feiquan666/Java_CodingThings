package variety.practice3;

import java.util.HashSet;
import java.util.Set;

public class MySet {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.addAll(b);//并集
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);//交集
        return result;
    }
    public static <T> Set<T> difference(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);// 移除
        return result;
    }
    public static <T> Set<T> complement(Set<T> a, Set<T> b){
        return difference(union(a,b),intersection(a,b));
    }

    public static void main(String[] args) {

    }
}
