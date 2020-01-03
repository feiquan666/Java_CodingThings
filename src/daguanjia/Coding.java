package daguanjia;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Coding {
    @Test
    public void test01() {
        BigDecimal bigDecimal = new BigDecimal(34);
        bigDecimal = bigDecimal.pow(17);
        System.out.println(bigDecimal);
        bigDecimal = bigDecimal.remainder(new BigDecimal(6));
        System.out.println(bigDecimal);
    }

    @Test
    public void test02() {
        /**
         * 5:     101
         * 7:     111
         * 按位或得：111
         */
        System.out.println(5 | 7);
    }

    @Test
    public void test03() {
        /**
         * 进栈顺序：ABCDE
         * 出栈不可能是：EABCD
         */
    }

    @Test
    public void test04() {
        long temp = (byte) 9999;
//        temp = temp % 2;
        System.out.println(temp);// out: 1
        System.out.println(Math.floorMod(12,-10));
    }

    public static void main(String[] args) {
    }
}
