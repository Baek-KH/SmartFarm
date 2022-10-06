package com.smartFarm.mes.vo.line;

public class LineVO {
	
	
	
	private String line_id;
	private String line_temp;
	private String line_hum;
	private String line_status;
	


	@Override
	public String toString() {
		return "LineVO [line_id=" + line_id + ", line_temp=" + line_temp + ", line_hum=" + line_hum + ", line_status="
				+ line_status + "]";
	}
	
	
	public String getLine_id() {
		return line_id;
	}
	public void setLine_id(String line_id) {
		this.line_id = line_id;
	}
	public String getLine_temp() {
		return line_temp;
	}
	public void setLine_temp(String line_temp) {
		this.line_temp = line_temp;
	}
	public String getLine_hum() {
		return line_hum;
	}
	public void setLine_hum(String line_hum) {
		this.line_hum = line_hum;
	}
	public String getLine_status() {
		return line_status;
	}
	public void setLine_status(String line_status) {
		this.line_status = line_status;
	}
	
	
	
	
	
}
