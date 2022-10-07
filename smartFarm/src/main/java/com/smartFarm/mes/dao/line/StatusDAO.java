package com.smartFarm.mes.dao.line;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.line.LineVO;
import com.smartFarm.mes.vo.line.StatusVO;

@Repository("StatusDAO")
public class StatusDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

//	private String status_id;	
//	private String status_line_id;	
//	private String status_temp;	
//	private String status_line_temp;	
//	private String status_hum;	
//	private String status_line_hum;	
//	private String status_time;
	
	private final String STATUS_INSERT ="insert into line_Status values (?,?,?,?,?,?, now())";
	private final String STATUS_GET ="select * from line_Status where status_line_id like ? order by status_time desc limit 1";
	private final String STATUS_LIST ="select * from line_Status order by status_time desc";
	private final String STATUS_LIST_L ="select * from line_Status where line_id like ? order by status_time desc";
	private final String STATUS_LIST_DY ="select * from line_Status where year(status_time) like ? order by status_time desc";
	private final String STATUS_LIST_DM ="select * from line_Status where month(status_time) like ? order by status_time desc";
	private final String STATUS_LIST_DD ="select * from line_Status where day(status_time) like ? order by status_time desc";


	
	// 1. insert
	public void insertStatus(StatusVO vo) {
		
		System.out.println("==> JDBC Status insert");
		
		LineDAO lineDAO = new LineDAO();
		LineVO lineVO = lineDAO.getLine(vo.getStatus_line_id());
		
		String getStatus_id = "select status_id from line_Status ORDER BY length(status_id) DESC , status_id DESC limit 1";
		
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getStatus_id);
			rs = stmt.executeQuery();	
			if(rs.next()) {
				String status_id = rs.getString("status_id");
				int no = Integer.parseInt(status_id.substring(7));
				vo.setStatus_id("status_"+(no+1));
			} 
			vo.setStatus_line_temp(lineVO.getLine_temp());
			vo.setStatus_line_hum(lineVO.getLine_hum());
			
			stmt = conn.prepareStatement(STATUS_INSERT);
			stmt.setString(1, vo.getStatus_id());
			stmt.setString(2, vo.getStatus_line_id());
			stmt.setString(3, vo.getStatus_temp());
			stmt.setString(4, vo.getStatus_line_temp());
			stmt.setString(5, vo.getStatus_hum());
			stmt.setString(6, vo.getStatus_line_hum());
	
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}		
	}
	
	// 2. getStatus
	public StatusVO getStatus(String line_id) {
		
		System.out.println("==> JDBC getStatus");
		StatusVO statusVO = new StatusVO();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(STATUS_GET);
			stmt.setString(1, line_id);
			rs = stmt.executeQuery();	
			while(rs.next()) {
				statusVO.setStatus_id(rs.getString("status_id"));
				statusVO.setStatus_line_id(rs.getString("status_line_id"));
				statusVO.setStatus_temp(rs.getString("status_temp"));
				statusVO.setStatus_line_temp(rs.getString("status_line_temp"));
				statusVO.setStatus_hum(rs.getString("status_hum"));
				statusVO.setStatus_line_hum(rs.getString("status_line_hum"));
				statusVO.setStatus_time(rs.getTimestamp("status_time"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return statusVO;	
		
	}
		
//	private final String STATUS_LIST ="select * from Status order by status_time desc";

	// Status List 
		public List<StatusVO> getStatusList() {
			
			System.out.println("==> JDBC getStatusList");
			
			
			List<StatusVO> statusList = new ArrayList<StatusVO>();
			
			
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(STATUS_LIST);
				rs = stmt.executeQuery();	
				while(rs.next()) {
					StatusVO statusVO = new StatusVO();
					statusVO.setStatus_id(rs.getString("status_id"));
					statusVO.setStatus_line_id(rs.getString("status_line_id"));
					statusVO.setStatus_temp(rs.getString("status_temp"));
					statusVO.setStatus_line_temp(rs.getString("status_line_temp"));
					statusVO.setStatus_hum(rs.getString("status_hum"));
					statusVO.setStatus_line_hum(rs.getString("status_line_hum"));
					statusVO.setStatus_time(rs.getTimestamp("status_time"));
					statusList.add(statusVO);
			
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return statusList;		
		}

//		private final String STATUS_LIST_L ="select * from Status where line_id like ? order by status_time desc";
//		private final String STATUS_LIST_DY ="select * from Status where year(status_time) like ? order by status_time desc";
//		private final String STATUS_LIST_DM ="select * from Status where month(status_time) like ? order by status_time desc";		
//		private final String STATUS_LIST_DM ="select * from Status where month(status_time) like ? order by status_time desc";		
		
		// Status List Search
		public List<StatusVO> getStatusListSearch(String field, String query) {
			
			System.out.println("==> JDBC getStatusListSearch");
			
			List<StatusVO> statusList = new ArrayList<StatusVO>();
			
			
			try {
				conn = JDBCUtil.getConnection();
				if(field.equals("line_id")) {
					stmt = conn.prepareStatement(STATUS_LIST_L);
					stmt.setString(1, "%"+query+"%");
				} else if(field.equals("year")) {
					stmt = conn.prepareStatement(STATUS_LIST_DY);
					stmt.setInt(1, Integer.parseInt(query));
				} else if(field.equals("month")) {
					stmt = conn.prepareStatement(STATUS_LIST_DM);
					stmt.setInt(1, Integer.parseInt(query));
				} else if(field.equals("day")) {
					stmt = conn.prepareStatement(STATUS_LIST_DD);
					stmt.setInt(1, Integer.parseInt(query));
				}
				
				rs = stmt.executeQuery();	
				while(rs.next()) {
					StatusVO statusVO = new StatusVO();
					statusVO.setStatus_id(rs.getString("status_id"));
					statusVO.setStatus_line_id(rs.getString("status_line_id"));
					statusVO.setStatus_temp(rs.getString("status_temp"));
					statusVO.setStatus_line_temp(rs.getString("status_line_temp"));
					statusVO.setStatus_hum(rs.getString("status_hum"));
					statusVO.setStatus_line_hum(rs.getString("status_line_hum"));
					statusVO.setStatus_time(rs.getTimestamp("status_time"));
					statusList.add(statusVO);
			
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return statusList;		
		}
		
	
	

}
