package variety.practice2;

public class TupleTest {
    static TwoTuple<String,Integer> f0(){
        return new TwoTuple<>("hi",45);
    }
    static ThreeTuple<Apple,String,Integer> f1(){
        return new ThreeTuple<>(new Apple(),"苹果",10);
    }
    static FourTuple<Apple,String,Integer,Rice> f2(){
        return new FourTuple<>(new Apple(),"苹果",15,new Rice());
    }
    static FiveTuple<Apple,String,Integer,Rice,Double> f3(){
        return new FiveTuple<>(new Apple(),"苹果",18,new Rice(),16.0);
    }
    public static void main(String[] args) {
        TwoTuple<String,Integer> twoTuple = f0();
//        twoTuple.second = 6;
        System.out.println(twoTuple);
        System.out.println(f1());
        System.out.println(f2());
        System.out.println(f3());
    }
}
class Apple{}
class Rice{}
