package com.chubobin.trade.bean;

import java.util.List;

public class OBJECT_T_MALL_SKU {
	

	private int Id,shp_id,kc;
	
	private String jg,chjshj,sku_mch,kcdz;

	private T_MALL_PRODUCT product;
	
	private T_MALL_TRADE_MARK tm;
	
	private List<T_MALL_PRODUCT_IMAGE> list_image;
	
	private List<OBJECT_ATTR_VALUE> list_attr_value;
	public List<T_MALL_PRODUCT_IMAGE> getList_image() {
		return list_image;
	}

	public void setList_image(List<T_MALL_PRODUCT_IMAGE> list_image) {
		this.list_image = list_image;
	}


	public List<OBJECT_ATTR_VALUE> getList_attr_value() {
		return list_attr_value;
	}

	public void setList_attr_value(List<OBJECT_ATTR_VALUE> list_attr_value) {
		this.list_attr_value = list_attr_value;
	}

	public int getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "OBJECT_T_MALL_SKU [Id=" + Id + ", shp_id=" + shp_id + ", kc=" + kc + ", jg=" + jg + ", chjshj=" + chjshj
				+ ", sku_mch=" + sku_mch + ", kcdz=" + kcdz + ", product=" + product + ", tm=" + tm + "]";
	}

	public void setId(int id) {
		Id = id;
	}

	public int getShp_id() {
		return shp_id;
	}

	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}

	public int getKc() {
		return kc;
	}

	public void setKc(int kc) {
		this.kc = kc;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public String getChjshj() {
		return chjshj;
	}

	public void setChjshj(String chjshj) {
		this.chjshj = chjshj;
	}

	public String getSku_mch() {
		return sku_mch;
	}

	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}

	public String getKcdz() {
		return kcdz;
	}

	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}

	public T_MALL_PRODUCT getProduct() {
		return product;
	}

	public void setProduct(T_MALL_PRODUCT product) {
		this.product = product;
	}

	public T_MALL_TRADE_MARK getTm() {
		return tm;
	}

	public void setTm(T_MALL_TRADE_MARK tm) {
		this.tm = tm;
	}
}
