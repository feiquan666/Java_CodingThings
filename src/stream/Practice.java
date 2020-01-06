package stream;

import org.junit.Test;
import stream.model.MyStudent;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.*;

public class Practice {
    MyStudent 武则天 = new MyStudent("武则天",18,'女',new BigDecimal("0.64"));
    List<MyStudent> students = new ArrayList<>(Arrays.asList(new MyStudent("张三",25,'男',new BigDecimal("82.64")),
            new MyStudent("李四",45,'女',new BigDecimal("98.64")),
            new MyStudent("王麻子",25,'男',new BigDecimal("102.64")),
            武则天));
    @Test
    public void test001(){
        // 求性别为女的年龄和
        int sum = students.parallelStream().filter(stu -> stu.getSex().equals('女')).mapToInt(stu ->stu.getAge()).sum();
        System.out.println(sum);
    }
    @Test
    public void test002(){
        // 将list以tab分割形成字符串
        List<String> students = new ArrayList<>(Arrays.asList("一","二"));
        Stream<String> stream = students.stream();
        students.add("三");
        String sum = stream.collect(Collectors.joining("\t"));
        System.out.println(sum);
    }
    @Test
    public void test003(){
        System.out.println((students.stream().map(MyStudent::getName).collect(Collectors.toList())));
    }
    @Test
    public void test004(){
        List<MyStudent> students = this.students;
        Iterator<MyStudent> iterator = students.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getSex().equals('男')){
                iterator.remove();
            }
        }
        students.sort(new Comparator<MyStudent>() {
            @Override
            public int compare(MyStudent o1, MyStudent o2) {
                return o2.getAge().compareTo(o1.getAge());
            }
        });
        List<String> stuNames = new ArrayList<>();
        iterator = students.iterator();
        while (iterator.hasNext()){
            stuNames.add(iterator.next().getName());
        }
        System.out.println(stuNames);
    }
    @Test
    public void test005(){
        List<MyStudent> students = this.students;
        List<String> stuNames = students.parallelStream()
                .filter(stu -> stu.getSex().equals('女')).sorted(Comparator.comparing(MyStudent::getAge).reversed())
                .map(MyStudent::getName)
                .collect(Collectors.toList());
        Iterator<MyStudent> iterator = students.parallelStream()
                .filter(stu -> stu.getSex().equals('女')).sorted(Comparator.comparing(MyStudent::getAge).reversed())
                .collect(Collectors.toList()).iterator();
        System.out.println(iterator);
        System.out.println(stuNames);
    }
    @Test
    public void test006(){
        IntStream.of(1,2,3,4,5).forEach(System.out::println);
    }
    @Test
    public void test007(){
        IntStream.rangeClosed(1,5).forEach(System.out::println);
    }
    @Test
    public void test008(){
        List<MyStudent> students = this.students;
        String[] stuNames = students.stream().sequential().map(MyStudent::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(stuNames));
    }
    /**
     * 测试flatMap方法
    */
    @Test
    public void test009(){
        Stream<List<Integer>> stream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,5,6)
        );
        Stream<Integer> stream1 = stream.flatMap(childList -> childList.stream());
        System.out.println(stream1);
    }
    /**
     * 测试allMath方法
    */
    @Test
    public void test010(){
        Stream<MyStudent> stream = this.students.stream();
        System.out.println(stream.allMatch(stu -> {
            if(stu.getName().length() > 1){
                return true;
            }
            return false;
        }));
    }
    /**
     * 测试distinct方法
    */
    @Test
    public void test011(){
        this.students.add(武则天);
        Stream<MyStudent> stream = this.students.stream();
        System.out.println(stream.distinct().collect(Collectors.toList()));
    }
    /**
     * 测试findAny方法
     * 测试findFirst方法
    */
    @Test
    public void test012(){
        System.out.println(this.students.stream().findAny());
        System.out.println(this.students.stream().findFirst());
    }
    /**
     * 测试flatMap
    */
    @Test
    public void test013(){
       String[] words = {"Hello", "World"};
       List wos = Arrays.stream(words).flatMap(word -> Arrays.stream(word.split(""))).collect(Collectors.toList());
       wos.forEach(System.out::println);
    }
    @Test
    public void test014(){
        List<String> a = new ArrayList<>();
        Stream<String> stream1 = a.stream();
    }
}
