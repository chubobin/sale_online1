package com.chubobin.trade.bean;

public class T_MALL_USER {
	
	private int id;
	private String yh_mch,yh_nch,yh_mm,yh_xm,yh_shjh,yh_yx,yh_tx,yh_jb;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYh_mch() {
		return yh_mch;
	}
	public void setYh_mch(String yh_mch) {
		this.yh_mch = yh_mch;
	}
	public String getYh_nch() {
		return yh_nch;
	}
	public void setYh_nch(String yh_nch) {
		this.yh_nch = yh_nch;
	}
	public String getYh_mm() {
		return yh_mm;
	}
	public void setYh_mm(String yh_mm) {
		this.yh_mm = yh_mm;
	}
	public String getYh_xm() {
		return yh_xm;
	}
	public void setYh_xm(String yh_xm) {
		this.yh_xm = yh_xm;
	}
	public String getYh_shjh() {
		return yh_shjh;
	}
	public void setYh_shjh(String yh_shjh) {
		this.yh_shjh = yh_shjh;
	}
	public String getYh_yx() {
		return yh_yx;
	}
	public void setYh_yx(String yh_yx) {
		this.yh_yx = yh_yx;
	}
	public String getYh_tx() {
		return yh_tx;
	}
	public void setYh_tx(String yh_tx) {
		this.yh_tx = yh_tx;
	}
	public String getYh_jb() {
		return yh_jb;
	}
	public void setYh_jb(String yh_jb) {
		this.yh_jb = yh_jb;
	}
	public T_MALL_USER() {
		super();
		// TODO Auto-generated constructor stub
	}
	public T_MALL_USER(int id, String yh_mch, String yh_nch, String yh_mm, String yh_xm, String yh_shjh, String yh_yx,
			String yh_tx, String yh_jb) {
		super();
		this.id = id;
		this.yh_mch = yh_mch;
		this.yh_nch = yh_nch;
		this.yh_mm = yh_mm;
		this.yh_xm = yh_xm;
		this.yh_shjh = yh_shjh;
		this.yh_yx = yh_yx;
		this.yh_tx = yh_tx;
		this.yh_jb = yh_jb;
	}
	@Override
	public String toString() {
		return "T_MALL_USER [id=" + id + ", yh_mch=" + yh_mch + ", yh_nch=" + yh_nch + ", yh_mm=" + yh_mm + ", yh_xm="
				+ yh_xm + ", yh_shjh=" + yh_shjh + ", yh_yx=" + yh_yx + ", yh_tx=" + yh_tx + ", yh_jb=" + yh_jb + "]";
	}

}
