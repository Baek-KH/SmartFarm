package com.smartFarm.mes.dao.forward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.forward.ForwardVO;



@Repository("forwardDAO")
public class ForwardDAO {
	
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;


	private final String FORWARD_INSERT ="insert into forward (forward_id, pip_name, forward_qty, forward_content, forward_date, forward_check) values(?,?,?,?,now(),?)";
	private final String FORWARD_UPDATE ="update forward set forward_check=? where forward_id=?";
	private final String FORWARD_DELETE ="delete from forward where forward_id = ?";
	private final String FORWARD_GET ="select * from forward where forward_id=?";
	private final String FORWARD_LIST ="select * from forward order by forward_id desc";

	// CRUD기능메서드
	
	// 1. Insert

	public void insertForward(ForwardVO vo) {
		System.out.println("==> JDBC로 insertForward() 메서드 호출!!");

		String getforward_id = "select forward_id from forward ORDER BY CAST(forward_id AS SIGNED) DESC LIMIT 1";
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getforward_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				vo.setForward_id((Integer.parseInt(rs.getString("forward_id"))+1)+"");
			} else {
				vo.setForward_id("1");
			}
			stmt = conn.prepareStatement(FORWARD_INSERT);
			stmt.setString(1, vo.getForward_id());
			stmt.setString(2, vo.getPip_name());
			stmt.setString(3, vo.getForward_qty());
			stmt.setString(4, vo.getForward_content());
			stmt.setString(5, vo.getForward_check());

			System.out.println(vo.toString());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
}


	// 2. Update check

	public void updateForward(ForwardVO vo) {
		
		System.out.println("==> JDBC로 updateForward() 메서드 호출!!");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(FORWARD_UPDATE);
			stmt.setString(1, vo.getForward_check());
			stmt.setString(2, vo.getForward_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}


	// 3. Delete

	public void deleteForward(String forward_id) {
		System.out.println("==> JDBC로 deleteForward() 메서드 호출!!");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(FORWARD_DELETE);
			stmt.setString(1, forward_id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}



	// 4. Get

	public ForwardVO getForward(ForwardVO vo) {
		System.out.println("==> JDBC로 getForward() 메서드 호출!!");
		ForwardVO forward = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(FORWARD_GET);
			stmt.setString(1, vo.getForward_id());
			rs = stmt.executeQuery();
			if(rs.next()) {

				forward = new ForwardVO();
				forward.setForward_id(rs.getString("FORWARD_ID"));
				forward.setPip_name(rs.getString("PIP_NAME"));
				forward.setForward_qty(rs.getString("FORWARD_QTY"));
				forward.setForward_content(rs.getString("FORWARD_CONTENT"));
				forward.setForward_date(rs.getTimestamp("FORWARD_DATE"));
				forward.setForward_check(rs.getString("FORWARD_CHECK"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return forward;
	}



	//  List

	public List<ForwardVO> getForwardList() {
		System.out.println("==> JDBC로 getForwardList() 메서드 호출!!");
		List<ForwardVO> forwardList = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(FORWARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ForwardVO forward = new ForwardVO();
				forward.setForward_id(rs.getString("FORWARD_ID"));
				forward.setPip_name(rs.getString("PIP_NAME"));
				forward.setForward_qty(rs.getString("FORWARD_QTY"));
				forward.setForward_content(rs.getString("FORWARD_CONTENT"));
				forward.setForward_date(rs.getTimestamp("FORWARD_DATE"));
				forward.setForward_check(rs.getString("FORWARD_CHECK"));
				forwardList.add(forward);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return forwardList;
	}

}
