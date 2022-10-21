package com.smartFarm.mes.vo.buyer;

public class BuyerVO {
	
	
	
	private String buyer_id;
	private String buyer_name;
	private String buyer_email;
	private String buyer_number;
	private String buyer_product;
	private String buyer_date;
	
	
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_email() {
		return buyer_email;
	}
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	public String getBuyer_number() {
		return buyer_number;
	}
	public void setBuyer_number(String buyer_number) {
		this.buyer_number = buyer_number;
	}
	public String getBuyer_product() {
		return buyer_product;
	}
	public void setBuyer_product(String buyer_product) {
		this.buyer_product = buyer_product;
	}
	public String getBuyer_date() {
		return buyer_date;
	}
	public void setBuyer_date(String buyer_date) {
		this.buyer_date = buyer_date;
	}
	@Override
	public String toString() {
		return "BuyerVO [buyer_id=" + buyer_id + ", buyer_name=" + buyer_name + ", buyer_email=" + buyer_email
				+ ", buyer_number=" + buyer_number + ", buyer_product=" + buyer_product + ", buyer_date=" + buyer_date
				+ "]";
	}

	
	
}
