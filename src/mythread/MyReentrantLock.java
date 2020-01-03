package mythread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
    private int state = 0;
    private Lock lock = new ReentrantLock();

    /**
     * 假如执行printA的线程进来,state变为1,第二个进来的线程不一定是执行printB的线程,
     * 如果不是不能进入if打印name,直到执行printB的线程进来,state变为2,如此循环下去
    */
    public void printABC(char name,int targetState) {
        for (int i = 0; i < 10;) {
            lock.lock();
            if (state % 3 == targetState) {
                state++;
                i++;
                System.out.print(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyReentrantLock printABCUsingLock = new MyReentrantLock();
        new Thread(() -> {
            printABCUsingLock.printABC('a',0);
        }).start();
        new Thread(() -> {
            printABCUsingLock.printABC('b',1);
        }).start();
        new Thread(() -> {
            printABCUsingLock.printABC('c',2);
        }).start();
    }

}
