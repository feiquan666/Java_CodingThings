package stream.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MyStudent {
    private String name;
    private Integer age;
    private Character sex;
    private BigDecimal balance;

    public MyStudent(String name, Integer age, Character sex, BigDecimal balance) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.balance = balance;
    }
}
