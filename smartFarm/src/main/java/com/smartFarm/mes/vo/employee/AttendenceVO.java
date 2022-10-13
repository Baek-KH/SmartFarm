package com.smartFarm.mes.vo.employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AttendenceVO {

    private String emp_id;
    private String emp_name;
    private Date att_work_on;
    private Date att_work_off;
    private Date att_work_date;
    private String att_dayoff;


    @Override
    public String toString() {
        return "attendenceVO [emp_id=" + emp_id + ", user_name=" + emp_name + ", att_work_on=" + att_work_on
                + ", att_work_off=" + att_work_off + ", att_work_date=" + att_work_date + ", att_dayoff=" + att_dayoff
                + "]";
    }


    public String getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }
    public String getEmp_name() {
        return emp_name;
    }
    public void setEmp_name(String user_name) {
        this.emp_name = user_name;
    }
    public Date getAtt_work_on() {
        return att_work_on;
    }
    public void setAtt_work_on(Date att_work_on) {
        this.att_work_on = att_work_on;
    }
    public Date getAtt_work_off() {
        return att_work_off;
    }
    public void setAtt_work_off(Date att_work_off) {
        this.att_work_off = att_work_off;
    }
    public Date getAtt_work_date() {
        return att_work_date;
    }
    public String getAtt_work_date_str() {
    	
    	SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
    	String att_work_date_str = simple.format(att_work_date);

    	return att_work_date_str;
    }
    public void setAtt_work_date(Date att_work_date) {
        this.att_work_date = att_work_date;
    }
    public String getAtt_dayoff() {
        return att_dayoff;
    }
    public void setAtt_dayoff(String att_dayoff) {
        this.att_dayoff = att_dayoff;
    }



}
