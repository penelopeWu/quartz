package quartz.helloQuartz;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

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
//		System.out.println("Hello Quartz Job!");
		
		/**
		 * 从jobExecutionContext中获取JobDetail和Trigger
		 */
		JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
		System.out.println("job name and group are: " + jobKey.getName() + ": " + jobKey.getGroup());
		
		TriggerKey trKey = jobExecutionContext.getTrigger().getKey();
		System.out.println("trigger name and group are:" + trKey.getName() + ":" + trKey.getGroup());
		
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
		
	}

}
