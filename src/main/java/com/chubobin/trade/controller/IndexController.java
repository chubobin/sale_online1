package com.chubobin.trade.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/toindex")
	public String toindex(HttpServletRequest request,Map map){
		/*Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lgoinuser")){
					map.put("yy_nch", cookie.getValue());
				}
			}
		}*/
		//这就是测试远端的代码
		//123123123123123
		return "index";
	}
}
