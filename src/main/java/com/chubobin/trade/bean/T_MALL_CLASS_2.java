package com.chubobin.trade.bean;

public class T_MALL_CLASS_2 {
	
	public T_MALL_CLASS_2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public T_MALL_CLASS_2(int id, String flmch2, String flbh1) {
		super();
		Id = id;
		this.flmch2 = flmch2;
		this.flbh1 = flbh1;
	}
	@Override
	public String toString() {
		return "T_MALL_CLASS_2 [Id=" + Id + ", flmch2=" + flmch2 + ", flbh1=" + flbh1 + "]";
	}
	private int Id;
	private String flmch2,flbh1;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFlmch2() {
		return flmch2;
	}
	public void setFlmch2(String flmch2) {
		this.flmch2 = flmch2;
	}
	public String getFlbh1() {
		return flbh1;
	}
	public void setFlbh1(String flbh1) {
		this.flbh1 = flbh1;
	}
	

}
