package com.chubobin.trade.service;

import javax.jws.WebService;

import com.chubobin.trade.bean.T_MALL_USER;

@WebService
public interface UserService {
	//用户登录方法
	public T_MALL_USER login_user(String yh_mch,String yh_mm);
	
	//用户注册方法
	public int regist_user(T_MALL_USER user);
}
