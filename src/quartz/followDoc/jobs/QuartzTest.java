package quartz.followDoc.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by penelope on 2017年9月28日
 */
public class QuartzTest {
	public static void main(String[] args) {

		try {
			
			//get the scheduler instance
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			//start it
			scheduler.start();
			
			//define the job and tie it to HelloJob class
			/**
			 * JobDetail 对象由 Quartz 客户端在 Job 被加入到 scheduler 时创建。
			 * 它包含了 Job的各种设置属性以及一个 JobDataMap 对象，
			 * 这个对象被用来存储给定 Job 类实例的状态信息。
			 */
			JobDetail job = JobBuilder.newJob(HelloJob.class)
					.withIdentity("job1","group1")
					.build();
			
			//trigger the job to run now,and then repeat every 40 seconds
			/**
			 * Trigger 对象被用来触发 jobs 的执行。
			 * 你希望将任务纳入到进度，要实例化一个Trigger 并且“调整”它的属性以满足你想要的进度安排。
			 * Triggers 也有一个 JobDataMap与之关联，这非常有利于向触发器所触发的 Job 传递参数。
			 * Quartz 打包了很多不同类型的 Trigger,但最常用的 Trigge 类是 SimpleTrigger 和 CronTrigger。
			 * SimpleTrigger 用来触发只需执行一次或者在给定时间触发并且重复 N 次且每次执行延迟一定时间的任务。
			 * CronTrigger 按照日历触发，
			 */
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger1","group1")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(40)
						.repeatForever()
						.withRepeatCount(2))
					.build();
			
			//tell quartz to schedule the job using our trigger
			/**
			 * 当向 Quartz scheduler 中注册 Jobs 和 Triggers 时，它们要给出标识它们的名字。
			 * Jobs 和 Triggers 也可以被放入“组”中。“组”对于后续维护过程中，
			 * 分类管理 Jobs和 Triggers 非常有用。
			 * Jobs 和 Triggers 的名字在组中必须唯一，
			 * 换句话说，Jobs 和Triggers 真实名字是它的名字+组。
			 * 如果使 Job 或者 Trigger 的组为‘null’，
			 * 这等价于将其放入缺省的 Scheduler.DEFAULT_GROUP 组中。
			 */
			scheduler.scheduleJob(job,trigger);
//			scheduler.getListenerManager();
			
			//off it
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
