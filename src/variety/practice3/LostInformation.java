package variety.practice3;

import java.util.*;

public class LostInformation {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        Map<B,C> map = new HashMap<>();
        C<A> c = new C<>();
        D<Double,Integer> d = new D<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));// E,因为List接口泛型参数是E
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));//K,V,因为Map接口泛型参数是K,V
        System.out.println(Arrays.toString(c.getClass().getTypeParameters()));// E
        System.out.println(Arrays.toString(d.getClass().getTypeParameters()));// F,G
    }
}
class A{}
class B{}
class C<E>{}
class D<F,G>{}
