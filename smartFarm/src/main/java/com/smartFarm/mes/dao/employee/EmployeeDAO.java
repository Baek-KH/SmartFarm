package com.smartFarm.mes.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartFarm.mes.vo.employee.EmployeeVO;

@Repository("EmployeeDAO")
public class EmployeeDAO {

	
	public EmployeeDAO() {
		System.out.println("생성자 생성");
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String EMPLOYEE_INSERT ="insert into Employee (emp_id , emp_name) values (?,?)";
//	private final String EMPLOYEE_UPDATE ="update Employee set title=?, content=? where seq=?";
//	private final String EMPLOYEE_DELETE ="delete from Employee where seq=?";
//	private final String EMPLOYEE_GET ="select * from Employee where seq=?";
//	private final String EMPLOYEE_LIST ="select * from Employee order by seq desc";
//	private final String EMPLOYEE_LIST_T ="select * from Employee where title like ? order by seq desc";
//	private final String EMPLOYEE_LIST_C ="select * from Employee where content like ? order by seq desc";

	
	// 1. insert
	public void insertEmployee(EmployeeVO vo) {
		System.out.println("==> JDBC Employee insert");
		System.out.println(vo.getEmp_id() + vo.getEmp_name());
		System.out.println(jdbcTemplate);
		jdbcTemplate.update( EMPLOYEE_INSERT, vo.getEmp_id(), vo.getEmp_name());
	}
	
//	// 2. �ۼ���
//	public void updateEmployee(EmployeeVO vo) {
//		System.out.println("==> JDBC�� updateEmployee() �޼��� ȣ��!!");
//		jdbcTemplate.update(Employee_UPDATE, vo.getTitle(),vo.getContent(), vo.getSeq());
//	}
//	
//	// 3. �ۻ���
//	public void deleteEmployee(EmployeeVO vo) {
//		System.out.println("==> JDBC�� deleteEmployee() �޼��� ȣ��!!");
//		jdbcTemplate.update(Employee_DELETE, vo.getSeq());
//	}
//	
//	// 4. ����ȸ
//	public EmployeeVO getEmployee(EmployeeVO vo) {
//		System.out.println("==> JDBC�� getEmployee() �޼��� ȣ��!!");
//		Object[] args = { vo.getSeq() };				
//		return jdbcTemplate.queryForObject(Employee_GET, args, new EmployeeRowMapper());
//	}
//	
//	// 5. �۸��
//	public List<EmployeeVO> getEmployeeList(EmployeeVO vo) {
//		System.out.println("==> JDBC�� getEmployeeList() �޼��� ȣ��!!");				
//		return jdbcTemplate.query(Employee_LIST, new EmployeeRowMapper());
//	}
//	
	
	

}
