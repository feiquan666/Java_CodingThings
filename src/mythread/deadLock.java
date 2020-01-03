package mythread;

public class deadLock {
    public static void main(String[] args) throws InterruptedException{
        Number number = new Number();
        Thread t1 = new Thread(()->{
            number.add(5);
        });
        Thread t2 = new Thread(()->{
            number.dec(5);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(number.val);
        System.out.println(number.another);
    }
}
class Number{
    public int val = 0;
    public int another= 0;
    private Object lockA = new Object();
    private Object lockB = new Object();
    public void add(int num){
        synchronized (lockA) {
            this.val += num;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                this.another+=num;
            }
        }
    }
    public void dec(int num){
        synchronized (lockA) {
            this.val -= num;
            synchronized (lockB) {
                this.another -= num;
            }
        }
    }
}
