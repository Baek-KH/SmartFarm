package com.smartFarm.mes.vo.process;

import java.sql.Date;

public class PipVO {
	
	private int pip_no;				//작물번호
	private String pip_name;		//작물이름
	private String pip_category;	//작물종류
	private Date pip_period;		//생육기간
	private String pip_min_temp;	//최저온도
	private String pip_max_temp;	//최고온도
	private String pip_min_hum;		//최저습도
	private String pip_max_hum;		//최고온도
	
	public int getPip_no() {
		return pip_no;
	}

	public void setPip_no(int pip_no) {
		this.pip_no = pip_no;
	}
	
	public String getPip_name() {
		return pip_name;
	}
	
	public void setPip_name(String pip_name) {
		this.pip_name = pip_name;
	}
	
	public String getPip_category() {
		return pip_category;
	}
	
	public void setPip_category(String pip_category) {
		this.pip_category = pip_category;
	}
	
	public Date getPip_period() {
		return pip_period;
	}
	
	public void setPip_period(Date pip_period) {
		this.pip_period = pip_period;
	}
	
	public String getPip_min_temp() {
		return pip_min_temp;
	}
	
	public void setPip_min_temp(String pip_min_temp) {
		this.pip_min_temp = pip_min_temp;
	}
	
	public String getPip_max_temp() {
		return pip_max_temp;
	}
	
	public void setPip_max_temp(String pip_max_temp) {
		this.pip_max_temp = pip_max_temp;
	}
	
	public String getPip_min_hum() {
		return pip_min_hum;
	}
	
	public void setPip_min_hum(String pip_min_hum) {
		this.pip_min_hum = pip_min_hum;
	}
	
	public String getPip_max_hum() {
		return pip_max_hum;
	}
	
	public void setPip_max_hum(String pip_max_hum) {
		this.pip_max_hum = pip_max_hum;
	}

	@Override
	public String toString() {
		return "pipVO [pip_no=" + pip_no + ", pip_name=" + pip_name + ", pip_category=" + pip_category + ", pip_period="
				+ pip_period + ", pip_min_temp=" + pip_min_temp + ", pip_max_temp=" + pip_max_temp + ", pip_min_hum="
				+ pip_min_hum + ", pip_max_hum=" + pip_max_hum + "]";
	}


	
	
	
}