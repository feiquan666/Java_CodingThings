package mythread;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 2; i++){
                tasks.addTask("t1="+LocalDateTime.now().toString());
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 2; i++){
                tasks.addTask("t2="+LocalDateTime.now().toString());
            }
        });
        Thread t3 = new Thread(() ->{
            for (int i = 0; i < 2; i++){
                tasks.addTask("t3="+LocalDateTime.now().toString());
            }
        });
        t1.start();
        t2.start();
        t3.start();
        Thread t4 = new Thread(()->{
            while (true) {
                System.out.println("执行任务="+tasks.getTask());
            }
        });
        t4.start();
    }
}
class Tasks{
    Queue<String> tasks = new LinkedList<>();
    public synchronized void addTask(String taskName){
        tasks.add(taskName);
        this.notifyAll();
    }
    public synchronized  String getTask(){
        while (tasks.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tasks.remove();
    }
}
