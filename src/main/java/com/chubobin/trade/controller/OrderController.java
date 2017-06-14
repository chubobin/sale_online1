package com.chubobin.trade.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chubobin.trade.bean.OBJECT_T_MALL_ORDER;
import com.chubobin.trade.bean.T_MALL_ADDRESS;
import com.chubobin.trade.bean.T_MALL_ORDER_info;
import com.chubobin.trade.bean.T_MALL_SHOPPINGCAR;
import com.chubobin.trade.bean.T_MALL_USER;
import com.chubobin.trade.service.AddressService;
import com.chubobin.trade.service.OrderService;

@Controller
@SessionAttributes({"allOrder","list_cart_session"})
public class OrderController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;
	@RequestMapping("/confirm_pay")
	public String confirm_pay(@ModelAttribute("allOrder")List<OBJECT_T_MALL_ORDER> allOrder){
		
		try {
			orderService.save_order_final(allOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(e.getMessage().equals("over_sale")){
				return "over_sale_exception";
			}
		}
		
		return "success";
	}
	@RequestMapping("/to_order_pay")
	public String to_order_pay(@ModelAttribute("allOrder")List<OBJECT_T_MALL_ORDER> allOrder,Map map){
		BigDecimal sum = new BigDecimal("0");
		for (OBJECT_T_MALL_ORDER order : allOrder) {
			sum=sum.add(order.getZje());
		}
		map.put("sum", sum);
		return "order_pay";
	}
	@RequestMapping("/to_order_page")
	public String to_order_page(HttpSession session,Map map){
		T_MALL_USER user=(T_MALL_USER) session.getAttribute("user");
		List<T_MALL_SHOPPINGCAR> list_cart_new1=(List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
		List<T_MALL_ADDRESS> list_address=addressService.get_addressess_by_userid(user.getId());
		//开始拆分订单
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		
		for (T_MALL_SHOPPINGCAR cart : list_cart_new1) {
			if(cart.getShfxz().equals("1")){
				list_cart.add(cart);
			}
		}
		//根据购物车的库存地址选项进行筛选订单

		Set<String> addressess=new HashSet<>();
		for (T_MALL_SHOPPINGCAR cart : list_cart) {
			addressess.add(cart.getKcdz());
		}
		Iterator<String> iterator = addressess.iterator();
		

		//根据库存地址确定订单个数
		List<OBJECT_T_MALL_ORDER> allOrder=new ArrayList<>();
		while(iterator.hasNext()){
			String next = iterator.next();
			List<T_MALL_SHOPPINGCAR> list_cart_new =new ArrayList<>();
			OBJECT_T_MALL_ORDER object_T_MALL_ORDER = new OBJECT_T_MALL_ORDER();
			object_T_MALL_ORDER.setJdh(1);
			object_T_MALL_ORDER.setYh_id(user.getId());
			ArrayList<T_MALL_ORDER_info> list_order_info = new ArrayList<>();
			for (T_MALL_SHOPPINGCAR cart : list_cart) {
				
				if(next.equals(cart.getKcdz())){
					T_MALL_ORDER_info orderInfo = new T_MALL_ORDER_info();
					list_cart_new.add(cart);
					orderInfo.setSku_id(cart.getSku_id());
					orderInfo.setSku_mch(cart.getSku_mch());
					orderInfo.setShp_tp(cart.getShp_tp());
					orderInfo.setSku_jg(cart.getSku_jg());
					orderInfo.setSku_shl(cart.getTjshl());
					orderInfo.setSku_kcdz(cart.getKcdz());
					orderInfo.setGwch_id(cart.getId());
					list_order_info.add(orderInfo);
				}
			}
			object_T_MALL_ORDER.setZje(get_sum_4cart(list_cart_new));
			object_T_MALL_ORDER.setOrderinfo(list_order_info);
			allOrder.add(object_T_MALL_ORDER);
		}
		map.put("list_address", list_address);
		map.put("allOrder", allOrder);
		return "order_produce";
	}
	@RequestMapping("/to_submit_order")
	public String to_submit_order(@ModelAttribute("allOrder")List<OBJECT_T_MALL_ORDER> allOrder,@ModelAttribute("list_cart_session")List<T_MALL_SHOPPINGCAR> list_cart_session,T_MALL_ADDRESS address){
		//先将地址数据加入到订单中
		for (OBJECT_T_MALL_ORDER order : allOrder) {
			order.setDzh_id(address.getId());
			order.setDzh_mch(address.getYh_dz());
			order.setShhr(address.getShjr());
		}
		//将订单数据实例花到内存
		List<Integer> save_order = orderService.save_order(allOrder);
		//最后将session中的数据删除同订单相同的数据删除
		Iterator<T_MALL_SHOPPINGCAR> iterator = list_cart_session.iterator();
		while(iterator.hasNext()){
			T_MALL_SHOPPINGCAR next = iterator.next();
			if(save_order.contains(next.getId())){
				iterator.remove();
			}
		}
		return "redirect:/to_order_pay.html";
	}
	public BigDecimal get_sum_4cart(List<T_MALL_SHOPPINGCAR> list_cart){
		if(list_cart!=null){
			BigDecimal sum=new BigDecimal("0");
			for (T_MALL_SHOPPINGCAR cart : list_cart) {
				if(cart.getShfxz().equals("1")){
					sum=sum.add(cart.getHj());
				}
			}
			return sum;
		}else{
			return new BigDecimal("0");
		}
		
	}
}
