package com.smartFarm.mes.dao.collectdata;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.collectdata.CollectDataVO;
import com.smartFarm.mes.vo.product.ProductVO;



@Repository("collectDataDAO")
public class CollectDataDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	
	private final String PRODUCT_INSERT ="insert into test (test_no, pro_qty, pro_price, pro_date, title, writer) values((select nvl(max(pro_no), 0)+1 from collectData t1), ?,?,?,?,?)";
	private final String PRODUCT_GET ="select * from test where test_no=?";
//	private final String PRODUCT_LIST ="select * from collectData order by pro_no desc";
	
	// CRUD기능메서드
	// 1. 글등록
//	public void insertCollectData(CollectDataVO vo) {
//		System.out.println("222 ==> JDBC로 insertCollectData() 메서드 호출!!");
//		jdbcTemplate.update(PRODUCT_INSERT, vo.getPro_id(), vo.getPip_name(), vo.getPro_qty(), vo.getPro_price(), vo.getPro_content());
//	}
	public void getCollectData(ProductVO vo ) {
		System.out.println("==> JDBC로 insertCollectData() 메서드 호출!!");
		
		    Date nowDate = new Date();
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd.MM"); 
		           //원하는 데이터 포맷 지정
		    String strNowDate = simpleDateFormat.format(nowDate); 
		           //지정한 포맷으로 변환 
		    System.out.println("포맷 지정 후 : " + strNowDate);
		
		
		    
		    try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PRODUCT_INSERT);
			stmt.setInt(1, vo.getPro_qty());
			stmt.setInt(2, vo.getPro_price());
			stmt.setString(3, strNowDate);
			stmt.setString(4, vo.getTitle());
			stmt.setString(5, vo.getWriter());
			System.out.println(vo.toString());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}

		System.out.println("==> JDBC로 getCollectData() 메서드 호출!!");
		CollectDataVO collectData = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PRODUCT_GET);
			stmt.setInt(1, vo.getTest_no());
			rs = stmt.executeQuery();
			if(rs.next()) {
				
				collectData = new CollectDataVO();
				collectData.setPro_qty(rs.getInt("PRO_QTY"));
				collectData.setPro_price(rs.getInt("PRO_PRICE"));
				collectData.setPro_date(rs.getString("PRO_DATE"));
				collectData.setTitle(rs.getString("TITLE"));
				collectData.setWriter(rs.getString("WRITER"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}		
		return collectData;



}
	
	
	
	
	// 4. 상세조회
//	public CollectDataVO getCollectData(CollectDataVO vo) {
//		System.out.println("222 ==> JDBC로 getCollectData() 메서드 호출!!");
//		Object[] args = { vo.getPro_id() };				
//		return jdbcTemplate.queryForObject(PRODUCT_GET, args, new CollectDataRowMapper());
//	}
// 	public CollectDataVO getCollectData(CollectDataVO vo) {
// 		System.out.println("==> JDBC로 getBoard() 메서드 호출!!");
// 		CollectDataVO collectData = null;
		
// 		try {
// 			conn = JDBCUtil.getConnection();
// 			stmt = conn.prepareStatement(PRODUCT_GET);
// 			stmt.setInt(1, vo.getPro_no());
// 			rs = stmt.executeQuery();
// 			if(rs.next()) {
				
// 				collectData = new CollectDataVO();
// 				collectData.setPro_no(rs.getInt("PRO_NO"));
// 				collectData.setPro_id(rs.getString("PRO_ID"));
// 				collectData.setPip_name(rs.getString("PIP_NAME"));
// 				collectData.setPro_qty(rs.getInt("PRO_QTY"));
// 				collectData.setPro_price(rs.getInt("PRO_PRICE"));
// 				collectData.setPro_content(rs.getString("PRO_CONTENT"));
// 				collectData.setPro_date(rs.getString("PRO_DATE"));
// 			}
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		} finally {
// 			JDBCUtil.close(rs, stmt, conn);
// 		}		
// 		return collectData;
// 	}
	
	
	
// 	// 5. 글목록
// //	public List<CollectDataVO> getCollectDataList(CollectDataVO vo) {
// //		System.out.println("222 ==> JDBC로 getCollectDataList() 메서드 호출!!");				
// //		return jdbcTemplate.query(PRODUCT_LIST, new CollectDataRowMapper());
// //	}
// 	public List<CollectDataVO> getCollectDataList(CollectDataVO vo) {
// 		System.out.println("==> JDBC로 getCollectDataList() 메서드 호출!!");
// 		List<CollectDataVO> collectDataList = new ArrayList<CollectDataVO>();
		
// 		try {
// 			conn = JDBCUtil.getConnection();
// 			stmt = conn.prepareStatement(PRODUCT_LIST);
// 			rs = stmt.executeQuery();
// //			System.out.println(rs.next());
// 			while(rs.next()) {
// 				CollectDataVO collectData = new CollectDataVO();
// 				collectData.setPro_no(rs.getInt("PRO_NO"));
// 				collectData.setPro_id(rs.getString("PRO_ID"));
// 				collectData.setPip_name(rs.getString("PIP_NAME"));
// 				collectData.setPro_qty(rs.getInt("PRO_QTY"));
// 				collectData.setPro_price(rs.getInt("PRO_PRICE"));
// 				collectData.setPro_content(rs.getString("PRO_CONTENT"));
// 				collectData.setPro_date(rs.getString("PRO_DATE"));
// 				collectDataList.add(collectData);
// 				System.out.println(rs.toString());
// 			}
			
// 			stmt = conn.prepareStatement(PRODUCT_DELETE);


// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		} finally {
// 			JDBCUtil.close(rs, stmt, conn);
// 		}			
// 		return collectDataList;
// 	}

	
}
