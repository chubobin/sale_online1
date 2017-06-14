package com.chubobin.trade.bean;

import java.util.List;

public class OBJECT_T_MALL_SKU_ATTR_VALUE {
	
	private List<T_MALL_SKU_ATTR_VALUE> attrlist;

	public List<T_MALL_SKU_ATTR_VALUE> getAttrlist() {
		return attrlist;
	}

	public void setAttrlist(List<T_MALL_SKU_ATTR_VALUE> attrlist) {
		this.attrlist = attrlist;
	}
	@Override
	public String toString() {
		return "OBJECT_T_MALL_SKU_ATTR_VALUE [attrlist=" + attrlist + "]";
	}
	
}
