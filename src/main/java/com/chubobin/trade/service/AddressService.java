package com.chubobin.trade.service;

import java.util.List;

import javax.jws.WebService;

import com.chubobin.trade.bean.OBJECT_T_MALL_ORDER;
import com.chubobin.trade.bean.T_MALL_ADDRESS;

@WebService
public interface AddressService {
	//保存用户地址
	public int save_address(T_MALL_ADDRESS address);
	//通过地址id获得地址
	public T_MALL_ADDRESS get_address_by_id(int id);
	//通过用户id获得地址
	public List<T_MALL_ADDRESS> get_addressess_by_userid(int user_id);
}
