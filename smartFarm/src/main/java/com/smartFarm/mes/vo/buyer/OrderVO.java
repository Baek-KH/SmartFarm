package com.smartFarm.mes.vo.buyer;

import java.util.Date;

public class OrderVO {
	
	private String order_id;
	private String buyer_id;
	private String order_product;
	private String order_qty;
	private Date order_date;
	private Date order_arr_date;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getOrder_product() {
		return order_product;
	}
	public void setOrder_product(String order_product) {
		this.order_product = order_product;
	}
	public String getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(String order_qty) {
		this.order_qty = order_qty;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Date getOrder_arr_date() {
		return order_arr_date;
	}
	public void setOrder_arr_date(Date order_arr_date) {
		this.order_arr_date = order_arr_date;
	}
	@Override
	public String toString() {
		return "OrderVO [order_id=" + order_id + ", buyer_id=" + buyer_id + ", order_product=" + order_product
				+ ", order_qty=" + order_qty + ", order_date=" + order_date + ", order_arr_date=" + order_arr_date
				+ "]";
	}

	
	
}
