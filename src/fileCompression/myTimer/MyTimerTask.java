package fileCompression.myTimer;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String name;
    Integer count = 3;
    public MyTimerTask(String name){
        this.name = name;
    }
    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(this.name+"为您报时："+simpleDateFormat.format(calendar.getTime()));
        this.count--;
    }
}
