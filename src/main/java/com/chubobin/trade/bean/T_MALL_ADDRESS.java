package com.chubobin.trade.bean;

public class T_MALL_ADDRESS {
	private int id;
	private String yh_dz,dzzt,yh_id,shjr,lxfsh;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYh_dz() {
		return yh_dz;
	}
	public void setYh_dz(String yh_dz) {
		this.yh_dz = yh_dz;
	}
	public String getDzzt() {
		return dzzt;
	}
	public void setDzzt(String dzzt) {
		this.dzzt = dzzt;
	}
	public String getYh_id() {
		return yh_id;
	}
	public void setYh_id(String yh_id) {
		this.yh_id = yh_id;
	}
	public String getShjr() {
		return shjr;
	}
	public void setShjr(String shjr) {
		this.shjr = shjr;
	}
	public String getLxfsh() {
		return lxfsh;
	}
	public void setLxfsh(String lxfsh) {
		this.lxfsh = lxfsh;
	}
	@Override
	public String toString() {
		return "T_MALL_ADDRESS [id=" + id + ", yh_dz=" + yh_dz + ", dzzt=" + dzzt + ", yh_id=" + yh_id + ", shjr="
				+ shjr + ", lxfsh=" + lxfsh + "]";
	}

}
