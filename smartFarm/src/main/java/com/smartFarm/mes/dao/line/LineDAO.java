package com.smartFarm.mes.dao.line;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.line.LineVO;

@Repository("LineDAO")
public class LineDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String LINE_STATUS_UPDATE ="update Line set line_status=? where line_id = ?";
	private final String LINE_UPDATE ="update Line set line_temp=?, line_hum=?, line_status=? , line_pip=? where line_id = ?";
	private final String LINE_GET ="select * from Line where line_id=?";
	private final String LINE_LIST ="select * from Line ";
	
	private final String LINE_UPDATE_T = "update Line set line_temp=? where line_id = ?";
	private final String LINE_UPDATE_H = "update Line set line_hum=? where line_id = ?";
	private final String LINE_UPDATE_P = "update Line set line_pip=? where line_id = ?";
	

	// 1. update
			public void updateLine(LineVO vo) {

				System.out.println("==> JDBC Line update");
				try {
					conn = JDBCUtil.getConnection();
					stmt = conn.prepareStatement(LINE_UPDATE);
					stmt.setString(1, vo.getLine_temp());
					stmt.setString(2, vo.getLine_hum());
					stmt.setString(3, vo.getLine_status());
					stmt.setString(4, vo.getLine_pip());					
					stmt.setString(5, vo.getLine_id());
					stmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(null, stmt, conn);
				}
			}
			
			// 1-1 update line_status
			public void updateLineStatus(String line_id,String Status) {

				System.out.println("==> JDBC Line_status update");
				try {
					conn = JDBCUtil.getConnection();
					stmt = conn.prepareStatement(LINE_STATUS_UPDATE);
					stmt.setString(1, Status);
					stmt.setString(2, line_id);
					stmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(null, stmt, conn);
				}
			}
			
			// 1-2 update line_Detail
			public void updateLineDetail(LineVO vo,String field,String query) {
				
				System.out.println("==> JDBC updateLineDetail ");
				
				try {
					conn = JDBCUtil.getConnection();
					if(field.equals("line_temp")) {
						stmt = conn.prepareStatement(LINE_UPDATE_T);	
					} else if(field.equals("line_hum")) {
						stmt = conn.prepareStatement(LINE_UPDATE_H);						
					} else if(field.equals("line_pip")) {
						stmt = conn.prepareStatement(LINE_UPDATE_P);						
					}
					stmt.setString(1, query);
					stmt.setString(2, vo.getLine_id());
					stmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(null, stmt, conn);
				}
			}


	// 2. get
	public LineVO getLine(String line_id) {

		System.out.println("==> JDBC getLine");
		LineVO lineVO = new LineVO();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(LINE_GET);
			stmt.setString(1, line_id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				lineVO.setLine_id(rs.getString("line_id"));
				lineVO.setLine_temp(rs.getString("line_temp"));
				lineVO.setLine_hum(rs.getString("line_hum"));
				lineVO.setLine_status(rs.getString("line_status"));
				lineVO.setLine_pip(rs.getString("line_pip"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return lineVO;

	}


	// Line List 출력
	public List<LineVO> getLineList() {
		System.out.println("==> JDBC getLineList");
		List<LineVO> lineList = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(LINE_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				LineVO lineVO = new LineVO();
				lineVO.setLine_id(rs.getString("line_id"));
				lineVO.setLine_temp(rs.getString("line_temp"));
				lineVO.setLine_hum(rs.getString("line_hum"));
				lineVO.setLine_status(rs.getString("line_status"));
				lineVO.setLine_pip(rs.getString("line_pip"));
				lineList.add(lineVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return lineList;
	}



}
