package com.chubobin.trade.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubobin.trade.bean.OBJECT_T_MALL_ATTR;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU;
import com.chubobin.trade.bean.OBJECT_T_MALL_SKU_ATTR_VALUE;
import com.chubobin.trade.bean.T_MALL_SKU;
import com.chubobin.trade.bean.T_MALL_SKU_ATTR_VALUE;
import com.chubobin.trade.mapper.SkuMapper;

@Service
public class SkuServiceimpl implements SkuService {
	@Autowired
	private SkuMapper skuMapper;

	@Override
	public List<OBJECT_T_MALL_ATTR> index_select_attr_sku(int class_2_id) {
		List<OBJECT_T_MALL_ATTR> attr_value=skuMapper.select_attr_sku(class_2_id);
		return attr_value;
	}

	@Override
	public List<OBJECT_T_MALL_SKU> get_sku_by_class_2_id_attr(int class_2_id, OBJECT_T_MALL_SKU_ATTR_VALUE list,String order) {
		
		List<OBJECT_T_MALL_SKU> listsku=new ArrayList<>();
		if(list==null){
			 listsku=skuMapper.select_sku_by_class_2_id(class_2_id);
		}else{
			List<T_MALL_SKU_ATTR_VALUE> attrlist2 = list.getAttrlist();
			List<T_MALL_SKU_ATTR_VALUE> attrlist = new ArrayList<>();
			for (T_MALL_SKU_ATTR_VALUE attr : attrlist2) {
				if(attr.getShxm_id()!=0){
					attrlist.add(attr);
				}
			}
			
			StringBuffer sb=new StringBuffer();
			sb.append(" and sku.id in ");
			sb.append(" ( ");
			sb.append(" select sku_0.sku_id from ");
			for (int i = 0; i <attrlist.size(); i++) {
				sb.append(" ( select sku_id from t_mall_sku_attr_value where shxm_id="+attrlist.get(i).getShxm_id()+" and shxzh_id="+attrlist.get(i).getShxzh_id()+") sku_"+i+" ");
				if(i<(attrlist.size()-1)){
					sb.append(" , ");
				}
			}
			if(attrlist.size()>1){
				sb.append(" where ");
			}
			for (int i = 0; i < attrlist.size(); i++) {
				if(i<attrlist.size()-1){
					sb.append(" sku_"+i+".sku_id=sku_"+(i+1)+".sku_id ");
				}
				if(i<attrlist.size()-2){
					sb.append(" and ");
				}
			}
			sb.append(" ) ");
			Map<String,Object> parammMap=new HashMap<>();
			parammMap.put("class_2_id", class_2_id);
			parammMap.put("list", list);
			parammMap.put("sql",sb);
			parammMap.put("order", order);
			listsku=skuMapper.select_sku_by_class_2_id_attr(parammMap);
		}
		return listsku;
	}

	@Override
	public OBJECT_T_MALL_SKU get_display_sku_details(int sku_id) {
		OBJECT_T_MALL_SKU  sku=skuMapper.select_sku_by_sku_id(sku_id);
		return sku;
	}

	@Override
	public List<T_MALL_SKU> get_sku_by_spu(int shp_id) {
		List<T_MALL_SKU> skulist=skuMapper.select_sku_by_spu(shp_id);
		return skulist;
	}

	@Override
	public void to_text() {
		skuMapper.text();
		
		skuMapper=null;
		skuMapper.text();
		
	}
	
}
