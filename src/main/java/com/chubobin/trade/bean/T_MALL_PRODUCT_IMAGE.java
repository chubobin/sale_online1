package com.chubobin.trade.bean;

public class T_MALL_PRODUCT_IMAGE {
	
	private int Id,shp_id;
	private String zy,url;
	public int getId() {
		return Id;
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
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public T_MALL_PRODUCT_IMAGE(int id, int shp_id, String zy, String url) {
		super();
		Id = id;
		this.shp_id = shp_id;
		this.zy = zy;
		this.url = url;
	}
	public T_MALL_PRODUCT_IMAGE() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "T_MALL_PRODUCT_IMAGE [Id=" + Id + ", shp_id=" + shp_id + ", zy=" + zy + ", url=" + url + "]";
	}
	
}
