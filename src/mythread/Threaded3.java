package mythread;

import java.util.Date;

public class Threaded3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new AddThread();
        Thread thread1 = new DecThread();
        thread0.start();
        thread1.start();
        thread0.join();
        thread1.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static int count = 0;
    public static Object lock = new Object();
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count++;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count--;
            }
        }
    }
}
