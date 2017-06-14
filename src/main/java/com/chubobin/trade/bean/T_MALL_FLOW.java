package com.chubobin.trade.bean;

import java.util.Date;

public class T_MALL_FLOW {
	
	private int id,yh_id,dd_id;
	private String psfsh,psmsh,mqdd,mdd,ywy,lxfsh;
	private Date psshj,chjshj;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYh_id() {
		return yh_id;
	}
	public void setYh_id(int yh_id) {
		this.yh_id = yh_id;
	}
	public int getDd_id() {
		return dd_id;
	}
	public void setDd_id(int dd_id) {
		this.dd_id = dd_id;
	}
	public String getPsfsh() {
		return psfsh;
	}
	public void setPsfsh(String psfsh) {
		this.psfsh = psfsh;
	}
	public String getPsmsh() {
		return psmsh;
	}
	public void setPsmsh(String psmsh) {
		this.psmsh = psmsh;
	}
	public String getMqdd() {
		return mqdd;
	}
	public void setMqdd(String mqdd) {
		this.mqdd = mqdd;
	}
	public String getMdd() {
		return mdd;
	}
	public void setMdd(String mdd) {
		this.mdd = mdd;
	}
	public String getYwy() {
		return ywy;
	}
	public void setYwy(String ywy) {
		this.ywy = ywy;
	}
	public String getLxfsh() {
		return lxfsh;
	}
	public void setLxfsh(String lxfsh) {
		this.lxfsh = lxfsh;
	}
	public Date getPsshj() {
		return psshj;
	}
	public void setPsshj(Date psshj) {
		this.psshj = psshj;
	}
	public Date getChjshj() {
		return chjshj;
	}
	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}
	@Override
	public String toString() {
		return "T_MALL_FLOW [id=" + id + ", yh_id=" + yh_id + ", dd_id=" + dd_id + ", psfsh=" + psfsh + ", psmsh="
				+ psmsh + ", mqdd=" + mqdd + ", mdd=" + mdd + ", ywy=" + ywy + ", lxfsh=" + lxfsh + ", psshj=" + psshj
				+ ", chjshj=" + chjshj + "]";
	}

}
