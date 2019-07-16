package javaContainer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    @Test
    public void test_subList(){
        List<String> list0 = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            list0.add("my Code："+(i+1));
        System.out.print("list0：");
        for (String item: list0) {
            System.out.print(item + ",");
        }
        List<String> list1 = list0.subList(1,5);
        System.out.print("\nlist1：");
        for (String item: list1) {
            System.out.print(item + ",");
        }
    }
    @Test
    public void test_containsAll(){
        List<String> list0 = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            list0.add("my Code："+(i+1));
        List<String> list1 = list0.subList(1,5);
        boolean flag = list0.containsAll(list1);
        System.out.println(flag);
        list1.add("my Code：" + 11);
        for (String item: list1) {
            System.out.print(item + ",");
        }
        flag  =list0.containsAll(list1);
        System.out.println("\n"+flag);
        list1.removeAll(list1);
        for (String item: list1) {
            System.out.print(item + ",");
        }
        System.out.println(flag);
    }
}
