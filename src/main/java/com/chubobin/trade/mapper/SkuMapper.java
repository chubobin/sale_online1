package com.chubobin.trade.mapper;

import java.util.List;
import java.util.Map;

import com.chubobin.trade.bean.OBJECT_T_MALL_ATTR;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU;
import com.chubobin.trade.bean.T_MALL_SKU;

public interface SkuMapper {

	List<OBJECT_T_MALL_ATTR> select_attr_sku(int class_2_id);

	List<OBJECT_T_MALL_SKU> select_sku_by_class_2_id_attr(Map<String,Object> parammap);

	List<OBJECT_T_MALL_SKU> select_sku_by_class_2_id(int class_2_id);

	OBJECT_T_MALL_SKU select_sku_by_sku_id(int sku_id);


	List<T_MALL_SKU> select_sku_by_spu(int shp_id2);

	void text();

}
