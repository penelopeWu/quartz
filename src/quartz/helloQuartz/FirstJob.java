package quartz.helloQuartz;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;

/**
 * Created by penelope on 2017/7/3.
 */
public class FirstJob implements Job {
	
	private String jobMsg;
	private String trMsg;
	private Double trDouble;

	public String getJobMsg() {
		return jobMsg;
	}

	public void setJobMsg(String jobMsg) {
		this.jobMsg = jobMsg;
	}

	public String getTrMsg() {
		return trMsg;
	}

	public void setTrMsg(String trMsg) {
		this.trMsg = trMsg;
	}

	public Double getTrDouble() {
		return trDouble;
	}

	public void setTrDouble(Double trDouble) {
		this.trDouble = trDouble;
	}

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Calendar calendar = java.util.Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current time is: " + dateFormat.format(calendar.getTime()));
		
		
		/**
		 * 当 Job 触发器触发时（在某个时刻），execute(..)就被 scheduler所调用。
		 * JobExecutionContext 对象被传递给这个方法，它为 Job 实例提供了它的“运行时”环境:
		 * 1, 一个指向执行这个 Job 实例的 Scheduler 句柄，
		 * 2, 一个指向触发该次执行的触发器的句柄，
		 * 3, Job 的 JobDetail 对象以及一些其他的条目。
		 */
		
		// 从jobExecutionContext中获取Scheduler.
		@SuppressWarnings("unused")
		Scheduler scheduler = jobExecutionContext.getScheduler();
		
		//从jobExecutionContext中获取JobDetail和Trigger
		JobDetail jobDetail = jobExecutionContext.getJobDetail();
		System.out.println("job name and group are: " + jobDetail.getKey().getName() + ": " + jobDetail.getKey().getGroup());
		
		Trigger trigger = jobExecutionContext.getTrigger();
		System.out.println("trigger name and group are:" + trigger.getKey().getName() + ":" + trigger.getKey().getGroup());
		
		/**
		 * 方法一：从JobDataMap中获取JobDetail和Trigger的data
		 */
/*
		JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
		JobDataMap trDataMap = jobExecutionContext.getTrigger().getJobDataMap();
		
		String jobMsg = jobDataMap.getString("jobMsg");
		String trMsg = trDataMap.getString("trMsg");
		Double tDouble = trDataMap.getDouble("trDouble");
		
		System.out.println("jobMsg------- : " + jobMsg );
		System.out.println("trMsg------- : " + trMsg );
		System.out.println("tDouble------- : " + trDouble );
*/
		
		/**
		 * 方法二：Job类中添加JobDataMap中对应的属性和setter方法。Job类中的属性名称要和JobDataMap中的key值一致。
		 */
//		JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
		System.out.println("jobMsg------- : " + jobMsg );
		System.out.println("trMsg------- : " + trMsg );
		System.out.println("trDouble------- : " + trDouble );
		System.out.println("==========================================================");
		
	}

}
