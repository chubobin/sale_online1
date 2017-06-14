package com.chubobin.trade.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chubobin.trade.bean.OBJECT_T_MALL_ATTR;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU_ATTR_VALUE;
import com.chubobin.trade.bean.T_MALL_SKU;
import com.chubobin.trade.service.SkuService;

@Controller
public class SkuController {
	
	@Autowired
	private SkuService skuService;
	//根据class_2_id 查询sku的信息
	@RequestMapping("/index_select_attr_sku/{class_2_id}/{flmch2}/{order}")
	public String index_select_attr_sku(@PathVariable("class_2_id")int class_2_id,@PathVariable("flmch2") String flmch2,@PathVariable("order") String order,Map map){
		//获取属性信息
		List<OBJECT_T_MALL_ATTR> listattr=skuService.index_select_attr_sku(class_2_id);
		
		List<OBJECT_T_MALL_SKU> skulist=skuService.get_sku_by_class_2_id_attr(class_2_id,null,order);
		
		map.put("listattr", listattr);
		map.put("skulist", skulist);
		return "sku_display";
	}
	//根据分类属性查询sku的信息
	@RequestMapping("/get_sku_by_class_2_id_attr/{class_2_id}/{order}")
	public String get_sku_by_class_2_id_attr(@PathVariable("class_2_id") int class_2_id,@PathVariable("order") String order,OBJECT_T_MALL_SKU_ATTR_VALUE attrlist,Map map){
		List<OBJECT_T_MALL_SKU> skulist=new ArrayList<>();
		skulist=skuService.get_sku_by_class_2_id_attr(class_2_id,attrlist,order);
		map.put("skulist", skulist);
		return "sku_display_inner";
	}
	//查询商品详情
	@RequestMapping("/display_sku_details/{sku_id}/{shp_id}")
	public String display_sku_details(@PathVariable("sku_id")int sku_id,@PathVariable("shp_id") int shp_id,Map map){
		OBJECT_T_MALL_SKU details=skuService.get_display_sku_details(sku_id);
		List<T_MALL_SKU> skulist=null;
		if(shp_id!=0){
		 skulist=skuService.get_sku_by_spu(shp_id);
		}
		map.put("details", details);
		map.put("skulist", skulist);
		return "sku_details";
	}
}