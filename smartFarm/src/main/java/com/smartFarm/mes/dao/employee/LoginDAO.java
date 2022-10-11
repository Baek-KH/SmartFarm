package com.smartFarm.mes.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.employee.EmployeeVO;

@Repository("LoginDAO")
public class LoginDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;


	private final String EMPLOYEE_LOGIN ="select * from employee where emp_id =?";


	// 1. loginCheck
		public void loginEmployee(EmployeeVO vo) {

			System.out.println("==> JDBC Employee login");

			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(EMPLOYEE_LOGIN);
				stmt.setString(1,vo.getEmp_id());
				rs = stmt.executeQuery();
				if(rs.next()) {
					vo.setEmp_no(rs.getInt("emp_no")+1);
				} else {
					vo.setEmp_no(1);
				}
//				stmt = conn.prepareStatement(EMPLOYEE_INSERT);
				stmt.setString(1, vo.getEmp_id());
				stmt.setInt(2, vo.getEmp_no());
				stmt.setString(3, vo.getEmp_name());
				stmt.setString(4, vo.getEmp_pw());
				stmt.setString(5, vo.getEmp_email());
				stmt.setString(6, "regular");
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(null, stmt, conn);
			}
		}



}
