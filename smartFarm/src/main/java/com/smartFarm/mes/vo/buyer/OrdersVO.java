package com.smartFarm.mes.vo.buyer;

import java.util.Date;

public class OrdersVO {
	
	private String orders_id;
	private String buyer_id;
	private String orders_product;
	private String orders_qty;
	private Date orders_date;
	private Date orders_arr_date;
	
	
	public String getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(String orders_id) {
		this.orders_id = orders_id;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getOrders_product() {
		return orders_product;
	}
	public void setOrders_product(String orders_product) {
		this.orders_product = orders_product;
	}
	public String getOrders_qty() {
		return orders_qty;
	}
	public void setOrders_qty(String orders_qty) {
		this.orders_qty = orders_qty;
	}
	public Date getOrders_date() {
		return orders_date;
	}
	public void setOrders_date(Date orders_date) {
		this.orders_date = orders_date;
	}
	public Date getOrders_arr_date() {
		return orders_arr_date;
	}
	public void setOrders_arr_date(Date orders_arr_date) {
		this.orders_arr_date = orders_arr_date;
	}
	@Override
	public String toString() {
		return "OrdersVO [orders_id=" + orders_id + ", buyer_id=" + buyer_id + ", orders_product=" + orders_product
				+ ", orders_qty=" + orders_qty + ", orders_date=" + orders_date + ", orders_arr_date=" + orders_arr_date
				+ "]";
	}

	
	
}
