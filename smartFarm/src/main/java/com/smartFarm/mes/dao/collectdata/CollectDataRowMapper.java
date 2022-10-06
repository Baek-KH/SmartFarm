package com.smartFarm.mes.dao.collectdata;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartFarm.mes.vo.collectdata.CollectDataVO;

public class CollectDataRowMapper implements RowMapper<CollectDataVO> {

	@Override
	public CollectDataVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CollectDataVO product = new CollectDataVO();
		product.setPro_qty(rs.getInt("PRO_QTY"));
		product.setPro_price(rs.getInt("PRO_PRICE"));
		product.setPro_date(rs.getString("PRO_DATE"));
		product.setTitle(rs.getString("TITLE"));
		product.setWriter(rs.getString("WRITER"));
		System.out.println("RowMapper VO 만들기" );
		return product;
	}

}
