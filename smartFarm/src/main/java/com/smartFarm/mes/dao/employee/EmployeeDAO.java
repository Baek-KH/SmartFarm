package com.smartFarm.mes.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository("EmployeeDAO")
public class EmployeeDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String EMPLOYEE_INSERT ="insert into board(seq, title, writer, content) " +
		    " values((select nvl(max(seq), 0)+1 from board t1), ?,?,?)";
	private final String EMPLOYEE_UPDATE ="update board set title=?, content=? where seq=?";
	private final String EMPLOYEE_DELETE ="delete from board where seq=?";
	private final String EMPLOYEE_GET ="select * from board where seq=?";
	private final String EMPLOYEE_LIST ="select * from board order by seq desc";
	private final String EMPLOYEE_LIST_T ="select * from board where title like ? order by seq desc";
	private final String EMPLOYEE_LIST_C ="select * from board where content like ? order by seq desc";








}
