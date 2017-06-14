package com.chubobin.trade.mapper;

import com.chubobin.trade.bean.T_MALL_USER;

public interface LoginMapper {

	T_MALL_USER select_loginUser(T_MALL_USER user);

}
