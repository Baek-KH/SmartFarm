package com.smartFarm.mes.dao.buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.buyer.BuyerVO;
import com.smartFarm.mes.vo.buyer.OrdersVO;

@Repository("OrdersDAO")
public class OrdersDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// name search 까지 전부 완
	

	private final String ORDERS_INSERT ="insert into Orders values (?,?,?,?, now() , DATE_ADD(now(), INTERVAL ? DAY))";
	private final String ORDERS_GET ="select * from Orders where orders_id = ? ";
	private final String ORDERS_UPDATE ="update Orders set  buyer_id = ? , orders_product=? ,orders_qty=?  where orders_id= ?";
	private final String ORDERS_DELETE = "delete from orders where orders_id = ? ";
	private final String ORDERS_LIST ="select * from Orders ORDER BY orders_date desc";
	private final String ORDERS_LIST_N ="select * from Orders where buyer_id like ? ORDER BY orders_date desc";




	// 1. insert
	public void insertOrders(OrdersVO vo) {

		System.out.println("==> JDBC Orders insert");

		BuyerDAO buyerDAO = new BuyerDAO();
		BuyerVO	buyerVO = buyerDAO.getBuyer(vo.getBuyer_id());
		
		String getOrders_NO = "select orders_id from orders ORDER BY CAST(orders_id AS SIGNED) DESC LIMIT 1";
		
		
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(getOrders_NO);
			rs = stmt.executeQuery();
			if(rs.next()) {
				vo.setOrders_id((Integer.parseInt(rs.getString("orders_id"))+1)+"");
			} else {
				vo.setOrders_id("1");
			}

			stmt = conn.prepareStatement(ORDERS_INSERT);
			stmt.setString(1, vo.getOrders_id());
			stmt.setString(2, vo.getBuyer_id());
			stmt.setString(3, vo.getOrders_product());
			stmt.setString(4, vo.getOrders_qty());
			stmt.setInt(5, Integer.parseInt(buyerVO.getBuyer_date()));
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}

	// 4. delete
			public void deleteOrders(OrdersVO vo) {

				System.out.println("==> JDBC deleteOrders");
				
				try {
					conn = JDBCUtil.getConnection();
					stmt = conn.prepareStatement(ORDERS_DELETE);
					stmt.setString(1, vo.getOrders_id());
					stmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(null, stmt, conn);
				}
			}
	
	// 2. getOrders
	public OrdersVO getOrders(String orders_id) {

		System.out.println("==> JDBC getOrders");
		OrdersVO ordersVO = new OrdersVO();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ORDERS_GET);
			stmt.setString(1, orders_id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ordersVO.setOrders_id(rs.getString("orders_id"));
				ordersVO.setBuyer_id(rs.getString("buyer_id"));
				ordersVO.setOrders_product(rs.getString("orders_product"));
				ordersVO.setOrders_qty(rs.getString("orders_qty"));
				ordersVO.setOrders_date(rs.getTimestamp("orders_date"));
				ordersVO.setOrders_arr_date(rs.getTimestamp("orders_arr_date"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return ordersVO;

	}
	
	
	// 3. update
	public void updateOrders(OrdersVO vo) {

		System.out.println("==> JDBC Orders update");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ORDERS_UPDATE);
			stmt.setString(1, vo.getBuyer_id());
			stmt.setString(2, vo.getOrders_product());
			stmt.setString(3, vo.getOrders_qty());
			stmt.setString(4, vo.getOrders_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}
	

	


// Orders List
	public List<OrdersVO> getOrdersList() {

			System.out.println("==> JDBC getOrdersList");


			List<OrdersVO> ordersList = new ArrayList<>();


			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(ORDERS_LIST);
				rs = stmt.executeQuery();
				while(rs.next()) {
					OrdersVO ordersVO = new OrdersVO();
					ordersVO.setOrders_id(rs.getString("orders_id"));
					ordersVO.setBuyer_id(rs.getString("buyer_id"));
					ordersVO.setOrders_product(rs.getString("orders_product"));
					ordersVO.setOrders_qty(rs.getString("orders_qty"));
					ordersVO.setOrders_date(rs.getTimestamp("orders_date"));
					ordersVO.setOrders_arr_date(rs.getTimestamp("orders_arr_date"));
					ordersList.add(ordersVO);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return ordersList;
		}



		// Orders List Search
		public List<OrdersVO> getOrdersListSearch(String query) {

			System.out.println("==> JDBC getOrdersListSearch");

			List<OrdersVO> ordersList = new ArrayList<>();
			
			BuyerDAO buyerDAO = new BuyerDAO();
			BuyerVO	buyerVO = buyerDAO.getBuyerName(query);
			

			try {
				conn = JDBCUtil.getConnection();
				
				stmt = conn.prepareStatement(ORDERS_LIST_N);
				stmt.setString(1, "%"+buyerVO.getBuyer_id()+"%");

				rs = stmt.executeQuery();
				while(rs.next()) {
					OrdersVO ordersVO = new OrdersVO();
					ordersVO.setOrders_id(rs.getString("orders_id"));
					ordersVO.setBuyer_id(rs.getString("buyer_id"));
					ordersVO.setOrders_product(rs.getString("orders_product"));
					ordersVO.setOrders_qty(rs.getString("orders_qty"));
					ordersVO.setOrders_date(rs.getTimestamp("orders_date"));
					ordersVO.setOrders_arr_date(rs.getTimestamp("orders_arr_date"));
					ordersList.add(ordersVO);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return ordersList;
		}




}
