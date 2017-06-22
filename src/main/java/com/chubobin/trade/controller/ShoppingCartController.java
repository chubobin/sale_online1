package com.chubobin.trade.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chubobin.trade.bean.T_MALL_SHOPPINGCAR;
import com.chubobin.trade.bean.T_MALL_USER;
import com.chubobin.trade.service.ShoppingCartService;
import com.chubobin.trade.util.Myutils;
import com.google.gson.Gson;

@Controller
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	//改变购物车的数据
	@RequestMapping("/change_shoppingcart")
	public String change_shoppingcart(@CookieValue(value="list_cart_cookie",required=false)String list_cart_cookie_string,HttpSession session,T_MALL_SHOPPINGCAR shoppingcart,HttpServletResponse response,Map map){
		T_MALL_USER user=(T_MALL_USER) session.getAttribute("user");
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		if(user!=null){
			//用户已经登录，就对数据库和session进行操作
			list_cart=(List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
			for (T_MALL_SHOPPINGCAR cart : list_cart) {
				if(cart.getId()==shoppingcart.getId()){
					//传递上来的参数和session中的数据相等时
					if(shoppingcart.getTjshl()==-1){
						//说明只点击了复选框，那就只需要改变选中状态即可
						cart.setShfxz(shoppingcart.getShfxz());
					}else{
						//说明点击的数量键那就改变购物车的数量
						cart.setTjshl(shoppingcart.getTjshl());
						cart.setHj(new BigDecimal(""+cart.getTjshl()).multiply(cart.getSku_jg()));
					}
					shoppingCartService.modify_cart_data(cart);
				}
			}
			
		}else{
			//用户还未登录就对cookie进行操作
				 list_cart = Myutils.StringtoList(list_cart_cookie_string,new T_MALL_SHOPPINGCAR());
				 for (T_MALL_SHOPPINGCAR cart : list_cart) {
					if(cart.getSku_id()==shoppingcart.getSku_id()){
						if(shoppingcart.getTjshl()==-1){
							//只点击了复选狂
							cart.setShfxz(shoppingcart.getShfxz());
						}else{
							//点击了添加数量键
							cart.setTjshl(shoppingcart.getTjshl());
							cart.setHj(new BigDecimal(""+cart.getTjshl()).multiply(cart.getSku_jg()));
						}
					}
				}
				 String jsontoString = Myutils.jsontoString(list_cart);
					//cookie中没有购物车数据
					Cookie cookie =new Cookie("list_cart_cookie",jsontoString);
					cookie.setMaxAge(60*60*24);
					response.addCookie(cookie);
		}
		map.put("sum",get_sum_4cart(list_cart));
		map.put("count",get_cart_count(list_cart));
		map.put("listcart", list_cart);
		return "shoppingcart";
	}
	@RequestMapping("/goto_shoppingcart")
	public String goto_shoppingcart(@CookieValue(value="list_cart_cookie",required=false) String list_cart_cookie_string,HttpSession session,Map map){
		T_MALL_USER user=(T_MALL_USER) session.getAttribute("user");
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		if(user==null){
			//用户还没有登录
			if(list_cart_cookie_string!=null&&!list_cart_cookie_string.equals("")){
			 list_cart = Myutils.StringtoList(list_cart_cookie_string,new T_MALL_SHOPPINGCAR());
			 for (T_MALL_SHOPPINGCAR shoppingcart : list_cart) {
				shoppingcart.setHj(new BigDecimal(shoppingcart.getTjshl()+"").multiply(shoppingcart.getSku_jg()));
			}
			}
		}else{
			//用户已经登录
			list_cart=(List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
			 for (T_MALL_SHOPPINGCAR shoppingcart : list_cart) {
					shoppingcart.setHj(new BigDecimal(shoppingcart.getTjshl()+"").multiply(shoppingcart.getSku_jg()));
				}
		}
		map.put("count",get_cart_count(list_cart));
		map.put("sum",get_sum_4cart(list_cart));
		map.put("listcart", list_cart);
		return "shoppingcart";
	}
	@RequestMapping("/get_minicart")
	public String get_minicart(@CookieValue(value="list_cart_cookie",required=false) String list_cart_cookie_string,HttpSession session,Map map){
		T_MALL_USER user=(T_MALL_USER) session.getAttribute("user");
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		if(user==null){
			//用户还没有登录
			if(list_cart_cookie_string!=null&&!list_cart_cookie_string.equals("")){
			 list_cart = Myutils.StringtoList(list_cart_cookie_string,new T_MALL_SHOPPINGCAR());
			}
		}else{
			//用户已经登录
			list_cart=(List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
		}
		map.put("count",get_cart_count(list_cart));
		map.put("sum",get_sum_4cart(list_cart));
		map.put("listcart", list_cart);
		return "mini_shoppingcart";
	}
	//添加购物车
	@RequestMapping("/add_cart")
	public ModelAndView add_cart(T_MALL_SHOPPINGCAR cart,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		T_MALL_USER user=(T_MALL_USER) session.getAttribute("user");
		List<T_MALL_SHOPPINGCAR> list_cart_cookie=new ArrayList<>();
		
		Gson gson= new Gson();
		if(user!=null){
			List<T_MALL_SHOPPINGCAR> list_cart_session=(List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
			//用户已经登录
			if(list_cart_session==null||list_cart_session.size()==0){
				//数据库中没有数据就向数据库中插入一条数据
				//我要试试git好不好使
				cart.setYh_id(user.getId());
				cart.setHj(new BigDecimal(cart.getTjshl()).multiply(cart.getSku_jg()));
				shoppingCartService.save_cart_data(cart);
				list_cart_session.add(cart);
			}else{
				//数据库中有数据
				boolean bb = is_new_cart(list_cart_session,cart);
				if(bb){
					//是一条新数据
					cart.setYh_id(user.getId());
					cart.setHj(new BigDecimal(cart.getTjshl()).multiply(cart.getSku_jg()));
					shoppingCartService.save_cart_data(cart);
					list_cart_session.add(cart);
				}else{
					//是一条老数据
					for (T_MALL_SHOPPINGCAR shopcart : list_cart_session) {
						if(shopcart.getSku_id()==cart.getSku_id()){
							shopcart.setTjshl(cart.getTjshl()+shopcart.getTjshl());
							shopcart.setHj(new BigDecimal(cart.getTjshl()).multiply(cart.getSku_jg()));
							shopcart.setKcdz(cart.getKcdz());
							shoppingCartService.modify_cart_data(shopcart);
							
						}
					}
					
				}
			}
			System.out.println("11111");
		}else{
			//用户还未登录
			
			
			//json需要进行编码
			Cookie[] cookies = request.getCookies();
			if(cookies==null||cookies.length==0){
				list_cart_cookie.add(cart);
				
				String jsontoString = Myutils.jsontoString(list_cart_cookie);
				//cookie中没有购物车数据
				Cookie cookie =new Cookie("list_cart_cookie",jsontoString);
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
			}else{
				boolean flag=false;
				//cookie中含有数据
				for (Cookie cookie1 : cookies) {
					if(cookie1.getName().equals("list_cart_cookie")){
						String value = cookie1.getValue();
						List<T_MALL_SHOPPINGCAR> list_cart_cookie1 = Myutils.StringtoList(value,new T_MALL_SHOPPINGCAR());
						if(list_cart_cookie1==null){
							list_cart_cookie1=new ArrayList<>();
						}
						//cookie含有购物车数据
						boolean b=is_new_cart(list_cart_cookie1,cart);
						if(b){
							//插入的是新数据
							list_cart_cookie1.add(cart);
							String jsontoString = Myutils.jsontoString(list_cart_cookie1);
							//json需要进行编码
							Cookie cookie =new Cookie("list_cart_cookie",jsontoString);
							cookie.setMaxAge(60*60*24);
							response.addCookie(cookie);
						}else{
							//插入的是老数据
							for (T_MALL_SHOPPINGCAR shoppingcart : list_cart_cookie1) {
								if(shoppingcart.getSku_id()==cart.getSku_id()){
									shoppingcart.setTjshl(cart.getTjshl()+shoppingcart.getTjshl());
									shoppingcart.setHj(new BigDecimal(shoppingcart.getTjshl()).multiply(shoppingcart.getSku_jg()));
								}
							}
							String jsontoString = Myutils.jsontoString(list_cart_cookie1);
							Cookie cookie =new Cookie("list_cart_cookie",jsontoString);
							cookie.setMaxAge(60*60*24);
							response.addCookie(cookie);
						}
						flag=true;
						
					}
				}
				if(!flag){
					//cookie中没有购物车数据
					list_cart_cookie.add(cart);
					
					String jsontoString = Myutils.jsontoString(list_cart_cookie);
					//cookie中没有购物车数据
					Cookie cookie =new Cookie("list_cart_cookie",jsontoString);
					cookie.setMaxAge(60*60*24);
					response.addCookie(cookie);
				}
				/*for (Cookie cookie : cookies) {
					if(cookie.getName().equals("list_cart_cookie")){
						boolean b=is_new_cart(list_cart_cookie,cart);
						if(b){
							//该购物车是新的数据
							list_cart_cookie.add(cart);
							String jsontoString = Myutils.jsontoString(list_cart_cookie);
							//json需要进行编码
							Cookie cookie1 =new Cookie("list_cart_cookie",jsontoString);
							cookie1.setMaxAge(60*60*24);
							response.addCookie(cookie1);
						}else{
							//该购物车不是新的数据
							
							String json2 = gson.toJson(list_cart_cookie);
							Cookie cookie1 =new Cookie("list_cart_cookie",json2);
						}
					}else{
						//购物车中没有提交上来相关数据
						list_cart_cookie.add(cart);
						
						String jsontoString = Myutils.jsontoString(list_cart_cookie);
						//cookie中没有购物车数据
						Cookie cookie1 =new Cookie("list_cart_cookie",jsontoString);
						cookie.setMaxAge(60*60*24);
						response.addCookie(cookie1);
					}
			
				}*/
			}
			
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/toindex.html");
		return modelAndView;
	}
	private boolean is_new_cart(List<T_MALL_SHOPPINGCAR> list_cart_cookie, T_MALL_SHOPPINGCAR cart) {
		boolean flag=true;
		if(list_cart_cookie!=null){
		for (T_MALL_SHOPPINGCAR t_MALL_SHOPPINGCAR : list_cart_cookie) {
			if(t_MALL_SHOPPINGCAR.getSku_id()==cart.getSku_id()){
				flag=false;
			}
		}
		}
		return flag;
	}
	//获得购物车总数量数
	public int get_cart_count(List<T_MALL_SHOPPINGCAR> list_cart){
		int count=0;
		if(list_cart!=null){
			for (T_MALL_SHOPPINGCAR cart : list_cart) {
				if("1".equals(cart.getShfxz())){
					count+=cart.getTjshl();
				}
			}
			return count;
		}else{
			return 0;
		}
		
	}
	//获得购物车的总金额数
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
