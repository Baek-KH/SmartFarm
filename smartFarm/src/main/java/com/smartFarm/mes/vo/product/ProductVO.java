package com.smartFarm.mes.vo.product;
public class ProductVO {

	private String searchCondition;
	private String searchKeyword;


	private int pro_no;
	private String pro_id;
	private String pip_name;
	private int pro_qty;
	private int pro_price;
	private String pro_content;
	private String pro_date;

	public String getPro_date() {
		return this.pro_date;
	}

	public void setPro_date(String pro_date) {
		this.pro_date = pro_date;
	}

	public int getPro_no() {
		return this.pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public String getPro_id() {
		return this.pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getPip_name() {
		return this.pip_name;
	}

	public void setPip_name(String pip_name) {
		this.pip_name = pip_name;
	}

	public int getPro_qty() {
		return this.pro_qty;
	}

	public void setPro_qty(int pro_qty) {
		this.pro_qty = pro_qty;
	}

	public int getPro_price() {
		return this.pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public String getPro_content() {
		return this.pro_content;
	}

	public void setPro_content(String pro_content) {
		this.pro_content = pro_content;
	}



	
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}


	
	
	
}
