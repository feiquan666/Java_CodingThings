package variety.practice6;

import java.util.Objects;


/**
 * T表示入参，R表示返回值
 * 只有一个apply()方法可供实现类实现
 * 有两个默认方法和一个静态方法
*/
// 函数式接口注解，去掉之后貌似也可以正常运行
@FunctionalInterface
public interface Function<T, R> {
    // 一个简单的方法
    R apply(T t);
    // 逆接函数，入参是先执行的函数Function（实现类）对象
    // before.apply()返回的肯定是子类型，入参肯定要比V的类型大
    // 从返回结果来看，应该是实现了一个将before.apply()返回值作为入参的接口实现类对象
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }


    // 顺接函数，入参是后执行的函数Function（实现类）对象
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    // 返回输入参数的函数
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
