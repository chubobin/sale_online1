package com.chubobin.trade.bean;

public class T_MALL_SKU_ATTR_VALUE {
	
	private int Id,shxm_id,shxzh_id,shp_id,sku_id;
	
	private String is_sku,chjshj;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getShxm_id() {
		return shxm_id;
	}

	public void setShxm_id(int shxm_id) {
		this.shxm_id = shxm_id;
	}

	public int getShxzh_id() {
		return shxzh_id;
	}

	public void setShxzh_id(int shxzh_id) {
		this.shxzh_id = shxzh_id;
	}

	public int getShp_id() {
		return shp_id;
	}

	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}

	public int getSku_id() {
		return sku_id;
	}

	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}

	public String getIs_sku() {
		return is_sku;
	}

	public void setIs_sku(String is_sku) {
		this.is_sku = is_sku;
	}

	public String getChjshj() {
		return chjshj;
	}

	public void setChjshj(String chjshj) {
		this.chjshj = chjshj;
	}

	@Override
	public String toString() {
		return "T_MALL_SKU_ATTR_VALUE [Id=" + Id + ", shxm_id=" + shxm_id + ", shxzh_id=" + shxzh_id + ", shp_id="
				+ shp_id + ", sku_id=" + sku_id + ", is_sku=" + is_sku + ", chjshj=" + chjshj + "]";
	}

	public T_MALL_SKU_ATTR_VALUE(int id, int shxm_id, int shxzh_id, int shp_id, int sku_id, String is_sku,
			String chjshj) {
		super();
		Id = id;
		this.shxm_id = shxm_id;
		this.shxzh_id = shxzh_id;
		this.shp_id = shp_id;
		this.sku_id = sku_id;
		this.is_sku = is_sku;
		this.chjshj = chjshj;
	}

	public T_MALL_SKU_ATTR_VALUE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
