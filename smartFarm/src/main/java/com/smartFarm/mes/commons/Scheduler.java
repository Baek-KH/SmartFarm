package com.smartFarm.mes.commons;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.smartFarm.mes.dao.line.LineDAO;
import com.smartFarm.mes.dao.line.StatusDAO;
import com.smartFarm.mes.dao.pip.PipDAO;
import com.smartFarm.mes.dao.tray.TrayDAO;

@EnableScheduling
@Component
public class Scheduler {

	StatusDAO statusDAO = new StatusDAO();
	LineDAO lineDAO = new LineDAO();
	TrayDAO trayDAO = new TrayDAO();
	PipDAO pipDAO = new PipDAO();

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
//	@Scheduled(cron = "0 0 06 * * *") // 매일 06시 수행
//	@Scheduled(fixedRate = 60000)	// 테스트용 1분에 한번씩	
//	public void trayInsertPerDay() {
//		
//		// 라인 설정정보를 바탕으로 pip가 세팅된 tary를 라인에 insert
//		
//		List<LineVO> lineList = new ArrayList<>();
//		lineList = lineDAO.getLineList();
//		
//		for(LineVO vo : lineList) {
//			TrayVO trayVO = new TrayVO();
//			String line_id = vo.getLine_id();
//			String line_pip = vo.getLine_pip();
//			PipVO pipVO = pipDAO.getPip(line_pip);
//			trayVO.setLine_id(line_id);
//			trayVO.setPip_name(line_pip);
//			trayVO.setPip_qty("50");
//			trayVO.setPip_period(pipVO.getPip_period());
//			
//			
//			trayDAO.insertTray(trayVO);
//		}
//		
		
		
		
		
		
//	}



}
