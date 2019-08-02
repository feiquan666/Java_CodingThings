package fileCompression.myQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MySchedule {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm:ss");
    private static java.util.Calendar calendar = Calendar.getInstance();
    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例
        JobDetail jobDetail = JobBuilder
                .newJob(MyJob.class)//使用刚才编写的Job实例化JobDetail，即将JobDetail与业务类绑定
                .withIdentity("myJob", "Group1")//编写JobDetail的信息
                .build();//调用build方法创建对象
        System.out.println("JobDetail名称："+jobDetail.getKey().getName());
        System.out.println("JobDetail所在组："+jobDetail.getKey().getGroup());
        System.out.println("JobDetail的JobClass："+jobDetail.getJobClass().getName());
        //创建一个Trigger实例，定义该job立即执行，执行频率为1秒
        CronTrigger cronTrigger = TriggerBuilder
                .newTrigger()//实例化
                .startAt(new Date(new Date().getTime()+0))//4秒后执行
                .withIdentity("myTrigger", "Group1")//编写信息
                .withSchedule(//编写触发器规则
                       CronScheduleBuilder.cronSchedule("* * * * * ? *"))//执行次数
                .build();//创建对象
        //创建Schedule实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();//创建Scheduler工厂
        Scheduler scheduler = schedulerFactory.getScheduler();//通过scheduler工厂创建Scheduler
        scheduler.start();//启动
        System.out.println("当前时间"+ simpleDateFormat.format(calendar.getTime()));//输出当前时间
        scheduler.scheduleJob(jobDetail,cronTrigger);//映射,绑定job和Trigger，1对多的关系
    }
}
/**
* 浅谈Job和JobDetail
 * Job是一个实现业务程序的接口，只有一个execute方法，类似于TimerTask的run方法，在里面实现业务逻辑
 * Job的生命周期：每次调度器（Scheduler）执行job时，在调用execute方法之前会创建一个新的job实例，当调度完成后，关联的job对象实例会
 * 被释放，释放的实例会被垃圾回收机制回收。
 * JobDetail为Job实例提供设置属性，以及JobDataMap成员变量属性，用它来存储特定的Job实例的状态信息，调度器需要借助JobDetail对象来添
 * 加Job实例。
 * 重要属性：name，任务名称；group，所在组；jobClass，任务的实现类；jobDataMap，状态信息
*/

/**
* 浅谈JobExecutionContext
 * 当Scheduler调用一个job时，就会将JobExecutionContext传递给Job的execute方法；
 * Job可以通过Job ExecutionContext对象访问到Quartz运行时候的环境以及Job本身的明细数据
*/

/**
* 浅谈JobDataMap
 * 在进行任务调度时JobDataMap存储在JobExecutionContext中，方便获取
 * JobDataMap可以用来装载任何可序列化的数据对象，当job实例对象被执行时，这些参数对象会传递给它
 * JobDataMap实现了Map接口，并添加了一些非常方便的方法用来存储基本数据类型
 * 使用usingJobData(key,val)传入参数
*/

/**
* 浅谈Trigger
 * Quartz中的触发器，用来告诉调度程序scheduler作业什么时候发生，以及发生的频率。即Trigger是用来出发Job的
*/
