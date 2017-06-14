package com.chubobin.trade.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubobin.trade.bean.OBJECT_T_MALL_ORDER;
import com.chubobin.trade.bean.T_MALL_FLOW;
import com.chubobin.trade.bean.T_MALL_ORDER_info;
import com.chubobin.trade.mapper.OrderMapper;
import com.chubobin.trade.util.MyDateUtils;
import com.chubobin.trade.util.OverSaleException;
@Service
public class OrderServiceimpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Override
	public List<Integer> save_order(List<OBJECT_T_MALL_ORDER> allOrder) {
		// TODO Auto-generated method stub
		List<Integer> gwch_ids=new ArrayList<>();
		for (OBJECT_T_MALL_ORDER order : allOrder) {
			//插入订单详情
			orderMapper.inset_order(order);
			//插入订单info表，返回主键集合 为后续删除session购物车中的数据做准备
			for(int i=0;i<order.getOrderinfo().size();i++){
				order.getOrderinfo().get(i).setDd_id(order.getId());
				int gwch_id=order.getOrderinfo().get(i).getGwch_id();
				gwch_ids.add(gwch_id);
			}
			orderMapper.insert_order_info(order.getOrderinfo());
			//生成物流信息 并插入物流信息表
			T_MALL_FLOW flow=new T_MALL_FLOW();
			flow.setDd_id(order.getId());
			flow.setMqdd("等待出库");
			flow.setYh_id(order.getYh_id());
			flow.setMdd(order.getDzh_mch());
			orderMapper.insert_flow(flow);
		}
		
		
		
		//删除数据库中购物车的信息
		orderMapper.delete_shoppingcart_by_id(gwch_ids);
		return gwch_ids;
	}
	@Override
	public void save_order_final(List<OBJECT_T_MALL_ORDER> allOrder) throws OverSaleException {
		for (OBJECT_T_MALL_ORDER order : allOrder) {
			
			order.setYjsdshj(MyDateUtils.get_yjddshj(3));
			order.setJdh(2);
			orderMapper.update_order(order);
			
			T_MALL_FLOW t_MALL_FLOW = new T_MALL_FLOW();
			t_MALL_FLOW.setPsshj(MyDateUtils.get_yjddshj(1));
			t_MALL_FLOW.setMqdd("正在出库");
			t_MALL_FLOW.setYwy("老佟");
			t_MALL_FLOW.setLxfsh("13972638385");
			t_MALL_FLOW.setPsmsh("已经捡货");
			t_MALL_FLOW.setDd_id(order.getId());
			orderMapper.update_flow(t_MALL_FLOW);
			boolean b = check_kc(order.getOrderinfo());
			List<T_MALL_ORDER_info> orderinfo = order.getOrderinfo();
			if(b){
			for (T_MALL_ORDER_info info : orderinfo) {
				Map<String,Object> param=new HashMap<>();
				param.put("gmshl", info.getSku_shl());
				param.put("id", info.getSku_id());
				orderMapper.update_xl_by_sku_id(param);
			}
				
			}else{
				//回滚
				throw new OverSaleException("over_sale");
			}
		}
	}
	public boolean check_kc(List<T_MALL_ORDER_info> info){
		boolean b=true;
		for (T_MALL_ORDER_info order_info : info) {
			int count=orderMapper.select_kc_for_update(order_info.getSku_id());
			if(count<order_info.getSku_shl()){
				b=false;
			}
		}
		
		return b;
	}

}

