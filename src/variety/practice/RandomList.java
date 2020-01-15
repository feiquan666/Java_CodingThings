package variety.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> list = new ArrayList<>();
    private Random random = new Random(38);
    private void add(T item){list.add(item);}
    public T select(){
        return list.get(random.nextInt(list.size()));
    }
    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for (String s : "I Love You! Do You Love Me".split(" ")){
            randomList.add(s);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(randomList.select());
        }
    }
}
