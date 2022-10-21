package com.smartFarm.mes.commons;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.smartFarm.mes.dao.line.LineDAO;
import com.smartFarm.mes.dao.line.StatusDAO;

@EnableScheduling
@Component
public class Scheduler {

	StatusDAO statusDAO = new StatusDAO();
	LineDAO lineDAO = new LineDAO();

//	@Scheduled(fixedRate = 5000)
//	public void setStatusData() {
//
//
//		int randLineNum = (int)((Math.random()*4)+1);
//		int randLineTemp = (int)((Math.random()*20)+10);
//		int randLineHum = (int)((Math.random()*70)+10);
//
//		StatusVO statusVO = new StatusVO();
//		statusVO.setStatus_line_id(Integer.toString(randLineNum));
//		statusVO.setStatus_temp(Integer.toString(randLineTemp));
//		statusVO.setStatus_hum(Integer.toString(randLineHum));
//		statusDAO.insertStatus(statusVO);
//
//
//	}
//
//	@Scheduled(fixedRate = 5000)
//	public void lineCheck() {
//
//		for(int i=1;i<=4;i++) {
//			String line_status = "";
//			StatusVO statusVO = statusDAO.getStatus(Integer.toString(i));
//			int status_temp = Integer.parseInt(statusVO.getStatus_temp());
//			int line_temp = Integer.parseInt(statusVO.getStatus_line_temp());
//			int status_hum = Integer.parseInt(statusVO.getStatus_hum());
//			int line_hum = Integer.parseInt(statusVO.getStatus_line_hum());
//
//			if(status_temp>line_temp+2) { line_status = line_status+"D_H "; };
//			if(status_temp<line_temp-2) { line_status = line_status+"D_L "; };
//			if(status_hum>line_hum+10) { line_status = line_status+"H_H"; };
//			if(status_hum<line_hum+10) { line_status = line_status+"H_L"; };
//
//
//			lineDAO.updateLineStatus(statusVO.getStatus_line_id(), line_status);
//		}
//
//	}




}
