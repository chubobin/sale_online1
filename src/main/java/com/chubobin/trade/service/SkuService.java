package com.chubobin.trade.service;

import java.util.List;

import com.chubobin.trade.bean.OBJECT_T_MALL_ATTR;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU_ATTR_VALUE;
import com.chubobin.trade.bean.T_MALL_SKU;

public interface SkuService {

	List<OBJECT_T_MALL_ATTR> index_select_attr_sku(int class_2_id);

	List<OBJECT_T_MALL_SKU> get_sku_by_class_2_id_attr(int class_2_id, OBJECT_T_MALL_SKU_ATTR_VALUE list, String order);

	OBJECT_T_MALL_SKU get_display_sku_details(int sku_id);

	List<T_MALL_SKU> get_sku_by_spu(int shp_id);

	void to_text();

}
