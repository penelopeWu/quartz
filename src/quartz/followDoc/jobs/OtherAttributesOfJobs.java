package quartz.followDoc.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

import quartz.helloQuartz.FirstJob;

public class OtherAttributesOfJobs {
	public static void main(String[] args) {
		
		/**
		 * 这里简短地总结一下通过 JobDetail 对象可以定义 Job 的其它属性。
		 * • Durability（持久性）-如果一个 Job 是不持久的， 一旦没有触发器与之关联，它就会被从 scheduler 中自动删除。
		 * • Volatility（无常性）-如果一个 Job 是无常的,在重新启动 Quartz i scheduler 时它不能被保持。
		 * • RequestsRecovery（请求恢复能力） -如果一个 Job 具备“请求恢复”能力，当它在执行时遇到 scheduler “硬性的关闭”（例如：执行的过程崩溃，或者计算机被关机），
		 * 那么当 scheduler 重新启动时，这个任务会被重新执行。
		 * 这种情况下，JobExecutionContext.isRecovering() 方法的返回值将是 true。
		 * • JobListeners（任务监听器） -一个 Job 如果有 0 个或者多个 JobListeners 监听器与之相关联，
		 * 当这个 Job 执行时，监听器被会被通知。
		 */
		
		@SuppressWarnings("unused")
		JobDetail jobDetail = JobBuilder.newJob(FirstJob.class)//获取JobDetail实例，并绑定FisrtJob类
				.storeDurably(true)
				.requestRecovery(true)
				.build();
	}
}
