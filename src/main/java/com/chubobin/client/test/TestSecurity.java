package com.chubobin.client.test;

import java.util.HashMap;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.chubobin.trade.bean.T_MALL_USER;
import com.chubobin.trade.service.UserService;
import com.chubobin.trade.util.MyClientCallback;




public class TestSecurity {
	
	public static T_MALL_USER get_data(String yh_mch,String yh_mm) {
		JaxWsProxyFactoryBean jwpfb=new JaxWsProxyFactoryBean();
		
		jwpfb.setAddress("http://localhost:8090/t_mall_user_trade_system/userService?wsdl");
		
		HashMap<String, Object> hashmap= new HashMap<>();
		hashmap.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		hashmap.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
		hashmap.put(WSHandlerConstants.PW_CALLBACK_CLASS, MyClientCallback.class.getName());
		hashmap.put(WSHandlerConstants.USER, "username");
	/*	HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		hashMap.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
		hashMap.put(WSHandlerConstants.PW_CALLBACK_CLASS, MyClientCallback.class.getName());
		hashMap.put(WSHandlerConstants.USER, "username");*/
		
		WSS4JOutInterceptor wss4 = new WSS4JOutInterceptor(hashmap);
		jwpfb.getOutInterceptors().add(wss4);
		UserService create = jwpfb.create(UserService.class);
		 T_MALL_USER login_user = create.login_user(yh_mch, yh_mm);
		return login_user;
	}
}
