package mythread;

public class Thread5 {
    private int count = 0;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }


    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Thread5 c1 = new Thread5();
        Thread5 c2 = new Thread5();
        Thread t1 = new Thread(() -> {
            c1.add(5);
        });
        Thread t2  = new Thread(() -> {
            c1.dec(5);
        });
        Thread t3  = new Thread(() -> {
            c2.add(5);
        });
        Thread t4  = new Thread(() -> {
            c2.dec(5);
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(c1.count);
        System.out.println(c2.count);
    }
}
