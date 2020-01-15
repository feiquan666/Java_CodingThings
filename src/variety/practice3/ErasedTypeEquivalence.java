package variety.practice3;

import java.util.ArrayList;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<>().getClass();
        System.out.println(ArrayList.class);
        System.out.println(c1==c2);
    }
}
