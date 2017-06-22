package com.chubobin.trade.controller;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chubobin.trade.bean.OBJECT_T_MALL_ATTR;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU_ATTR_VALUE;
import com.chubobin.trade.bean.T_MALL_SKU;
import com.chubobin.trade.bean.T_MALL_SKU_ATTR_VALUE;
import com.chubobin.trade.service.SkuService;
import com.chubobin.trade.util.MyJedisTool;
import com.chubobin.trade.util.Myutils;

import redis.clients.jedis.Jedis;

@Controller
public class SkuController {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(SkuController.class);
	
	
	@Autowired
	private SkuService skuService;
	//根据class_2_id 查询sku的信息
	@RequestMapping("/index_select_attr_sku/{class_2_id}/{flmch2}/{order}")
	public String index_select_attr_sku(@PathVariable("class_2_id")int class_2_id,@PathVariable("flmch2") String flmch2,@PathVariable("order") String order,Map map){
		//获取属性信息
		List<OBJECT_T_MALL_ATTR> listattr=skuService.index_select_attr_sku(class_2_id);
		List<OBJECT_T_MALL_SKU> list_sku_redis=new ArrayList<>();
		Jedis get_Jedis = MyJedisTool.get_Jedis();
		String key="class_2_id_"+class_2_id;
		Set<String> zrange = get_Jedis.zrange(key,0,-1);
		if(zrange!=null||zrange.size()>0){
			Iterator<String> iterator = zrange.iterator();
			while(iterator.hasNext()){
				String next = iterator.next();
				OBJECT_T_MALL_SKU single_object = Myutils.String_to_single_object(next, OBJECT_T_MALL_SKU.class);
				list_sku_redis.add(single_object);
				
			}
		}else{
			 list_sku_redis=skuService.get_sku_by_class_2_id_attr(class_2_id,null,order);
			 //同步reids
		}
		map.put("listattr", listattr);
		map.put("skulist", list_sku_redis);
		return "sku_display";
	}
	//根据分类属性查询sku的信息
	@RequestMapping("/get_sku_by_class_2_id_attr/{class_2_id}/{order}")
	public String get_sku_by_class_2_id_attr(@PathVariable("class_2_id") int class_2_id,@PathVariable("order") String order,OBJECT_T_MALL_SKU_ATTR_VALUE attrlist,Map map){
		List<OBJECT_T_MALL_SKU> skulist=new ArrayList<>();
		List<T_MALL_SKU_ATTR_VALUE> attr_value_list=attrlist.getAttrlist();
		Jedis jedis = MyJedisTool.get_Jedis();
		String[] keys=new String[attr_value_list.size()];
		String key_merge="z_inter";
		for (int i = 0; i < attr_value_list.size(); i++) {
			String key="class_2_id_"+class_2_id+"_attr_value_"+attr_value_list.get(i).getShxm_id()+"_"+attr_value_list.get(i).getShxzh_id();
			key_merge+=key;
			keys[i]=key;
		}
		//交叉检索生成新key-value
		jedis.zinterstore(key_merge, keys);
		Set<String> zrange = jedis.zrange(key_merge,0,-1);
		if(zrange!=null&&zrange.size()>0){
			Iterator<String> iterator = zrange.iterator();
			while(iterator.hasNext()){
				String next = iterator.next();
				OBJECT_T_MALL_SKU string_to_single_object = Myutils.String_to_single_object(next, OBJECT_T_MALL_SKU.class);
				skulist.add(string_to_single_object);	
			}
		}else{
		skulist=skuService.get_sku_by_class_2_id_attr(class_2_id,attrlist,order);
		//同步redis
		}
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
		 logger.debug("----ingorf");
		}
		map.put("details", details);
		map.put("skulist", skulist);
		
		return "sku_details";
	}
}

