package com.chubobin.trade.mapper;

import java.util.List;

import com.chubobin.trade.bean.T_MALL_SHOPPINGCAR;

public interface ShoppingCartMapper {

	List<T_MALL_SHOPPINGCAR> select_shopping_cart_data();

	void insert_cart_data(T_MALL_SHOPPINGCAR cart);

	void update_cart_data(T_MALL_SHOPPINGCAR cart);

}
