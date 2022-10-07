package com.smartFarm.mes.dao.pip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.pip.PipVO;




@Repository("PipDAO")
public class PipDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String PIP_INSERT ="insert into pip(pip_no, pip_name, pip_category, pip_period, pip_min_temp, pip_max_temp, pip_min_hum, pip_max_hum) " 
					+ " values(?,?,?,?,?,?,?,?)";
	private final String PIP_UPDATE ="update pip set pip_category=?, pip_period=?, pip_min_temp=?, pip_max_temp=?, pip_min_hum=?, pip_max_hum=? where pip_name=?";
	private final String PIP_DELETE ="delete form pip where pip_name=?";
	private final String PIP_GET ="select * from pip where pip_name=?";
	private final String PIP_LIST ="select * from pip order by pip_name desc";
	private final String PIP_LIST_NO ="select * from Pip where pip_no like ? ";
	private final String PIP_LIST_NA ="select * from Pip where pip_name like ? ";	
	
	// 등록
	public void insertPip(PipVO vo) {
		System.out.println("==>DAO ins");

		String getPip_NO = "select pip_no from pip ORDER BY pip_no DESC LIMIT 1";
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getPip_NO);
			rs = stmt.executeQuery();
			if(rs.next()) {
				vo.setPip_no(rs.getInt("pip_no")+1);
			} else {
				vo.setPip_no(1);
			}
			stmt = conn.prepareStatement(PIP_INSERT);
			stmt.setInt(1, vo.getPip_no());
			stmt.setString(2, vo.getPip_name());
			stmt.setString(3, vo.getPip_category());
			stmt.setString(4, vo.getPip_period());
			stmt.setString(5, vo.getPip_min_temp());
			stmt.setString(6, vo.getPip_max_temp());
			stmt.setString(7, vo.getPip_min_hum());
			stmt.setString(8, vo.getPip_max_hum());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}
	
	// 수정
	public void updatePip(PipVO vo) {
		System.out.println("==>DAO upd");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PIP_UPDATE);
			
				stmt.setString(1, vo.getPip_name());
				stmt.setString(2, vo.getPip_category());
				stmt.setString(3, vo.getPip_period());
				stmt.setString(4, vo.getPip_min_temp());
				stmt.setString(5, vo.getPip_max_temp());
				stmt.setString(6, vo.getPip_min_hum());
				stmt.setString(7, vo.getPip_max_hum());
				stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}	
		
	}
	
	// 삭제
	public void deletePip(PipVO vo) {
		System.out.println("==>DAO del");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PIP_DELETE);
			stmt.setString(1, vo.getPip_name());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}		
	}
	
	//   작물상세정보
	public PipVO getPip(String pip_name) {
		
		System.out.println("==>DAO g_list");
		PipVO pip = new PipVO();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PIP_GET);
			stmt.setString(2, pip_name);
			rs = stmt.executeQuery();
			if(rs.next()) {
				
				pip = new PipVO();
				pip.setPip_no(rs.getInt("pip_no"));
				pip.setPip_name(rs.getString("pip_name"));
				pip.setPip_category(rs.getString("pip_category"));
				pip.setPip_period(rs.getString("pip_period"));
				pip.setPip_min_temp(rs.getString("pip_min_temp"));
				pip.setPip_max_temp(rs.getString("pip_max_temp"));
				pip.setPip_min_hum(rs.getString("pip_min_hum"));
				pip.setPip_max_hum(rs.getString("pip_max_hum"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}		
		return pip;
	}

	
	// 작물리스트 출력
	public List<PipVO> getPipList() {
		
		System.out.println("==>DAO gp_list");
		
		List<PipVO> pipList = new ArrayList<PipVO>();	
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PIP_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				PipVO pip = new PipVO();
				pip.setPip_no(rs.getInt("pip_no"));
				pip.setPip_name(rs.getString("pip_name"));
				pip.setPip_category(rs.getString("pip_category"));
				pip.setPip_period(rs.getString("pip_period"));
				pipList.add(pip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}		
		return pipList;
	}
	
	// Pip 검색기능
	public List<PipVO> getPipListSearch(String field, String query) {

		// field { pip_name, pip_no}

		
		System.out.println("==>DAO pip_serch");
		
		
		List<PipVO> pipList = new ArrayList<PipVO>();
		
		
		try {
			conn = JDBCUtil.getConnection();
			if(field =="pip_name"){
				stmt = conn.prepareStatement(PIP_LIST_NA);					

			} else {

			} else if(field =="pip_no") {

				stmt = conn.prepareStatement(PIP_LIST_NO);					
			}
			stmt.setString(1, "%"+query+"%");
			rs = stmt.executeQuery();	
			while(rs.next()) {
				PipVO pip = new PipVO();
				pip.setPip_no(rs.getInt("pip_no"));
				pip.setPip_name(rs.getString("pip_name"));
				pipList.add(pip);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
		return pipList;		
	}

	
}