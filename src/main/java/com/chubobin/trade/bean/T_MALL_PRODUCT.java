package com.chubobin.trade.bean;

public class T_MALL_PRODUCT {
	
	private int Id,flbh1,flbh2,pp_id;
	private String shp_mch,shp_tp,shp_msh,chjshj;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getFlbh1() {
		return flbh1;
	}
	public void setFlbh1(int flbh1) {
		this.flbh1 = flbh1;
	}
	public int getFlbh2() {
		return flbh2;
	}
	public void setFlbh2(int flbh2) {
		this.flbh2 = flbh2;
	}
	public int getPp_id() {
		return pp_id;
	}
	public void setPp_id(int pp_id) {
		this.pp_id = pp_id;
	}
	public String getShp_mch() {
		return shp_mch;
	}
	public void setShp_mch(String shp_mch) {
		this.shp_mch = shp_mch;
	}
	public String getShp_tp() {
		return shp_tp;
	}
	public void setShp_tp(String shp_tp) {
		this.shp_tp = shp_tp;
	}
	public String getShp_msh() {
		return shp_msh;
	}
	public void setShp_msh(String shp_msh) {
		this.shp_msh = shp_msh;
	}
	public String getChjshj() {
		return chjshj;
	}
	public void setChjshj(String chjshj) {
		this.chjshj = chjshj;
	}
	public T_MALL_PRODUCT(int id, int flbh1, int flbh2, int pp_id, String shp_mch, String shp_tp, String shp_msh,
			String chjshj) {
		super();
		Id = id;
		this.flbh1 = flbh1;
		this.flbh2 = flbh2;
		this.pp_id = pp_id;
		this.shp_mch = shp_mch;
		this.shp_tp = shp_tp;
		this.shp_msh = shp_msh;
		this.chjshj = chjshj;
	}
	public T_MALL_PRODUCT() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "T_MALL_PRODUCT [Id=" + Id + ", flbh1=" + flbh1 + ", flbh2=" + flbh2 + ", pp_id=" + pp_id + ", shp_mch="
				+ shp_mch + ", shp_tp=" + shp_tp + ", shp_msh=" + shp_msh + ", chjshj=" + chjshj + "]";
	}


}
