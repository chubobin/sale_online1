package com.chubobin.trade.bean;

public class T_MALL_CLASS_1 {
	private int Id ;
	private String flmch1;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFlmch1() {
		return flmch1;
	}
	public void setFlmch1(String flmch1) {
		this.flmch1 = flmch1;
	}
	@Override
	public String toString() {
		return "T_MALL_CLASS_1 [Id=" + Id + ", flmch1=" + flmch1 + "]";
	}
	public T_MALL_CLASS_1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public T_MALL_CLASS_1(int id, String flmch1) {
		super();
		Id = id;
		this.flmch1 = flmch1;
	}

}
