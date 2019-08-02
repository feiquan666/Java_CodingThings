package fileCompression;

import java.io.File;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private File file;
    private MyTimerTask(File file){
        this.file = file;
    }
    public static MyTimerTask getMyTimerTask(File file){
       return new MyTimerTask(file);
    }
    @Override
    public void run() {
        try {
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
