package myannoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 你的注解将应用于什么地方（一个方法或者域）
@Target(ElementType.METHOD)
// 用来定义该注解在哪一个级别可用（source、class、runtime）
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}
