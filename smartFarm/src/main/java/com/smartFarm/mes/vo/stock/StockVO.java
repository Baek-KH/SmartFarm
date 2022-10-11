package com.smartFarm.mes.vo.stock;

public class StockVO {

	private String stock_id;
	private String stock_category;
	private String stock_name;
	private int stock_qty;




	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getStock_category() {
		return stock_category;
	}
	public void setStock_category(String stock_category) {
		this.stock_category = stock_category;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public int getStock_qty() {
		return stock_qty;
	}
	public void setStock_qty(int stock_qty) {
		this.stock_qty = stock_qty;
	}



	@Override
	public String toString() {
		return "StockVO [stock_id=" + stock_id + ", stock_category=" + stock_category + ", stock_name=" + stock_name
				+ ", stock_qty=" + stock_qty + "]";
	}







}
