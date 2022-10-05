package com.smartFarm.mes.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.employee.EmployeeVO;

@Repository("EmployeeDAO")
public class EmployeeDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	
	private final String EMPLOYEE_INSERT ="insert into Employee (emp_id, emp_no , emp_name, emp_pw, emp_email, emp_admin) values (?,?,?,?,?,?)";
	private final String EMPLOYEE_UPDATE ="update Employee set emp_name=?, emp_email=?, emp_admin=? where emp_id = ?";
	private final String EMPLOYEE_DELETE ="delete from Employee where emp_id=?";
	private final String EMPLOYEE_GET ="select * from Employee where emp_id=?";
	private final String EMPLOYEE_LIST ="select * from Employee order by emp_no desc";
	private final String EMPLOYEE_LIST_I ="select * from Employee where emp_id like ? ";
	private final String EMPLOYEE_LIST_N ="select * from Employee where emp_name like ? ";
	
//	private final String EMPLOYEE_LIST_T ="select * from Employee where title like ? order by seq desc";
//	private final String EMPLOYEE_LIST_C ="select * from Employee where content like ? order by seq desc";

	
	// 1. insert
	public void insertEmployee(EmployeeVO vo) {
		
		System.out.println("==> JDBC Employee insert");
		String getEmp_NO = "select emp_no from Employee ORDER BY emp_no DESC LIMIT 1";
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getEmp_NO);
			rs = stmt.executeQuery();	
			if(rs.next()) {
				vo.setEmp_no(rs.getInt("emp_no")+1);
			} else {
				vo.setEmp_no(1);
			}
			stmt = conn.prepareStatement(EMPLOYEE_INSERT);
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
	
	// 2. getEmployee
	public EmployeeVO getEmployee(String emp_id) {
		
		System.out.println("==> JDBC getEmployee");
		EmployeeVO employee = new EmployeeVO();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EMPLOYEE_GET);
			stmt.setString(1, emp_id);
			rs = stmt.executeQuery();	
			while(rs.next()) {
				employee.setEmp_id(rs.getString("emp_id"));
				employee.setEmp_no(rs.getInt("emp_no"));
				employee.setEmp_name(rs.getString("emp_name"));
				employee.setEmp_email(rs.getString("emp_email"));
				employee.setEmp_admin(rs.getString("emp_admin"));
				employee.setEmp_pw(rs.getString("emp_pw"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
		return employee;	
		
	}
	
	// 3. update
		public void updateEmployee(EmployeeVO vo) {
			
			System.out.println("==> JDBC Employee update");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(EMPLOYEE_UPDATE);
				stmt.setString(1, vo.getEmp_name());
				stmt.setString(2, vo.getEmp_email());
				stmt.setString(3, vo.getEmp_admin());
				stmt.setString(4, vo.getEmp_id());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(null, stmt, conn);
			}		
		}
	
	
	
	
	// 4. delete 
	public void deleteEmployee(EmployeeVO vo) {

		System.out.println("==> JDBC Employee delete");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EMPLOYEE_DELETE);
			stmt.setString(1, vo.getEmp_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}		
	}

	// Employee List 출력
	public List<EmployeeVO> getEmployeeList() {
		System.out.println("==> JDBC getEmployeeList");
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EMPLOYEE_LIST);
			rs = stmt.executeQuery();	
			while(rs.next()) {
				EmployeeVO employee = new EmployeeVO();
				employee.setEmp_id(rs.getString("emp_id"));
				employee.setEmp_no(rs.getInt("emp_no"));
				employee.setEmp_name(rs.getString("emp_name"));
				employee.setEmp_email(rs.getString("emp_email"));
				employee.setEmp_admin(rs.getString("emp_admin"));
				employeeList.add(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
		return employeeList;		
	}
	
	// Employee List Search 출력
		public List<EmployeeVO> getEmployeeListSearch(String field, String query) {
			
			System.out.println("==> JDBC getEmployeeListSearch");
			
			
			List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
			
			
			try {
				conn = JDBCUtil.getConnection();
				if(field =="emp_name"){
					stmt = conn.prepareStatement(EMPLOYEE_LIST_N);					
				} else {
					stmt = conn.prepareStatement(EMPLOYEE_LIST_I);					
				}
				
				stmt.setString(1, "%"+query+"%");
				rs = stmt.executeQuery();	
				while(rs.next()) {
					EmployeeVO employee = new EmployeeVO();
					employee.setEmp_id(rs.getString("emp_id"));
					employee.setEmp_no(rs.getInt("emp_no"));
					employee.setEmp_name(rs.getString("emp_name"));
					employee.setEmp_email(rs.getString("emp_email"));
					employee.setEmp_admin(rs.getString("emp_admin"));
					employeeList.add(employee);
			
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(null, stmt, conn);
			}
			return employeeList;		
		}

		
	
	

}
