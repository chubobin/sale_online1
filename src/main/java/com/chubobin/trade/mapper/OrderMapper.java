package com.chubobin.trade.mapper;

import java.util.List;
import java.util.Map;

import com.chubobin.trade.bean.OBJECT_T_MALL_ORDER;
import com.chubobin.trade.bean.T_MALL_FLOW;
import com.chubobin.trade.bean.T_MALL_ORDER_info;

public interface OrderMapper {

	void inset_order(OBJECT_T_MALL_ORDER order);

	void insert_order_info(List<T_MALL_ORDER_info> list);

	void insert_flow(T_MALL_FLOW flow);

	void delete_shoppingcart_by_id(List<Integer> list);

	void update_order(OBJECT_T_MALL_ORDER order);

	void update_flow(T_MALL_FLOW t_MALL_FLOW);

	int select_kc_for_update(int sku_id);

	void update_xl_by_sku_id(Map<String, Object> param);

}
