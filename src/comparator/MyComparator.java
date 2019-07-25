package comparator;

import org.junit.Test;

import java.util.*;

public class MyComparator {
    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap = new TreeMap<>(new NewComparator());
        HashMap<Integer,Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.hashCode();
        treeMap.put("key_1",1);
        treeMap.put("key_2",2);
        treeMap.put("key_3",3);
        treeMap.put("key_7",7);
        treeMap.put("key_5",5);
        treeMap.put("key_11",11);
        Set<String> set  =treeMap.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(" " + key + ":" + treeMap.get(key));
        }
    }
    @Test
    public void  t(){
        Map<String,Integer> map = new Hashtable<>();//忽略
        map.put(" ",null);
        System.out.println(map.get(" "));
        map = new HashMap<>();
        map.put(null,null);
        System.out.println(map.get(null));
        map = new TreeMap<>();
        map.put(null,null);
        System.out.println(map.get(null));
        map = new LinkedHashMap<>();
        map.put(null,null);
        System.out.println(map.get(null));
    }
}
class NewComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String i1 = (String)o1;
        String i2 = (String)o2;
        return -i1.compareTo(i2);
    }
}
