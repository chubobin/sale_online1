package com.chubobin.trade.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PasswordUtil {
	
	public static void main(String[] args) {
		get_password("22333","xiaoming");
	}
	public static String get_password(String password,String username){
		
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmm");
		String date = format.format(new Date());
		String md5 = MD5Util.md5(username.substring(0,3)+password+date);
		System.out.println(md5);
		return md5;
		
	}
}
