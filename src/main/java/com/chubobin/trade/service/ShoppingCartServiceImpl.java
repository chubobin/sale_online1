package com.chubobin.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubobin.trade.bean.T_MALL_SHOPPINGCAR;
import com.chubobin.trade.mapper.ShoppingCartMapper;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Override
	public List<T_MALL_SHOPPINGCAR> get_shopping_cart_data() {
		return shoppingCartMapper.select_shopping_cart_data();
		
	}
	@Override
	public void save_cart_data(T_MALL_SHOPPINGCAR cart) {
		shoppingCartMapper.insert_cart_data(cart);
	}
	@Override
	public void modify_cart_data(T_MALL_SHOPPINGCAR cart) {
		shoppingCartMapper.update_cart_data(cart);
	}

}
