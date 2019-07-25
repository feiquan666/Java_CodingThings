package javaMap;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService
public class MyHashMap {
    public static void main(String[] args) {
        Map<?,?> map = new HashMap<>();
        map.hashCode();
    }
}