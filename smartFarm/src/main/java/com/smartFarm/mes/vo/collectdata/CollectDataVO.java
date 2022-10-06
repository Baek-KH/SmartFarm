package com.smartFarm.mes.vo.collectdata;
public class CollectDataVO {

	private int test_no;

	public int getTest_no() {
		return this.test_no;
	}

	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}

	private String searchCondition;
	private String searchKeyword;

	private String title;
	private String writer;


	private int pro_qty;
	private int pro_price;
	
	private String pro_date;

	
	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getPro_date() {
		return this.pro_date;
	}

	public void setPro_date(String pro_date) {
		this.pro_date = pro_date;
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
