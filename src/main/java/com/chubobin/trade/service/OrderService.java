package com.chubobin.trade.service;

import java.util.List;

import com.chubobin.trade.bean.OBJECT_T_MALL_ORDER;
import com.chubobin.trade.util.OverSaleException;

public interface OrderService {

	List<Integer> save_order(List<OBJECT_T_MALL_ORDER> allOrder);

	void save_order_final(List<OBJECT_T_MALL_ORDER> allOrder) throws OverSaleException;

}
