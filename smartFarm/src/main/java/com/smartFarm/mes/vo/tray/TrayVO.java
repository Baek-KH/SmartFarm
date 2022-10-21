package com.smartFarm.mes.vo.tray;

import java.util.Date;

public class TrayVO {


	private String tray_id;
	private String line_id;
	private String pip_name;
	private String pip_qty;
	private String pip_period;
	private Date tray_start_date;
	private Date tray_end_date;




	public String getTray_id() {
		return tray_id;
	}
	public void setTray_id(String tray_id) {
		this.tray_id = tray_id;
	}
	public String getLine_id() {
		return line_id;
	}
	public void setLine_id(String line_id) {
		this.line_id = line_id;
	}
	public String getPip_name() {
		return pip_name;
	}
	public void setPip_name(String pip_name) {
		this.pip_name = pip_name;
	}
	public String getPip_qty() {
		return pip_qty;
	}
	public void setPip_qty(String pip_qty) {
		this.pip_qty = pip_qty;
	}
	public String getPip_period() {
		return pip_period;
	}
	public void setPip_period(String pip_period) {
		this.pip_period = pip_period;
	}
	public Date getTray_start_date() {
		return tray_start_date;
	}
	public void setTray_start_date(Date tray_start_date) {
		this.tray_start_date = tray_start_date;
	}
	public Date getTray_end_date() {
		return tray_end_date;
	}
	public void setTray_end_date(Date tray_end_date) {
		this.tray_end_date = tray_end_date;
	}


	@Override
	public String toString() {
		return "TrayVO [tray_id=" + tray_id + ", line_id=" + line_id + ", pip_name=" + pip_name + ", pip_qty=" + pip_qty
				+ ", pip_period=" + pip_period + ", tray_start_date=" + tray_start_date + ", tray_end_date="
				+ tray_end_date + "]";
	}













}
