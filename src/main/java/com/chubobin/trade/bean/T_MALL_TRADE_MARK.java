package com.chubobin.trade.bean;

public class T_MALL_TRADE_MARK {
	
	private int Id;
	private String ppmch,url;
	public T_MALL_TRADE_MARK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public T_MALL_TRADE_MARK(int id, String ppmch, String url) {
		super();
		Id = id;
		this.ppmch = ppmch;
		this.url = url;
	}
	@Override
	public String toString() {
		return "T_MALL_TRADE_MARK [Id=" + Id + ", ppmch=" + ppmch + ", url=" + url + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPpmch() {
		return ppmch;
	}
	public void setPpmch(String ppmch) {
		this.ppmch = ppmch;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
