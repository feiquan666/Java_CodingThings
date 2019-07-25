package javaContainer;

import java.util.ArrayList;
import java.util.List;

public class ExampleList {
    static int length = 16000000 ;
    public static List<String> listNoLength = new ArrayList<>();
    public static List<String> listLength = new ArrayList<>(length);

    public static void addList(int sign) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            if (sign == 0) {
                listNoLength.add("asdf");
            } else {
                listLength.add("asdf");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("sign: " + sign + " " + (end - start));
    }

    public static void main(String[] args) {
        addList(0);
        addList(1);
    }
}