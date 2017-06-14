package com.chubobin.trade.bean;

import java.math.BigDecimal;

public class T_MALL_SHOPPINGCAR {
	
	private int id,tjshl,yh_id,sku_id,shp_id;
	private String sku_mch,chjshj,shp_tp,shfxz,kcdz;
	private BigDecimal sku_jg,hj;
	@Override
	public String toString() {
		return "T_MALL_SHOPPINGCAR [id=" + id + ", tjshl=" + tjshl + ", yh_id=" + yh_id + ", sku_id=" + sku_id
				+ ", shp_id=" + shp_id + ", sku_mch=" + sku_mch + ", chjshj=" + chjshj + ", shp_tp=" + shp_tp
				+ ", shfxz=" + shfxz + ", kcdz=" + kcdz + ", sku_jg=" + sku_jg + ", hj=" + hj + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTjshl() {
		return tjshl;
	}
	public void setTjshl(int tjshl) {
		this.tjshl = tjshl;
	}
	public int getYh_id() {
		return yh_id;
	}
	public void setYh_id(int yh_id) {
		this.yh_id = yh_id;
	}
	public int getSku_id() {
		return sku_id;
	}
	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}
	public int getShp_id() {
		return shp_id;
	}
	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}
	public String getSku_mch() {
		return sku_mch;
	}
	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}
	public String getChjshj() {
		return chjshj;
	}
	public void setChjshj(String chjshj) {
		this.chjshj = chjshj;
	}
	public String getShp_tp() {
		return shp_tp;
	}
	public void setShp_tp(String shp_tp) {
		this.shp_tp = shp_tp;
	}
	public String getShfxz() {
		return shfxz;
	}
	public void setShfxz(String shfxz) {
		this.shfxz = shfxz;
	}
	public String getKcdz() {
		return kcdz;
	}
	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}
	public BigDecimal getSku_jg() {
		return sku_jg;
	}
	public void setSku_jg(BigDecimal sku_jg) {
		this.sku_jg = sku_jg;
	}
	public BigDecimal getHj() {
		return hj;
	}
	public void setHj(BigDecimal hj) {
		this.hj = hj;
	}	
	

}
