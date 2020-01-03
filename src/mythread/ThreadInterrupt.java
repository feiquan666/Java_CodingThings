package mythread;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println("end");
    }
}
class MyThread extends Thread{
    public void run(){
        Thread helloThread = new HelloThread();
        helloThread.start();
        try{
            helloThread.interrupt();
            helloThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class HelloThread extends Thread{
    public void run(){
        int n = 0;
        while (!isInterrupted()){
            n++;
            System.out.println(n+": hello");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
