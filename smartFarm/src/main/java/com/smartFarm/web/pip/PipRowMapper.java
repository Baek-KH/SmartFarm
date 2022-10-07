package com.smartFarm.web.pip;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartFarm.mes.vo.pip.PipVO;

public class PipRowMapper implements RowMapper<PipVO> {

	@Override
	public PipVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PipVO pip = new PipVO();
		pip.setPip_no(rs.getInt("NO"));
		pip.setPip_name(rs.getString("NAME"));
		pip.setPip_period(rs.getString("DATE"));
		pip.setPip_category(rs.getString("CATEGORY"));
		pip.setPip_min_temp(rs.getString("MINTEMP"));
		pip.setPip_max_temp(rs.getString("MAXTEMP"));
		pip.setPip_min_hum(rs.getString("MINHUM"));
		pip.setPip_min_hum(rs.getString("MAXHUM"));	
		
		return pip;
	}

}
