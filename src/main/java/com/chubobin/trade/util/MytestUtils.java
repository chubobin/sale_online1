package com.chubobin.trade.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MytestUtils {
	
	public static String resolve_properties(String key){
		
		Properties property=new Properties();
		
		InputStream resourceAsStream = 
				MytestUtils.class.getClassLoader().getResourceAsStream("password.properties");
		
		try {
			property.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String property2 = property.getProperty(key);
		
		return property2;
	}
	
}
