package com.chubobin.trade.util;

import java.util.HashMap;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.FactoryBean;

import com.chubobin.trade.service.UserService;

public class Myfactorybean<T> implements FactoryBean<T>{
	
	public Class<T> getT() {
		return t;
	}

	public void setT(Class<T> t) {
		this.t = t;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private Class<T> t;
	
	private String url;
	@Override
	public T getObject() throws Exception {
		JaxWsProxyFactoryBean jwpfb=new JaxWsProxyFactoryBean();
		
		jwpfb.setAddress(this.url);
		
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
		T create = jwpfb.create(t);
		return create;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return this.t;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
