package myannoation.sqlAnnotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示该类只能标识类
 * 如果想要指定多个可标识对象，则以逗号分开，如果不写，则默认可标识所有类型
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    // 表的名字
    String name() default "";
}
