package com.chubobin.trade.bean;

public class T_MALL_ATTR {
	private int Id,flbh2;
	private String shxm_mch,shfqy,chjshj;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getFlbh2() {
		return flbh2;
	}
	public void setFlbh2(int flbh2) {
		this.flbh2 = flbh2;
	}
	public String getShxm_mch() {
		return shxm_mch;
	}
	public void setShxm_mch(String shxm_mch) {
		this.shxm_mch = shxm_mch;
	}
	public String getShfqy() {
		return shfqy;
	}
	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}
	public String getChjshj() {
		return chjshj;
	}
	public void setChjshj(String chjshj) {
		this.chjshj = chjshj;
	}
	public T_MALL_ATTR(int id, int flbh2, String shxm_mch, String shfqy, String chjshj) {
		super();
		Id = id;
		this.flbh2 = flbh2;
		this.shxm_mch = shxm_mch;
		this.shfqy = shfqy;
		this.chjshj = chjshj;
	}
	public T_MALL_ATTR() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "T_MALL_ATTR [Id=" + Id + ", flbh2=" + flbh2 + ", shxm_mch=" + shxm_mch + ", shfqy=" + shfqy
				+ ", chjshj=" + chjshj + "]";
	}
	

}
