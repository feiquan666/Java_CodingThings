package mythread;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class MySemaphore {
    Semaphore semaphoreA = new Semaphore(1);
    Semaphore semaphoreB = new Semaphore(0);
    Semaphore semaphoreC = new Semaphore(0);

    @Test
    public void printA() {
        print('a', semaphoreA, semaphoreB);
    }

    public void printB() {
        print('b', semaphoreB, semaphoreC);
    }

    public void printC() {
        print('c', semaphoreC, semaphoreA);
    }

    public void print(char c, Semaphore current, Semaphore nextCurrent) {
        for (int i = 0; i < 10; i++) {
            try {
                current.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(c);
            nextCurrent.release();
        }
    }

    public static void main(String[] args) {
        MySemaphore mySemaphore = new MySemaphore();
        new Thread(() -> {
            mySemaphore.printA();
        }).start();
        new Thread(() -> {
            mySemaphore.printB();
        }).start();
        new Thread(() -> {
            mySemaphore.printC();
        }).start();

    }
}