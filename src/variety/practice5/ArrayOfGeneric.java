package variety.practice5;
class Generic<T>{}
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gs;

    public static void main(String[] args) {
        gs = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gs.getClass().getSimpleName());
        gs[0]  =new Generic<>();
        System.out.println(gs[0]);
    }
}
