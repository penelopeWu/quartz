package quartz.followDoc.triggers;

import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

public class TriggerTest {

	public static void main(String[] args) {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		
//		Scheduler sched = schedulerFactory.getScheduler();
		
		HolidayCalendar cal = new HolidayCalendar();
		cal.addExcludedDate(new Date());
//		sched.addCalendar("myHolidays", cal, false,false);
//		Trigger trigger = TriggerUtils.makeHourlyTrigger(); // 每一个小时触发一次
//		trigger.setStartTime(TriggerUtils.getEvenHourDate(new Date()));//从下一个小时开始
//		trigger.setName("myTrigger1");
//		trigger.setCalendarName("myHolidays");// ..用trigger来安排任务。
		
//		trigger.getMisfireInstruction();//获取未触发指令
//		
//		
//		Trigger trigger2 = TriggerUtils.makeDailyTrigger(8, 0); //每天 8:00 触发
//		trigger.setStartTime(new Date()); // begin immediately
//		trigger2.setName("myTrigger2");
//		trigger2.setCalendarName("myHolidays");//用trigger2 来安排任务
		
	}
}
