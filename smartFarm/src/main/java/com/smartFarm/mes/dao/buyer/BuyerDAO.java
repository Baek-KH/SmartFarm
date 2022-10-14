package com.smartFarm.mes.dao.buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.buyer.BuyerVO;

@Repository("BuyerDAO")
public class BuyerDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// insert 완료
	
	
	private final String BUYER_INSERT ="insert into Buyer values (?,?,?,?,?,?)";
	private final String BUYER_GET ="select * from Buyer where buyer_id=?";
	private final String BUYER_DELETE ="select * from Buyer where buyer_id=?";
	private final String BUYER_UPDATE ="update Buyer set buyer_temp=?, buyer_hum=?, buyer_status=? , buyer_pip=? where buyer_id = ?";
	private final String BUYER_LIST ="select * from Buyer ";
	
//	private String buyer_id;
//	private String buyer_name;
//	private String buyer_email;
//	private String buyer_number;
//	private String buyer_product;
//	private Date buyer_date;
	
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
				stmt.setString(5, vo.getBuyer_date());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(null, stmt, conn);
			}
		}
	
//	
//	// 1. update
//			public void updateBuyer(BuyerVO vo) {
//
//				System.out.println("==> JDBC Buyer update");
//				try {
//					conn = JDBCUtil.getConnection();
//					stmt = conn.prepareStatement(BUYER_UPDATE);
//					stmt.setString(1, vo.getBuyer_temp());
//					stmt.setString(2, vo.getBuyer_hum());
//					stmt.setString(3, vo.getBuyer_status());
//					stmt.setString(4, vo.getBuyer_pip());					
//					stmt.setString(5, vo.getBuyer_id());
//					stmt.executeUpdate();
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					JDBCUtil.close(null, stmt, conn);
//				}
//			}
//
//
//	// 2. get
//	public BuyerVO getBuyer(String buyer_id) {
//
//		System.out.println("==> JDBC getBuyer");
//		BuyerVO buyerVO = new BuyerVO();
//
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BUYER_GET);
//			stmt.setString(1, buyer_id);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				buyerVO.setBuyer_id(rs.getString("buyer_id"));
//				buyerVO.setBuyer_temp(rs.getString("buyer_temp"));
//				buyerVO.setBuyer_hum(rs.getString("buyer_hum"));
//				buyerVO.setBuyer_status(rs.getString("buyer_status"));
//				buyerVO.setBuyer_pip(rs.getString("buyer_pip"));
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return buyerVO;
//
//	}
//
//
//	// Buyer List 출력
//	public List<BuyerVO> getBuyerList() {
//		System.out.println("==> JDBC getBuyerList");
//		List<BuyerVO> buyerList = new ArrayList<>();
//
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BUYER_LIST);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				BuyerVO buyerVO = new BuyerVO();
//				buyerVO.setBuyer_id(rs.getString("buyer_id"));
//				buyerVO.setBuyer_temp(rs.getString("buyer_temp"));
//				buyerVO.setBuyer_hum(rs.getString("buyer_hum"));
//				buyerVO.setBuyer_status(rs.getString("buyer_status"));
//				buyerVO.setBuyer_pip(rs.getString("buyer_pip"));
//				buyerList.add(buyerVO);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return buyerList;
//	}
//


}
