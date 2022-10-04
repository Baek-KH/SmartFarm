package com.smartFarm.mes.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

	public static Connection getConnection() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mariadb://localhost:3306/spring", "root", "12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// dummy
		}
	}
	
	public static void rollbact(Connection conn) {
		try {
			if(conn!=null) conn.rollback();
		} catch (Exception e) {
			// dummy
		}
	}
}
