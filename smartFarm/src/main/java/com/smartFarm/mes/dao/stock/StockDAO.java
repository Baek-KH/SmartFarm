package com.smartFarm.mes.dao.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository("StockDAO")
public class StockDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// 등록 조회 수정

	private final String STOCK_INSERT ="insert into stock values (????)";
	private final String STOCK_UPDATE ="update Stock set stock_temp=?, stock_hum=?, stock_status=? where stock_id = ?";
	private final String STOCK_GET ="select * from Stock where stock_id=?";
	private final String STOCK_LIST ="select * from Stock ";

//
//	// 1. update
//			public void updateStock(StockVO vo) {
//
//				System.out.println("==> JDBC Stock update");
//				try {
//					conn = JDBCUtil.getConnection();
//					stmt = conn.prepareStatement(STOCK_UPDATE);
//					stmt.setString(1, vo.getStock_temp());
//					stmt.setString(2, vo.getStock_hum());
//					stmt.setString(3, vo.getStock_status());
//					stmt.setString(4, vo.getStock_id());
//					stmt.executeUpdate();
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					JDBCUtil.close(null, stmt, conn);
//				}
//			}
//			// 1-1 update stock_status
//			public void updateStockStatus(String stock_id,String Status) {
//
//				System.out.println("==> JDBC Stock_status update");
//				try {
//					conn = JDBCUtil.getConnection();
//					stmt = conn.prepareStatement(STOCK_STATUS_UPDATE);
//					stmt.setString(1, Status);
//					stmt.setString(2, stock_id);
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
//	public StockVO getStock(String stock_id) {
//
//		System.out.println("==> JDBC getStock");
//		StockVO stockVO = new StockVO();
//
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(STOCK_GET);
//			stmt.setString(1, stock_id);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				stockVO.setStock_id(rs.getString("stock_id"));
//				stockVO.setStock_temp(rs.getString("stock_temp"));
//				stockVO.setStock_hum(rs.getString("stock_hum"));
//				stockVO.setStock_status(rs.getString("stock_status"));
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return stockVO;
//
//	}
//
//
//	// Stock List 출력
//	public List<StockVO> getStockList() {
//		System.out.println("==> JDBC getStockList");
//		List<StockVO> stockList = new ArrayList<StockVO>();
//
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(STOCK_LIST);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				StockVO stockVO = new StockVO();
//				stockVO.setStock_id(rs.getString("stock_id"));
//				stockVO.setStock_temp(rs.getString("stock_temp"));
//				stockVO.setStock_hum(rs.getString("stock_hum"));
//				stockVO.setStock_status(rs.getString("stock_status"));
//				stockList.add(stockVO);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return stockList;
//	}
//


}
