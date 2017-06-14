package com.chubobin.trade.service;

import java.util.List;

import com.chubobin.trade.bean.T_MALL_SHOPPINGCAR;

public interface ShoppingCartService {

	List<T_MALL_SHOPPINGCAR> get_shopping_cart_data();

	void save_cart_data(T_MALL_SHOPPINGCAR cart);

	void modify_cart_data(T_MALL_SHOPPINGCAR cart);

}
