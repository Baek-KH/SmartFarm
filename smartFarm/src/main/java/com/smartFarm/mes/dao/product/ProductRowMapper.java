package com.smartFarm.mes.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartFarm.mes.vo.product.ProductVO;

public class ProductRowMapper implements RowMapper<ProductVO> {

	@Override
	public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductVO product = new ProductVO();
		product.setPro_no(rs.getInt("PRO_NO"));
		product.setPro_id(rs.getString("PRO_ID"));
		product.setPip_name(rs.getString("PIP_NAME"));
		product.setPro_qty(rs.getInt("PRO_QTY"));
		product.setPro_price(rs.getInt("PRO_PRICE"));
		product.setPro_content(rs.getString("PRO_CONTENT"));
		product.setPro_date(rs.getString("PRO_DATE"));
		System.out.println("RowMapper VO 만들기" );
		return product;
	}

}
