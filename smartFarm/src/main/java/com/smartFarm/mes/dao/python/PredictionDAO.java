package com.smartFarm.mes.dao.python;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.python.PredictionVO;


@Repository("PredictionDAO")
public class PredictionDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	
	private final String PREDICTION_GET ="select AVG(pro_col) as pre_col from python where MONTH(pre_date) = MONTH(now())";
	

	// 2. get
	public PredictionVO getPredictionNow() {

		System.out.println("==> JDBC getPredictionNow");
		PredictionVO predictionVO = new PredictionVO();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PREDICTION_GET);
			rs = stmt.executeQuery();
			while(rs.next()) {
				predictionVO.setPre_col(rs.getInt("pre_col"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return predictionVO;

	}


}
