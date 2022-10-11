package com.smartFarm.mes.vo.stock;

import java.util.Date;

public class StockHistoryVO {

	private String stock_id;
	private String stock_name;
	private int Stock_in;
	private int Stock_out;
	private int Stock_qty;
	private Date stock_date;
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public int getStock_in() {
		return Stock_in;
	}
	public void setStock_in(int stock_in) {
		Stock_in = stock_in;
	}
	public int getStock_out() {
		return Stock_out;
	}
	public void setStock_out(int stock_out) {
		Stock_out = stock_out;
	}
	public int getStock_qty() {
		return Stock_qty;
	}
	public void setStock_qty(int stock_qty) {
		Stock_qty = stock_qty;
	}
	public Date getStock_date() {
		return stock_date;
	}
	public void setStock_date(Date stock_date) {
		this.stock_date = stock_date;
	}
	@Override
	public String toString() {
		return "StockHistoryVO [stock_id=" + stock_id + ", stock_name=" + stock_name + ", Stock_in=" + Stock_in
				+ ", Stock_out=" + Stock_out + ", Stock_qty=" + Stock_qty + ", stock_date=" + stock_date + "]";
	}


}
