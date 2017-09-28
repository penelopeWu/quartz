package quartz.helloQuartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by penelope on 2017/7/3.
 */
public class FirstScheduler {
	public static void main(String[] args) throws SchedulerException {

		JobDetail jobDetail = JobBuilder.newJob(FirstJob.class)//获取JobDetail实例，并绑定FisrtJob类
				.withIdentity("myJob", "group1")//定义Job的名称和组别
				.usingJobData("jobMsg", "this is jobDetail message.")//定义jobDataMap中的数据，传递给Job实现类
				.build();

		System.out.println("jobDetail's name: " + jobDetail.getKey().getName());
		System.out.println("jobDetail's group:" + jobDetail.getKey().getGroup());
		System.out.println("jobDetail's jobClass : " + jobDetail.getJobClass().getName());

		// 创建一个Trigger实例，定义该Job立即执行，并且每隔2秒重复执行
		Trigger trigger = TriggerBuilder.newTrigger()//过去trigger实例
				.withIdentity("myTrigger", "group1")//定义trigger的名称和组别
				.usingJobData("trMsg", "this is trigger message.")//定义jobDataMap中的数据，传递给Job实现类
				.usingJobData("trDouble", 3.0)//定义jobDataMap中的数据，传递给Job实现类
				.startNow()
				.withSchedule(SimpleScheduleBuilder
						.simpleSchedule()
						.withIntervalInSeconds(2)
						.withRepeatCount(2)
						.repeatForever())
				.build();

		// 创建Scheduler实例
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		// 执行
		scheduler.scheduleJob(jobDetail, trigger);//将JobDetail实例传递给scheduler，其实是把job和trigger告知scheduler.
//		scheduler.shutdown();
	}
}
