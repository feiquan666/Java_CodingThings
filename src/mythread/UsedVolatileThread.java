package mythread;

public class UsedVolatileThread implements Runnable{
    private volatile boolean flag = true;

    @Override
    public void run() {
        for (;;){
            flag = !flag;
            System.out.println(Thread.currentThread().getName()+"---"+flag);
        }
    }

    public static void main(String[] args) {
        UsedVolatileThread thread = new UsedVolatileThread();
        Thread thread1 = new Thread(thread,"线程1");
        Thread thread2 = new Thread(thread,"线程2");
        Thread thread3 = new Thread(thread,"线程3");
        Thread thread4 = new Thread(thread,"线程4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.currentThread().interrupt();
    }
}
