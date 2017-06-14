package com.chubobin.trade.bean;

import java.math.BigDecimal;
import java.util.Date;

public class T_MALL_ORDER_info {
	@Override
	public String toString() {
		return "T_MALL_ORDER_info [id=" + id + ", dd_id=" + dd_id + ", sku_id=" + sku_id + ", sku_shl=" + sku_shl
				+ ", gwch_id=" + gwch_id + ", sku_mch=" + sku_mch + ", shp_tp=" + shp_tp + ", sku_kcdz=" + sku_kcdz
				+ ", chjshj=" + chjshj + ", sku_jg=" + sku_jg + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDd_id() {
		return dd_id;
	}

	public void setDd_id(int dd_id) {
		this.dd_id = dd_id;
	}

	public int getSku_id() {
		return sku_id;
	}

	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}

	public int getSku_shl() {
		return sku_shl;
	}

	public void setSku_shl(int sku_shl) {
		this.sku_shl = sku_shl;
	}

	public int getGwch_id() {
		return gwch_id;
	}

	public void setGwch_id(int gwch_id) {
		this.gwch_id = gwch_id;
	}

	public String getSku_mch() {
		return sku_mch;
	}

	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}

	public String getShp_tp() {
		return shp_tp;
	}

	public void setShp_tp(String shp_tp) {
		this.shp_tp = shp_tp;
	}

	public String getSku_kcdz() {
		return sku_kcdz;
	}

	public void setSku_kcdz(String sku_kcdz) {
		this.sku_kcdz = sku_kcdz;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	public BigDecimal getSku_jg() {
		return sku_jg;
	}

	public void setSku_jg(BigDecimal sku_jg) {
		this.sku_jg = sku_jg;
	}

	private int id,dd_id,sku_id,sku_shl,gwch_id;
	private String sku_mch,shp_tp,sku_kcdz;
	
	private Date chjshj;

	private BigDecimal sku_jg;
}
