package com.chubobin.trade.bean;

public class T_MALL_VALUE {
	private int Id,shxm_id;
	private String shxzh,shfqy,shxzh_mch,chjshj;
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
	public String getShxzh() {
		return shxzh;
	}
	public void setShxzh(String shxzh) {
		this.shxzh = shxzh;
	}
	public String getShfqy() {
		return shfqy;
	}
	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}
	public String getShxzh_mch() {
		return shxzh_mch;
	}
	public void setShxzh_mch(String shxzh_mch) {
		this.shxzh_mch = shxzh_mch;
	}
	public String getChjshj() {
		return chjshj;
	}
	public void setChjshj(String chjshj) {
		this.chjshj = chjshj;
	}
	public T_MALL_VALUE(int id, int shxm_id, String shxzh, String shfqy, String shxzh_mch, String chjshj) {
		super();
		Id = id;
		this.shxm_id = shxm_id;
		this.shxzh = shxzh;
		this.shfqy = shfqy;
		this.shxzh_mch = shxzh_mch;
		this.chjshj = chjshj;
	}
	public T_MALL_VALUE() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "T_MALL_VALUE [Id=" + Id + ", shxm_id=" + shxm_id + ", shxzh=" + shxzh + ", shfqy=" + shfqy
				+ ", shxzh_mch=" + shxzh_mch + ", chjshj=" + chjshj + "]";
	}
	
}
