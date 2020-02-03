package variety.practice5;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
    public static void main(String[] args) {
        // 一个可以指向任何从Fruit继承而来的列表
        List<? extends Fruit> fs = new ArrayList<Apple>();
        fs.contains(new Apple());
        List<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange());
        fs = oranges;
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fruits[0] = new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Object> a = new ArrayList<>();
        List<?> aa = a;
        List<? extends Object> b = new ArrayList<>();
        List c = new ArrayList<>();
        b = c;
    }
}
