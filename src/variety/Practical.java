package variety;

public class Practical<A,B> {
    public final A first;
    public final B second;
    public Practical(A a,B b){
        this.first = a;
        this.second = b;
    }
    public String toString(){
        return "("+first+","+second+")";
    }
}
class A{}
class B extends A{}
class C extends B{}
