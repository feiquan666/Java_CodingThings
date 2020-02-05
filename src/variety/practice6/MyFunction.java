package variety.practice6;


public class MyFunction{

    public static void main(String[] args) {
        Function<Integer,Integer> fa = (i)-> i + 1;
        Function<Integer,Integer> fb = (i)-> i * i;
        // exp1:
        System.out.println(fa.apply(fb.apply(3))); // 10,常规用法，fb的结果作为fa的入参
        // 使用compose函数
        System.out.println(fa.compose(fb).apply(3)); // 10
        // 使用andThen函数
        System.out.println(fb.andThen(fa).apply(3)); // 10
        // exp2:
        System.out.println(fb.apply(fa.apply(3))); // 16,常规用法，fa的结果作为fb的入参
        // 使用compose函数
        System.out.println(fb.compose(fa).apply(3)); // 16
        // 使用andThen函数
        System.out.println(fa.andThen(fb).apply(3)); // 16
    }
}
