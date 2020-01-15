package variety.practice2;

public class FiveTuple<A,B,C,D,E>extends FourTuple<A,B,C,D> {
    public final E fifth;

    public FiveTuple(A a, B b, C third, D fourth, E e) {
        super(a, b, third, fourth);
        this.fifth = e;
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "fifth=" + fifth +
                ", fourth=" + fourth +
                ", third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
