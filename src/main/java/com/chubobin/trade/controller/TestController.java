package com.chubobin.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chubobin.trade.service.SkuService;

@Controller
public class TestController {
	@Autowired
	private SkuService skuservice;
	@RequestMapping("/to_text")
	public String to_text(){
		skuservice.to_text();
		return "";
	}
}
