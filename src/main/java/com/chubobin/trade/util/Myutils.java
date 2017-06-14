package com.chubobin.trade.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

import net.sf.json.JSONArray;

public class Myutils {
	//对对象进行编码和变成json字符串
	public static String jsontoString(Object object){
		
		JSONArray fromObject = JSONArray.fromObject(object);
		String string = fromObject.toString();
		String encode=null;
		try {
			 encode = URLEncoder.encode(string,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encode;
		
		
		
		
	}
	//将json解码成指定的集合
	public static <T> List<T> StringtoList(String json,T tt){
		String decode=null;
		if(!(json.equals("")||json==null)){
		try {
			 decode= URLDecoder.decode(json, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray fromObject = JSONArray.fromObject(decode);
		List<T> list= (List<T>) fromObject.toCollection(fromObject,tt.getClass());
		return list;
		}else{
			return null;
		}
	}
}
