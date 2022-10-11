package com.smartFarm.mes.vo.employee;

public class EmployeeVO {


	private String emp_id;
	private int emp_no;
	private String emp_name;
	private String emp_pw;
	private String emp_email;
	private String emp_admin;


	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_admin() {
		return emp_admin;
	}
	public void setEmp_admin(String emp_admin) {
		this.emp_admin = emp_admin;
	}


	@Override
	public String toString() {
		return "EmployeeVO [emp_id=" + emp_id + ", emp_no=" + emp_no + ", emp_name=" + emp_name + ", emp_pw=" + emp_pw
				+ ", emp_email=" + emp_email + ", emp_admin=" + emp_admin + "]";
	}




}
