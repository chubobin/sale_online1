package com.chubobin.trade.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OBJECT_T_MALL_ORDER {
	
	private int id, jdh, yh_id, dzh_id;
	private String shhr,dzh_mch;
	private BigDecimal zje;
	private Date chjshj,yjsdshj;
	
	private List<T_MALL_ORDER_info> orderinfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJdh() {
		return jdh;
	}

	public void setJdh(int jdh) {
		this.jdh = jdh;
	}

	public int getYh_id() {
		return yh_id;
	}

	public void setYh_id(int yh_id) {
		this.yh_id = yh_id;
	}

	public int getDzh_id() {
		return dzh_id;
	}

	public void setDzh_id(int dzh_id) {
		this.dzh_id = dzh_id;
	}

	public String getShhr() {
		return shhr;
	}

	public void setShhr(String shhr) {
		this.shhr = shhr;
	}

	public String getDzh_mch() {
		return dzh_mch;
	}

	public void setDzh_mch(String dzh_mch) {
		this.dzh_mch = dzh_mch;
	}

	public BigDecimal getZje() {
		return zje;
	}

	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	public Date getYjsdshj() {
		return yjsdshj;
	}

	public void setYjsdshj(Date yjsdshj) {
		this.yjsdshj = yjsdshj;
	}

	public List<T_MALL_ORDER_info> getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(List<T_MALL_ORDER_info> orderinfo) {
		this.orderinfo = orderinfo;
	}
}
