package com.smartFarm.mes.vo.forward;

import java.util.Date;

public class ForwardVO {



	private String forward_id;
	private String pip_name;
	private String forward_qty;
	private String forward_content;
	private Date forward_date;
	private String forward_check;
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "ForwardVO [forward_id=" + forward_id + ", pip_name=" + pip_name + ", forward_qty=" + forward_qty
				+ ", forward_content=" + forward_content + ", forward_date=" + forward_date + ", forward_check="
				+ forward_check + "]";
	}
	public String getForward_id() {
		return forward_id;
	}
	public void setForward_id(String forward_id) {
		this.forward_id = forward_id;
	}
	public String getPip_name() {
		return pip_name;
	}
	public void setPip_name(String pip_name) {
		this.pip_name = pip_name;
	}
	public String getForward_qty() {
		return forward_qty;
	}
	public void setForward_qty(String forward_qty) {
		this.forward_qty = forward_qty;
	}
	public String getForward_content() {
		return forward_content;
	}
	public void setForward_content(String forward_content) {
		this.forward_content = forward_content;
	}
	public Date getForward_date() {
		return forward_date;
	}
	public void setForward_date(Date forward_date) {
		this.forward_date = forward_date;
	}
	public String getForward_check() {
		return forward_check;
	}
	public void setForward_check(String forward_check) {
		this.forward_check = forward_check;
	}

	

	




}
