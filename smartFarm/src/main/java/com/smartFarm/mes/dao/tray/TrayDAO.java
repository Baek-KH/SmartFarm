package com.smartFarm.mes.dao.tray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.dao.pip.PipDAO;
import com.smartFarm.mes.vo.pip.PipVO;
import com.smartFarm.mes.vo.tray.TrayVO;

@Repository("TrayDAO")
public class TrayDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String TRAY_INSERT ="insert into tray values (?,?,?,?,?, now(),DATE_ADD(now(), INTERVAL ? DAY),?)";
	private final String TRAY_GET ="select * from tray where tray_id=?";	
	private final String TRAY_UPDATE ="update TRAY set tray_growth=? where tray_id=?";
	private final String TRAY_DELETE ="delete from tray where tray_id=?";
	private final String TRAY_LIST ="select * from tray order by tray_start_date desc";
	private final String TRAY_LIST_UN ="select * from tray where tray_end_date > CURDATE() order by tray_start_date desc";

	private final String TRAY_LIST_I_IN ="select * from tray where line_id like ? order by tray_start_date desc limit 8";
	private final String TRAY_LIST_I ="select * from tray where line_id like ? order by tray_start_date desc";
	private final String TRAY_LIST_DY ="select * from tray where year(tray_start_date) like ? order by tray_start_date desc";
	private final String TRAY_LIST_DM ="select * from tray where month(tray_start_date) like ? order by tray_start_date desc";
	private final String TRAY_LIST_DD ="select * from tray where day(tray_start_date) like ? order by tray_start_date desc";


	// 1. insert
	public void insertTray(TrayVO vo) {

		System.out.println("==> JDBC Tray insert");
		PipDAO pipDAO = new PipDAO();
		PipVO pipVO = pipDAO.getPip(vo.getPip_name());
		vo.setPip_period(pipVO.getPip_period());
		String getTray_NO = "select tray_id from tray ORDER BY CAST(tray_id AS SIGNED) DESC LIMIT 1";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getTray_NO);
			rs = stmt.executeQuery();
			if(rs.next()) {
				vo.setTray_id((Integer.parseInt(rs.getString("tray_id"))+1)+"");
			} else {
				vo.setTray_id("1");
			}
				vo.setTray_growth("0");

			stmt = conn.prepareStatement(TRAY_INSERT);
			stmt.setString(1, vo.getTray_id());
			stmt.setString(2, vo.getLine_id());
			stmt.setString(3, vo.getPip_name());
			stmt.setString(4, vo.getPip_qty());
			stmt.setString(5, vo.getPip_period());
			stmt.setInt(6, Integer.parseInt(vo.getPip_period()));
			stmt.setString(7, vo.getTray_growth());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}

	// 2. getTray
	public TrayVO getTray(String tray_id) {

		System.out.println("==> JDBC getTray");
		TrayVO tray = new TrayVO();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TRAY_GET);
			stmt.setString(1, tray_id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				tray.setTray_id(rs.getString("tray_id"));
				tray.setLine_id(rs.getString("line_id"));
				tray.setPip_name(rs.getString("pip_name"));
				tray.setPip_qty(rs.getString("pip_qty"));
				tray.setTray_growth(rs.getString("tray_growth"));				
				tray.setPip_period(rs.getString("pip_period"));
				tray.setTray_start_date(rs.getTimestamp("tray_start_date"));
				tray.setTray_end_date(rs.getTimestamp("tray_end_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return tray;

	}

	// 3. update
	public void updateTray(TrayVO vo) {

		System.out.println("==> JDBC Tray update");

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TRAY_UPDATE);			
			stmt.setString(1, vo.getTray_growth());
			stmt.setString(2, vo.getTray_id());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}
	

	// 4. delete
	public void deleteTray(TrayVO vo) {

		System.out.println("==> JDBC Tray delete");

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TRAY_DELETE);
			stmt.setString(1, vo.getTray_id());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}


	// Tray List 출력
	public List<TrayVO> getTrayList() {
		System.out.println("==> JDBC getTrayList");
		List<TrayVO> trayList = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(TRAY_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				TrayVO tray = new TrayVO();
				tray.setTray_id(rs.getString("tray_id"));
				tray.setLine_id(rs.getString("line_id"));
				tray.setPip_name(rs.getString("pip_name"));
				tray.setPip_qty(rs.getString("pip_qty"));
				tray.setTray_growth(rs.getString("tray_growth"));				
				tray.setPip_period(rs.getString("pip_period"));
				tray.setTray_start_date(rs.getTimestamp("tray_start_date"));
				tray.setTray_end_date(rs.getTimestamp("tray_end_date"));
				trayList.add(tray);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return trayList;
	}

	// Tray List 미완tray 출력 
		public List<TrayVO> getTrayListUnfinished() {
			System.out.println("==> JDBC getTrayListUnfinished");
			List<TrayVO> trayList = new ArrayList<>();

			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(TRAY_LIST_UN);
				rs = stmt.executeQuery();
				while(rs.next()) {
					TrayVO tray = new TrayVO();
					tray.setTray_id(rs.getString("tray_id"));
					tray.setLine_id(rs.getString("line_id"));
					tray.setPip_name(rs.getString("pip_name"));
					tray.setPip_qty(rs.getString("pip_qty"));
					tray.setTray_growth(rs.getString("tray_growth"));				
					tray.setPip_period(rs.getString("pip_period"));
					tray.setTray_start_date(rs.getTimestamp("tray_start_date"));
					tray.setTray_end_date(rs.getTimestamp("tray_end_date"));
					trayList.add(tray);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return trayList;
		}

	// Tray List Search
	public List<TrayVO> getTrayListSearch(String field, String query) {
		// field { line_id, year, month, day }


		System.out.println("==> JDBC getTrayListSearch");

		List<TrayVO> trayList = new ArrayList<>();


		try {
			conn = JDBCUtil.getConnection();
			if(field.equals("line_id")) {
				stmt = conn.prepareStatement(TRAY_LIST_I);
				stmt.setString(1, "%"+query+"%");
			} else if(field.equals("year")) {
				stmt = conn.prepareStatement(TRAY_LIST_DY);
				stmt.setInt(1, Integer.parseInt(query));
			} else if(field.equals("month")) {
				stmt = conn.prepareStatement(TRAY_LIST_DM);
				stmt.setInt(1, Integer.parseInt(query));
			} else if(field.equals("day")) {
				stmt = conn.prepareStatement(TRAY_LIST_DD);
				stmt.setInt(1, Integer.parseInt(query));
			}

			rs = stmt.executeQuery();
			while(rs.next()) {
				TrayVO tray = new TrayVO();
				tray.setTray_id(rs.getString("tray_id"));
				tray.setLine_id(rs.getString("line_id"));
				tray.setPip_name(rs.getString("pip_name"));
				tray.setPip_qty(rs.getString("pip_qty"));
				tray.setTray_growth(rs.getString("tray_growth"));				
				tray.setPip_period(rs.getString("pip_period"));
				tray.setTray_start_date(rs.getTimestamp("tray_start_date"));
				tray.setTray_end_date(rs.getTimestamp("tray_end_date"));
				trayList.add(tray);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return trayList;
	}
	
	// Tray List by line
		public List<TrayVO> getTrayListByLine(TrayVO vo) {


			System.out.println("==> JDBC getTrayListSearch");

			List<TrayVO> trayList = new ArrayList<>();


			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(TRAY_LIST_I_IN);
				stmt.setString(1, vo.getLine_id());
				rs = stmt.executeQuery();
				while(rs.next()) {
					TrayVO tray = new TrayVO();
					tray.setTray_id(rs.getString("tray_id"));
					tray.setLine_id(rs.getString("line_id"));
					tray.setPip_name(rs.getString("pip_name"));
					tray.setPip_qty(rs.getString("pip_qty"));
					tray.setTray_growth(rs.getString("tray_growth"));				
					tray.setPip_period(rs.getString("pip_period"));
					tray.setTray_start_date(rs.getTimestamp("tray_start_date"));
					tray.setTray_end_date(rs.getTimestamp("tray_end_date"));
					trayList.add(tray);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return trayList;
		}
	
	
	




}
