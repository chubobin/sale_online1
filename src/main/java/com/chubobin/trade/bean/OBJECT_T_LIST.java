package com.chubobin.trade.bean;

import java.util.ArrayList;
import java.util.List;

public class OBJECT_T_LIST {
	
	private List<OBJECT_T_MALL_ATTR> listattr=new ArrayList<>();

	public List<OBJECT_T_MALL_ATTR> getListattr() {
		return listattr;
	}

	public void setListattr(List<OBJECT_T_MALL_ATTR> listattr) {
		this.listattr = listattr;
	}

	@Override
	public String toString() {
		return "OBJECT_T_LIST [listattr=" + listattr + "]";
	}
	
}
