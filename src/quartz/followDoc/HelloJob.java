package quartz.followDoc;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	public HelloJob(){
		
	}
	/**
	 * 当 Job 触发器触发时（在某个时刻），execute(..)就被 scheduler所调用。
	 * JobExecutionContext 对象被传递给这个方法，它为 Job 实例提供了它的“运行时”环境:
	 * 1, 一个指向执行这个 Job 实例的 Scheduler 句柄，
	 * 2, 一个指向触发该次执行的触发器的句柄，
	 * 3, Job 的 JobDetail 对象以及一些其他的条目。
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

}
