package com.smartFarm.mes.vo.line;

import java.util.Date;

public class StatusVO {
	
	
	private String status_id;	
	private String status_line_id;	
	private String status_temp;	
	private String status_line_temp;	
	private String status_hum;	
	private String status_line_hum;	
	private Date status_time;
	
	
	
	public String getStatus_id() {
		return status_id;
	}
	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}
	public String getStatus_line_id() {
		return status_line_id;
	}
	public void setStatus_line_id(String status_line_id) {
		this.status_line_id = status_line_id;
	}
	public String getStatus_temp() {
		return status_temp;
	}
	public void setStatus_temp(String status_temp) {
		this.status_temp = status_temp;
	}
	public String getStatus_line_temp() {
		return status_line_temp;
	}
	public void setStatus_line_temp(String status_line_temp) {
		this.status_line_temp = status_line_temp;
	}
	public String getStatus_hum() {
		return status_hum;
	}
	public void setStatus_hum(String status_hum) {
		this.status_hum = status_hum;
	}
	public String getStatus_line_hum() {
		return status_line_hum;
	}
	public void setStatus_line_hum(String status_line_hum) {
		this.status_line_hum = status_line_hum;
	}
	public Date getStatus_time() {
		return status_time;
	}
	public void setStatus_time(Date status_time) {
		this.status_time = status_time;
	}
	
	@Override
	public String toString() {
		return "StatusVO [status_id=" + status_id + ", status_line_id=" + status_line_id + ", status_temp="
				+ status_temp + ", status_line_temp=" + status_line_temp + ", status_hum=" + status_hum
				+ ", status_line_hum=" + status_line_hum + ", status_time=" + status_time + "]";
	}
	
	
	
	

}
