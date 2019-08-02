package fileCompression.myQuartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyJob implements Job {
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm:ss");
    private Calendar cl = Calendar.getInstance();
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //编写具体的业务逻辑
        System.out.println("##############################################");
        System.out.println("Hello World！"+sf.format(cl.getTime()));
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("Job Name:"+jobKey.getName());
        System.out.println("Job Group:"+jobKey.getGroup());
        System.out.println("Trigger Name:"+triggerKey.getName());
        System.out.println("Trigger Group:"+triggerKey.getGroup());
        System.out.println("##############################################");
    }
}
