package myannoation.sqlAnnotation;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
