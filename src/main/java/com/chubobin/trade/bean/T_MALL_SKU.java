package com.chubobin.trade.bean;

public class T_MALL_SKU {
	
	private int Id,shp_id,kc,sku_xl;
	
	private String jg,chjshj,sku_mch,kcdz;

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

	public int getKc() {
		return kc;
	}

	public void setKc(int kc) {
		this.kc = kc;
	}

	public int getSku_xl() {
		return sku_xl;
	}

	public void setSku_xl(int sku_xl) {
		this.sku_xl = sku_xl;
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

	@Override
	public String toString() {
		return "T_MALL_SKU [Id=" + Id + ", shp_id=" + shp_id + ", kc=" + kc + ", sku_xl=" + sku_xl + ", jg=" + jg
				+ ", chjshj=" + chjshj + ", sku_mch=" + sku_mch + ", kcdz=" + kcdz + "]";
	}

	public T_MALL_SKU(int id, int shp_id, int kc, int sku_xl, String jg, String chjshj, String sku_mch, String kcdz) {
		super();
		Id = id;
		this.shp_id = shp_id;
		this.kc = kc;
		this.sku_xl = sku_xl;
		this.jg = jg;
		this.chjshj = chjshj;
		this.sku_mch = sku_mch;
		this.kcdz = kcdz;
	}

	public T_MALL_SKU() {
		super();
		// TODO Auto-generated constructor stub
	}

}
