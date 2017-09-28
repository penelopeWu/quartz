package quartz.followDoc.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

@SuppressWarnings("deprecation")
public class FirstStatefulJob implements StatefulJob {

	/**
	 * 一个 Job 实例可以被定义为“有状态的”或者“无状态的”。
	 * “无状态的”任务只拥有它们被加入到 scheduler 时所存储的JobDataMap。
	 * 这意味着，在执行任务过程中任何对 Job Data Map 所作的更改都将丢失而且任务下次执行时也无法看到。
	 * 你可能会猜想出，有状态的任务恰好相反，它在任务的每次执行之后重新存储 JobDataMap。
	 * 有状态任务的一个副作用就是它不能并发执行。
	 * 换句话说，如果任务有状态，那么当触发器在这个任务已经在执行的时候试图触发它，
	 * 这个触发器就会被阻塞（等待），直到前面的执行完成。
	 * 
	 * 想使任务有状态，它就要实现StatefulJob接口而不是实现Job接口。
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

}
