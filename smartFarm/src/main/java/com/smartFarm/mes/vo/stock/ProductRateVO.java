package com.smartFarm.mes.vo.stock;

public class ProductRateVO {
	
	private int stock_in_sum;
	private int stock_out_sum;
	private int stock_date;
	
	public int getStock_in_sum() {
		return stock_in_sum;
	}
	public void setStock_in_sum(int stock_in_sum) {
		this.stock_in_sum = stock_in_sum;
	}
	public int getStock_out_sum() {
		return stock_out_sum;
	}
	public void setStock_out_sum(int stock_out_sum) {
		this.stock_out_sum = stock_out_sum;
	}
	public int getStock_date() {
		return stock_date;
	}
	public void setStock_date(int stock_date) {
		this.stock_date = stock_date;
	}
	public double getStock_rate() {
	
		double stock_rate = (stock_in_sum / Double.valueOf(stock_out_sum))*100;
		System.out.println(stock_rate);
		
		return Math.round(stock_rate*10/10);
	}
	
	@Override
	public String toString() {
		return "ProductRateVO [stock_in_sum=" + stock_in_sum + ", stock_out_sum=" + stock_out_sum + ", stock_date="
				+ stock_date + "]";
	}
	
	
	
}
