package com.smartFarm.mes.vo.python;

import java.util.Date;

public class PredictionVO {
	
	private Date pre_date;
	private int pre_col;
	

	@Override
	public String toString() {
		return "Prediction [pre_date=" + pre_date + ", pre_col=" + pre_col + "]";
	}
	
	public Date getPre_date() {
		return pre_date;
	}
	public void setPre_date(Date pre_date) {
		this.pre_date = pre_date;
	}
	public int getPre_col() {
		return pre_col;
	}
	public void setPre_col(int pre_col) {
		this.pre_col = pre_col;
	}
	
	
	
}
