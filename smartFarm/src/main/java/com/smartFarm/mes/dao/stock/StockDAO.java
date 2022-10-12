package com.smartFarm.mes.dao.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.stock.StockVO;

@Repository("StockDAO")
public class StockDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// 등록 조회 수정
	
	private final String STOCK_INSERT ="insert into stock values (?,?,?,?)";
	private final String STOCK_GET ="select * from Stock where stock_id=?";
	private final String STOCK_UPDATE ="update Stock set stock_category=?, stock_name=?, stock_qty=? where stock_id = ?";
    private final String STOCK_QTY_UPDATE ="update Stock set stock_qty=? where stock_id = ?";
	private final String STOCK_LIST ="select * from Stock ";
	private final String STOCK_LIST_ID ="select * from Stock where stock_id like ? ";
	
	// 1. insert
    public void insertStock(StockVO vo) {

        System.out.println("==> JDBC stock insert");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STOCK_INSERT);
            stmt.setString(1, vo.getStock_id());
            stmt.setString(2, vo.getStock_category());
            stmt.setString(3, vo.getStock_name());
            stmt.setInt(4, 0);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, stmt, conn);
        }
    }
    
    // 2. get
    public StockVO getStock(String stock_id) {

        System.out.println("==> JDBC getStock");
        StockVO stockVO = new StockVO();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STOCK_GET);
            stmt.setString(1, stock_id);
            rs = stmt.executeQuery();
            while(rs.next()) {
                stockVO.setStock_id(rs.getString("stock_id"));
                stockVO.setStock_category(rs.getString("stock_category"));
                stockVO.setStock_name(rs.getString("stock_name"));
                stockVO.setStock_qty(rs.getInt("stock_qty"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return stockVO;

    }
    

	// 1. update
			public void updateStock(StockVO vo) {

				System.out.println("==> JDBC Stock update");
				try {
					conn = JDBCUtil.getConnection();
					stmt = conn.prepareStatement(STOCK_UPDATE);
					stmt.setString(1, vo.getStock_category());
					stmt.setString(2, vo.getStock_name());
					stmt.setInt(3, vo.getStock_qty());
					stmt.setString(4, vo.getStock_id());
					stmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(null, stmt, conn);
				}
			}
//	// 1-1 update stock_stock
//			public void updateStockQty(String stock_id,int stock_qty) {
//
//				System.out.println("==> JDBC Stock_stock update");
//				try {
//					conn = JDBCUtil.getConnection();
//					stmt = conn.prepareStatement(STOCK_STATUS_UPDATE);
//					stmt.setString(1, Stock);
//					stmt.setString(2, stock_id);
//					stmt.executeUpdate();
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					JDBCUtil.close(null, stmt, conn);
//				}
//			}


	


	// Stock List 출력
	public List<StockVO> getStockList() {
		System.out.println("==> JDBC getStockList");
		List<StockVO> stockList = new ArrayList<StockVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(STOCK_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				StockVO stockVO = new StockVO();
				stockVO.setStock_id(rs.getString("stock_id"));
                stockVO.setStock_category(rs.getString("stock_category"));
                stockVO.setStock_name(rs.getString("stock_name"));
                stockVO.setStock_qty(rs.getInt("stock_qty"));
				stockList.add(stockVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return stockList;
	}

	
	
	// StockListSearch
	public List<StockVO> getStockListSearch( String query) {

        System.out.println("==> JDBC getStockListSearch");

        List<StockVO> stockList = new ArrayList<>();


        try {
            conn = JDBCUtil.getConnection();
           
            stmt = conn.prepareStatement(STOCK_LIST_ID);
            stmt.setString(1, "%"+query+"%");

            rs = stmt.executeQuery();
            while(rs.next()) {
                StockVO stockVO = new StockVO();
                stockVO.setStock_id(rs.getString("stock_id"));
                stockVO.setStock_category(rs.getString("stock_category"));
                stockVO.setStock_name(rs.getString("stock_name"));
                stockVO.setStock_qty(rs.getInt("stock_qty"));
                stockList.add(stockVO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return stockList;
    }

}
