package variety.interfaces;

import variety.interfaces.var.*;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator<Coffee> implements Generator,Iterable<Coffee> {
    private Class[] types = {
            Latte.class, Mocha.class, Americano.class, Cappuccino.class, Breve.class
    };
    private static Random rand = new Random(47);

    public CoffeeGenerator() {}
    private int size = 0;
    public CoffeeGenerator(int sz){this.size = sz;}
    @Override
    public Coffee next() {
        try{
            return (Coffee)types[rand.nextInt(types.length)].newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    class CoffeeIterator implements Iterator<Coffee>{
        int count  = size;
        public boolean hasNext(){
            return count > 0;
        }
        public Coffee next(){
            count--;
            return CoffeeGenerator.this.next();
        }
        public void remove(){throw new UnsupportedOperationException();}
    }
    public Iterator<Coffee> iterator(){
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i = 0; i < 5; i++){
            System.out.println(gen.next());
        }
        for (Object c: new CoffeeGenerator(5)){
            System.out.println(c);
        }
    }
}
