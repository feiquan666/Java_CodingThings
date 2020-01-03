package myenum;

import java.util.Random;

public class Game {
    static final int SIZE = 20;
    private static Random random = new Random(47);
    public static Item newItem(){
        switch (random.nextInt(3)){
            default:
            case 0:return new Rock();
            case 1:return new Scissors();
            case 2:return new Paper();
        }
    }

    public static void match(Item a,Item b){
        System.out.println(a + " VS "+ b+": "+b.compete(a));
    }
    public static void main(String[] args) {
        for (int i =0;i<SIZE;i++){
            match(newItem(),newItem());
        }
    }
}
enum OutCome{胜,负,平}
interface Item{
    OutCome compete(Item item);
    OutCome eval(Paper paper);
    OutCome eval(Rock rock);
    OutCome eval(Scissors scissors);
}
class Paper implements Item{
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return OutCome.平;
    }

    @Override
    public OutCome eval(Rock rock) {
        return OutCome.胜;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return OutCome.负;
    }
    public String toString(){
        return "布";
    }
}
class Rock implements Item{
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return OutCome.负;
    }

    @Override
    public OutCome eval(Rock rock) {
        return OutCome.平;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return OutCome.胜;
    }
    public String toString(){
        return "石头";
    }
}
class Scissors implements Item{
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return OutCome.胜;
    }

    @Override
    public OutCome eval(Rock rock) {
        return OutCome.负;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return OutCome.平;
    }
    public String toString(){
        return "剪刀";
    }
}