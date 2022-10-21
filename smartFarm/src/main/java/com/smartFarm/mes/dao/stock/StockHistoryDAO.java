package com.smartFarm.mes.dao.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.stock.ProductRateVO;
import com.smartFarm.mes.vo.stock.StockHistoryVO;
import com.smartFarm.mes.vo.stock.StockVO;

@Repository("StockHistoryDAO")
public class StockHistoryDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	StockDAO stockDAO = new StockDAO();
	
	// 등록 조회 수정

	private final String STOCKHISTORY_INSERT ="insert into stock_history values (?,?,?,?,?,now())";
	private final String STOCKHISTORY_GET ="select * from stock_history where stock_id = ?";
	private final String STOCKHISTORY_LIST ="select * from stock_history ";
	private final String STOCKHISTORY_LIST_I ="select * from stock_history where stock_out = 0";
	private final String STOCKHISTORY_LIST_O ="select * from stock_history where stock_in = 0";
	private final String STOCKHISTORY_LIST_ID ="select * from stock_history where stock_id = ? ";

	
	private final String PRODUCT_GET = "select sum(stock_in) \"stock_in_sum\" , sum(stock_out) \"stock_in_out\" "
			+ "from stock_history "
			+ "where stock_date > CURDATE()";
	private final String PRODUCT_LIST = "select sum(stock_in) \"stock_in_sum\" , sum(stock_out) \"stock_out_sum\",Day(stock_date) \"stock_date\""
			+ "from stock_history where stock_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK ) AND NOW() GROUP BY Day(stock_date)";
	
	
	
	
	// 1. insert
    public void insertStockHistory(StockHistoryVO vo) {

        System.out.println("==> JDBC stockHistory insert");

        StockVO stockVO = new StockVO();
        stockVO = stockDAO.getStock(vo.getStock_id());
        int stock_qty = 0;
        // 재고 수량 조절
        if(vo.getStock_in()>0) {
            stock_qty = stockVO.getStock_qty()+vo.getStock_in();
            stockVO.setStock_qty(stock_qty);
        } else if(vo.getStock_out()>0) {
            stock_qty = stockVO.getStock_qty()-vo.getStock_out();
            stockVO.setStock_qty(stock_qty);            
        }
        
     
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STOCKHISTORY_INSERT);
            stmt.setString(1, vo.getStock_id());
            stmt.setString(2, stockVO.getStock_name());
            stmt.setInt(3, vo.getStock_in());
            stmt.setInt(4, vo.getStock_out());
            stmt.setInt(5, stockVO.getStock_qty());
            stmt.executeUpdate();
            
            stockDAO.updateStock(stockVO);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, stmt, conn);
        }
    }
    private String stock_id;
    private String stock_name;
    private int Stock_in;
    private int Stock_out;
    private int Stock_qty;
    private Date stock_date;
    // 2. get
    public StockHistoryVO getStockHistory(String stock_id) {

        System.out.println("==> JDBC getStock");
        StockHistoryVO stockHistoryVO = new StockHistoryVO();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STOCKHISTORY_GET);
            stmt.setString(1, stock_id);
            rs = stmt.executeQuery();
            while(rs.next()) {
                stockHistoryVO.setStock_id(rs.getString("stock_id"));
                stockHistoryVO.setStock_name(rs.getString("stock_name"));
                stockHistoryVO.setStock_in(rs.getInt("stock_in"));
                stockHistoryVO.setStock_out(rs.getInt("stock_out"));
                stockHistoryVO.setStock_qty(rs.getInt("stock_qty"));
                stockHistoryVO.setStock_date(rs.getTimestamp("stock_date"));
            }

        } catch (Exception e) {
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return stockHistoryVO;

    }
        
 // getProductRate 출력
    public ProductRateVO getProductRate() {
    	
    	System.out.println("==> JDBC getProductRate");
    	
    	ProductRateVO productRateVO = new ProductRateVO();

    	
    	try {
    		conn = JDBCUtil.getConnection();
    		stmt = conn.prepareStatement(PRODUCT_LIST);
    		rs = stmt.executeQuery();
    		while(rs.next()) {
    			productRateVO.setStock_in_sum(rs.getInt("stock_in_sum"));
    			productRateVO.setStock_out_sum(rs.getInt("stock_out_sum"));
    	
    
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		JDBCUtil.close(rs, stmt, conn);
    	}
    	return productRateVO;
    }

    // productRateList 출력
    public List<ProductRateVO> productRateList() {
    	
    	System.out.println("==> JDBC productRateList");
    	
    	List<ProductRateVO> productRateList = new ArrayList<ProductRateVO>();
    	
    	try {
    		conn = JDBCUtil.getConnection();
    		stmt = conn.prepareStatement(PRODUCT_LIST);
    		rs = stmt.executeQuery();
    		while(rs.next()) {
    			ProductRateVO productRateVO = new ProductRateVO();
    			productRateVO.setStock_in_sum(rs.getInt("stock_in_sum"));
    			productRateVO.setStock_out_sum(rs.getInt("stock_out_sum"));
    			productRateVO.setStock_date(rs.getInt("stock_date"));
    
    			productRateList.add(productRateVO);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		JDBCUtil.close(rs, stmt, conn);
    	}
    	return productRateList;
    }
    // StockHistory List 출력
    public List<StockHistoryVO> getStockHistoryList() {
        
        System.out.println("==> JDBC getStockHistoryList");
        
        List<StockHistoryVO> stockHistoryList = new ArrayList<StockHistoryVO>();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STOCKHISTORY_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                StockHistoryVO stockHistoryVO = new StockHistoryVO();
                stockHistoryVO.setStock_id(rs.getString("stock_id"));
                stockHistoryVO.setStock_name(rs.getString("stock_name"));
                stockHistoryVO.setStock_in(rs.getInt("stock_in"));
                stockHistoryVO.setStock_out(rs.getInt("stock_out"));
                stockHistoryVO.setStock_qty(rs.getInt("stock_qty"));
                stockHistoryVO.setStock_date(rs.getTimestamp("stock_date"));
                stockHistoryList.add(stockHistoryVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return stockHistoryList;
    }
    
    
    
    

    // StockHistory List In 출력
    public List<StockHistoryVO> getStockHistoryListIn() {
        
        System.out.println("==> JDBC getStockHistoryList");
        
        List<StockHistoryVO> stockHistoryList = new ArrayList<StockHistoryVO>();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STOCKHISTORY_LIST_I);
            rs = stmt.executeQuery();
            while(rs.next()) {
                StockHistoryVO stockHistoryVO = new StockHistoryVO();
                stockHistoryVO.setStock_id(rs.getString("stock_id"));
                stockHistoryVO.setStock_name(rs.getString("stock_name"));
                stockHistoryVO.setStock_in(rs.getInt("stock_in"));
                stockHistoryVO.setStock_out(rs.getInt("stock_out"));
                stockHistoryVO.setStock_qty(rs.getInt("stock_qty"));
                stockHistoryVO.setStock_date(rs.getTimestamp("stock_date"));
                stockHistoryList.add(stockHistoryVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return stockHistoryList;
    }    
    
    // StockHistory List Out 출력
    public List<StockHistoryVO> getStockHistoryListOut() {
        
        System.out.println("==> JDBC getStockHistoryList");
        
        List<StockHistoryVO> stockHistoryList = new ArrayList<StockHistoryVO>();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STOCKHISTORY_LIST_O);
            rs = stmt.executeQuery();
            while(rs.next()) {
                StockHistoryVO stockHistoryVO = new StockHistoryVO();
                stockHistoryVO.setStock_id(rs.getString("stock_id"));
                stockHistoryVO.setStock_name(rs.getString("stock_name"));
                stockHistoryVO.setStock_in(rs.getInt("stock_in"));
                stockHistoryVO.setStock_out(rs.getInt("stock_out"));
                stockHistoryVO.setStock_qty(rs.getInt("stock_qty"));
                stockHistoryVO.setStock_date(rs.getTimestamp("stock_date"));
                stockHistoryList.add(stockHistoryVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return stockHistoryList;
    }    
    // StockListSearch
    public List<StockHistoryVO> getStockHistoryListSearch(String query) {

        System.out.println("==> JDBC getStockHistoryListSearch");

        List<StockHistoryVO> stockHistoryList = new ArrayList<StockHistoryVO>();


        try {
            conn = JDBCUtil.getConnection();
           
            stmt = conn.prepareStatement(STOCKHISTORY_LIST_ID);
            stmt.setString(1, "%"+query+"%");

            rs = stmt.executeQuery();
            while(rs.next()) {
                StockHistoryVO stockHistoryVO = new StockHistoryVO();
                stockHistoryVO.setStock_id(rs.getString("stock_id"));
                stockHistoryVO.setStock_name(rs.getString("stock_name"));
                stockHistoryVO.setStock_in(rs.getInt("stock_in"));
                stockHistoryVO.setStock_out(rs.getInt("stock_out"));
                stockHistoryVO.setStock_qty(rs.getInt("stock_qty"));
                stockHistoryVO.setStock_date(rs.getTimestamp("stock_date"));
                stockHistoryList.add(stockHistoryVO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return stockHistoryList;
    }




}
