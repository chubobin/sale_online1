package com.chubobin.trade.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chubobin.trade.bean.T_MALL_SHOPPINGCAR;
import com.chubobin.trade.bean.T_MALL_USER;
import com.chubobin.trade.service.ShoppingCartService;
import com.chubobin.trade.service.UserService;
import com.chubobin.trade.util.Myutils;
import com.google.gson.Gson;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	@Autowired
	private ShoppingCartService shoppinCartService;
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "index";
	}
	//登录是将数据库和cookie的购物车合并
	@RequestMapping("/tologin")
	public String tologin(T_MALL_USER user,@CookieValue(value="list_cart_cookie",required=false) String list_cart_cookie_string,HttpSession session,HttpServletResponse response,HttpServletRequest request){
		T_MALL_USER loginuser=userService.login_user(user.getYh_mch(), user.getYh_mm());
		if(loginuser!=null){
			session.setAttribute("user", loginuser);
			List<T_MALL_SHOPPINGCAR> list=new ArrayList<>();
			//将cookie中的数据同步到数据库中并且删除cookie中的数据
			//并且将数据库中的数据同步到session中
			Cookie[] cookies = request.getCookies();
				
					//cookie中有购物车相关的数据
						List<T_MALL_SHOPPINGCAR> list_cart_db = shoppinCartService.get_shopping_cart_data();
						update_cookie_to_db(loginuser,session,response,list_cart_cookie_string,list_cart_db);
					
				
			
			//删除cookie中的数据
			response.addCookie(new Cookie("list_cart_cookie", null));
			String yh_nch = loginuser.getYh_nch();
			Gson gson=new Gson();
			String json = gson.toJson(yh_nch);
			String encode=null;
			try {
				encode = URLEncoder.encode(json, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cookie cookie1=new Cookie("test","test");
			Cookie cookie =new Cookie("lgoinuser",encode);
			cookie.setMaxAge(60*60);
			cookie1.setMaxAge(60*60);
			response.addCookie(cookie);
			response.addCookie(cookie1);
			return "index";
		}else{
			
			return "login";
		}
		
	}
	//合并cookie和数据库中的购物车的方法
	private void update_cookie_to_db(T_MALL_USER loginuser, HttpSession session, HttpServletResponse response,
			String list_cart_string,List<T_MALL_SHOPPINGCAR> list_cart_db) {
		if(list_cart_string==null||list_cart_string.equals("")){
			//cookie中没有购物车的数据
		}else{
			//cookie中含有购物车的数据
			List<T_MALL_SHOPPINGCAR> list_cart_cookie = Myutils.StringtoList(list_cart_string, new T_MALL_SHOPPINGCAR());
			
			if(list_cart_db==null||list_cart_db.size()==0){
				//数据库中没有数据
				for (T_MALL_SHOPPINGCAR shoppingcart : list_cart_cookie) {
					shoppingcart.setYh_id(loginuser.getId());
					shoppingcart.setHj(new BigDecimal(""+shoppingcart.getTjshl()).multiply(shoppingcart.getSku_jg()));
					shoppinCartService.save_cart_data(shoppingcart);
				}
				
			}else{
				//数据库中有相关的数据
				for (T_MALL_SHOPPINGCAR shopping : list_cart_cookie) {
					boolean b = is_new_cart(list_cart_db, shopping);
					
					if(b){
						//是一条新数据
						shopping.setYh_id(loginuser.getId());
						shopping.setHj(new BigDecimal(""+shopping.getTjshl()).multiply(shopping.getSku_jg()));
						shoppinCartService.save_cart_data(shopping);
					}else{
						//是一条老数据,
						
					}
				}
			}
			
		}
		list_cart_db = shoppinCartService.get_shopping_cart_data();
		session.setAttribute("list_cart_session", list_cart_db);
	}
	//该cart是否是集合中的老数据 
	private boolean is_new_cart(List<T_MALL_SHOPPINGCAR> list_cart_cookie, T_MALL_SHOPPINGCAR cart) {
		boolean flag=true;
		for (T_MALL_SHOPPINGCAR t_MALL_SHOPPINGCAR : list_cart_cookie) {
			if(t_MALL_SHOPPINGCAR.getSku_id()==cart.getSku_id()){
				flag=false;
			}
		}
		return flag;
	}
	
}
