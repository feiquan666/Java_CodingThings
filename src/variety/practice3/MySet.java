package variety.practice3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MySet {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);//并集
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);//交集
        return result;
    }

    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);// a有b没有的
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b)); // a,b交集的补集
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> b = new HashSet<>(Arrays.asList(2, 3, 4, 5, 7, 9, 10, 11, 12, 15));
        printSet(union(a,b));
        printSet(intersection(a,b));
        printSet(difference(a,b));
        printSet(complement(a,b));
    }

    public static  <T> void printSet(Set<T> set) {
        set.forEach(item -> {
            System.out.print(item + "\t");
        });
        System.out.println();
    }
}
