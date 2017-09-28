package quartz.followDoc.triggers;

import java.util.Calendar;
import java.util.Date;

import org.quartz.SimpleTrigger;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class UsageOfSimpleTrigger {

	public static void main(String[] args) {
		
		/*public SimpleTrigger(String name,
				 String group,
				 Date startTime,
				 Date endTime,
				 int repeatCount,
				 long repeatInterval) 
		*/
		
		long startTime = System.currentTimeMillis() + 10000L;
		// 从现在 10 秒钟后开始触发，并且只触发一次。
		SimpleTrigger simpleTrigger0 = new SimpleTriggerImpl("trigger0",null,new Date(startTime),null,0,0L);
		
		// 创建一个立即触发的触发器，并且每隔 60 秒钟触发一次，直到永远。
		SimpleTrigger simpleTrigger1 = new SimpleTriggerImpl("trigger1",null,new Date(),null,SimpleTrigger.REPEAT_INDEFINITELY,60L*1000L);

		//创建一个立即触发的触发器，并且每隔 10 秒重复一次，直到 40 秒钟以后。
		long endTime = System.currentTimeMillis() + 40000L;
		SimpleTrigger simpleTrigger2 = new SimpleTriggerImpl("trigger2",null,new Date(),new Date(endTime),SimpleTrigger.REPEAT_INDEFINITELY,10L*1000L);
		
		// 创建一个触发器，开始触发时间为 2002 年 3 月 17 上午 10：30 分，并且重复 5 次。（总共触发 6 次）每次延迟 30 秒钟。
		java.util.Calendar cal = new java.util.GregorianCalendar(2002, Calendar.MARCH, 17);
		cal.set(cal.HOUR, 10);
		cal.set(cal.MINUTE, 30);
		cal.set(cal.SECOND, 0);
		cal.set(cal.MILLISECOND, 0);
		Date startTime1 = cal.getTime();
		SimpleTrigger simpleTrigger3 = new SimpleTriggerImpl("trigger3",null,startTime1,null,5,30L*1000L);
		SimpleTrigger simpleTrigger4 = new SimpleTriggerImpl();
		SimpleTrigger simpleTrigger5 = new SimpleTriggerImpl();
		SimpleTrigger simpleTrigger6 = new SimpleTriggerImpl();
		SimpleTrigger simpleTrigger7 = new SimpleTriggerImpl();

		
	}
}
