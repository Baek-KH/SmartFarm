package com.smartFarm.mes.dao.buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.buyer.BuyerVO;

@Repository("BuyerDAO")
public class BuyerDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// insert 완료 o
	// update 완료
	// get 완료 o
	// delete 완료
	// list 완료
	// 완료
	
	
	
	private final String BUYER_INSERT ="insert into Buyer values (?,?,?,?,?,?)";
	private final String BUYER_UPDATE ="update Buyer set  buyer_name = ? , buyer_email=? ,buyer_number=? ,buyer_product=? , buyer_date =? where buyer_id= ?";
	private final String BUYER_GET ="select * from Buyer where buyer_id=?";
	private final String BUYER_GET_N ="select * from Buyer where buyer_name = ?";
	private final String BUYER_DELETE ="delete from Buyer where buyer_id = ?";
	private final String BUYER_LIST ="select * from Buyer ";
	
	
	// 1. insert
		public void insertBuyer(BuyerVO vo) {

			System.out.println("==> JDBC Buyer insert");

			String getBuyer_NO = "select buyer_id from buyer ORDER BY CAST(buyer_id AS SIGNED) DESC LIMIT 1";

			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(getBuyer_NO);
				rs = stmt.executeQuery();
				if(rs.next()) {
					vo.setBuyer_id((Integer.parseInt(rs.getString("buyer_id"))+1)+"");
				} else {
					vo.setBuyer_id("1");
				}

				stmt = conn.prepareStatement(BUYER_INSERT);
				stmt.setString(1, vo.getBuyer_id());
				stmt.setString(2, vo.getBuyer_name());
				stmt.setString(3, vo.getBuyer_email());
				stmt.setString(4, vo.getBuyer_number());
				stmt.setString(5, vo.getBuyer_product());
				stmt.setString(6, vo.getBuyer_date());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(null, stmt, conn);
			}
		}
	

	// 2. update
			public void updateBuyer(BuyerVO vo) {

				System.out.println("==> JDBC Buyer update");
				try {
					conn = JDBCUtil.getConnection();
					stmt = conn.prepareStatement(BUYER_UPDATE);
					stmt.setString(1, vo.getBuyer_name());
					stmt.setString(2, vo.getBuyer_email());
					stmt.setString(3, vo.getBuyer_number());
					stmt.setString(4, vo.getBuyer_product());					
					stmt.setString(5, vo.getBuyer_date());
					stmt.setString(6, vo.getBuyer_id());
					stmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(null, stmt, conn);
				}
			}


	// 2. get
	public BuyerVO getBuyer(String buyer_id) {

		System.out.println("==> JDBC getBuyer");
		BuyerVO buyerVO = new BuyerVO();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BUYER_GET);
			stmt.setString(1, buyer_id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				buyerVO.setBuyer_id(rs.getString("buyer_id"));
				buyerVO.setBuyer_name(rs.getString("buyer_name"));
				buyerVO.setBuyer_email(rs.getString("buyer_email"));
				buyerVO.setBuyer_number(rs.getString("buyer_number"));
				buyerVO.setBuyer_product(rs.getString("buyer_product"));
				buyerVO.setBuyer_date(rs.getString("buyer_date"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return buyerVO;

	} 
	
	// 2. get- name
	public BuyerVO getBuyerName(String buyer_name) {
		
		System.out.println("==> JDBC getBuyerName");
		BuyerVO buyerVO = new BuyerVO();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BUYER_GET);
			stmt.setString(1, "%"+buyer_name+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				buyerVO.setBuyer_id(rs.getString("buyer_id"));
				buyerVO.setBuyer_name(rs.getString("buyer_name"));
				buyerVO.setBuyer_email(rs.getString("buyer_email"));
				buyerVO.setBuyer_number(rs.getString("buyer_number"));
				buyerVO.setBuyer_product(rs.getString("buyer_product"));
				buyerVO.setBuyer_date(rs.getString("buyer_date"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return buyerVO;
		
	}
	
	// 4. delete
		public void deleteBuyer(BuyerVO vo) {

			System.out.println("==> JDBC buyer delete");
			
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BUYER_DELETE);
				stmt.setString(1, vo.getBuyer_id());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(null, stmt, conn);
			}
		}
	
	


	// Buyer List 출력
	public List<BuyerVO> getBuyerList() {
		System.out.println("==> JDBC getBuyerList");
		List<BuyerVO> buyerList = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BUYER_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BuyerVO buyerVO = new BuyerVO();
				buyerVO.setBuyer_id(rs.getString("buyer_id"));
				buyerVO.setBuyer_name(rs.getString("buyer_name"));
				buyerVO.setBuyer_email(rs.getString("buyer_email"));
				buyerVO.setBuyer_number(rs.getString("buyer_number"));
				buyerVO.setBuyer_product(rs.getString("buyer_product"));
				buyerVO.setBuyer_date(rs.getString("buyer_date"));
				buyerList.add(buyerVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return buyerList;
	}



}
