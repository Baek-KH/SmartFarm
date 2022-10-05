package com.smartFarm.mes.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.product.ProductVO;



@Repository("productDAO")
public class ProductDAOSpring {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String PRODUCT_INSERT ="insert into product (pro_no, pro_id, pip_name, pro_qty, pro_price, pro_content) values((select nvl(max(pro_no), 0)+1 from product t1), ?,?,?,?,?)";
	private final String PRODUCT_UPDATE ="update product set pip_name=?, pro_qty=?, pro_price=?, pro_content=? where pro_id=?";
	private final String PRODUCT_DELETE ="delete from product where pro_id = ?";
	private final String PRODUCT_GET ="select * from product where pro_no=?";
	private final String PRODUCT_LIST ="select * from product order by pro_no desc";
	
	// CRUD기능메서드
	// 1. 글등록
//	public void insertProduct(ProductVO vo) {
//		System.out.println("222 ==> JDBC로 insertProduct() 메서드 호출!!");
//		jdbcTemplate.update(PRODUCT_INSERT, vo.getPro_id(), vo.getPip_name(), vo.getPro_qty(), vo.getPro_price(), vo.getPro_content());
//	}
	public void insertProduct(ProductVO vo) {
		System.out.println("==> JDBC로 insertProduct() 메서드 호출!!");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PRODUCT_INSERT);
			stmt.setString(1, vo.getPro_id());
			stmt.setString(2, vo.getPip_name());
			stmt.setInt(3, vo.getPro_qty());
			stmt.setInt(4, vo.getPro_price());
			stmt.setString(5, vo.getPro_content());
			System.out.println(vo.toString());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
}
	
	
	// 2. 글수정
//	public void updateProduct(ProductVO vo) {
//		System.out.println("222 ==> JDBC로 updateProduct() 메서드 호출!!");
//		jdbcTemplate.update(PRODUCT_UPDATE, vo.getPro_id(), vo.getPip_name(), vo.getPro_qty(), vo.getPro_price(), vo.getPro_content());
//	}
	public void updateProduct(ProductVO vo) {
		System.out.println("==> JDBC로 updateProduct() 메서드 호출!!");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PRODUCT_UPDATE);
			stmt.setString(1, vo.getPip_name());
			stmt.setInt(2, vo.getPro_qty());
			stmt.setInt(3, vo.getPro_price());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}		
	}
	
	
	// 3. 글삭제
//	public void deleteProduct(ProductVO vo) {
//		System.out.println("222 ==> JDBC로 deleteProduct() 메서드 호출!!");
//		jdbcTemplate.update(PRODUCT_DELETE, vo.getPro_id());
//	}
	public void deleteProduct(String pro_id) {
		System.out.println("==> JDBC로 deleteProduct() 메서드 호출!!");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PRODUCT_DELETE);
			stmt.setString(1, pro_id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}		
	}
	
	
	
	// 4. 상세조회
//	public ProductVO getProduct(ProductVO vo) {
//		System.out.println("222 ==> JDBC로 getProduct() 메서드 호출!!");
//		Object[] args = { vo.getPro_id() };				
//		return jdbcTemplate.queryForObject(PRODUCT_GET, args, new ProductRowMapper());
//	}
	public ProductVO getProduct(ProductVO vo) {
		System.out.println("==> JDBC로 getBoard() 메서드 호출!!");
		ProductVO product = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PRODUCT_GET);
			stmt.setInt(1, vo.getPro_no());
			rs = stmt.executeQuery();
			if(rs.next()) {
				
				product = new ProductVO();
				product.setPro_no(rs.getInt("PRO_NO"));
				product.setPro_id(rs.getString("PRO_ID"));
				product.setPip_name(rs.getString("PIP_NAME"));
				product.setPro_qty(rs.getInt("PRO_QTY"));
				product.setPro_price(rs.getInt("PRO_PRICE"));
				product.setPro_content(rs.getString("PRO_CONTENT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}		
		return product;
	}
	
	
	
	// 5. 글목록
//	public List<ProductVO> getProductList(ProductVO vo) {
//		System.out.println("222 ==> JDBC로 getProductList() 메서드 호출!!");				
//		return jdbcTemplate.query(PRODUCT_LIST, new ProductRowMapper());
//	}
	public List<ProductVO> getProductList(ProductVO vo) {
		System.out.println("==> JDBC로 getProductList() 메서드 호출!!");
		List<ProductVO> productList = new ArrayList<ProductVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PRODUCT_LIST);
			rs = stmt.executeQuery();
//			System.out.println(rs.next());
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPro_no(rs.getInt("PRO_NO"));
				product.setPro_id(rs.getString("PRO_ID"));
				product.setPip_name(rs.getString("PIP_NAME"));
				product.setPro_qty(rs.getInt("PRO_QTY"));
				product.setPro_price(rs.getInt("PRO_PRICE"));
				product.setPro_content(rs.getString("PRO_CONTENT"));
				productList.add(product);
				System.out.println(rs.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}			
		return productList;
	}

}
