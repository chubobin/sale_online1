package com.chubobin.trade.util;

import java.nio.channels.CancelledKeyException;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {
	
	public static Date get_yjddshj(int i){
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE, i);
		Date time = c.getTime();
		return time;
	}
	
}
