package variety.practice2;

public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
    public final D fourth;

    public FourTuple(A a, B b, C third, D fourth) {
        super(a, b, third);
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "fourth=" + fourth +
                ", third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
