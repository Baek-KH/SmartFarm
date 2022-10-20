package com.smartFarm.mes.commons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.smartFarm.mes.dao.line.LineDAO;
import com.smartFarm.mes.dao.line.StatusDAO;
import com.smartFarm.mes.dao.pip.PipDAO;
import com.smartFarm.mes.dao.tray.TrayDAO;
import com.smartFarm.mes.vo.line.LineVO;
import com.smartFarm.mes.vo.line.StatusVO;
import com.smartFarm.mes.vo.pip.PipVO;
import com.smartFarm.mes.vo.tray.TrayVO;

@EnableScheduling
@Component
public class Scheduler {

	StatusDAO statusDAO = new StatusDAO();
	LineDAO lineDAO = new LineDAO();
	TrayDAO trayDAO = new TrayDAO();
	PipDAO pipDAO = new PipDAO();

	@Scheduled(fixedRate = 30000)
	public void setStatusData() {

		int randLineNum = (int) ((Math.random() * 4) + 1);
		int randLineTemp = (int) ((Math.random() * 20) + 10);
		int randLineHum = (int) ((Math.random() * 70) + 10);

		StatusVO statusVO = new StatusVO();
		statusVO.setStatus_line_id(Integer.toString(randLineNum));
		statusVO.setStatus_temp(Integer.toString(randLineTemp));
		statusVO.setStatus_hum(Integer.toString(randLineHum));
		statusDAO.insertStatus(statusVO);

	}

	@Scheduled(fixedRate = 30000)
	public void lineCheck() {

		for (int i = 1; i <= 4; i++) {
			
			StatusVO statusVO = statusDAO.getStatus(Integer.toString(i));
			
			lineDAO.updateLineStatus(statusVO.getStatus_line_id(), statusVO.getStatus_error_code());
		}

	}

//	@Scheduled(cron = "0 0 06 * * *") // 매일 06시 수행
	@Scheduled(fixedRate = 600000)	// 테스트용 1분에 한번씩	
	public void trayInsertPerDay() {
		
		// 라인 설정정보를 바탕으로 pip가 세팅된 tary를 라인에 insert
		
		List<LineVO> lineList = new ArrayList<>();
		lineList = lineDAO.getLineList();
		
		for(LineVO vo : lineList) {
			TrayVO trayVO = new TrayVO();
			String line_id = vo.getLine_id();
			String line_pip = vo.getLine_pip();
			PipVO pipVO = pipDAO.getPip(line_pip);
			trayVO.setLine_id(line_id);
			trayVO.setPip_name(line_pip);
			trayVO.setPip_qty("50");
			trayVO.setPip_period(pipVO.getPip_period());
			
			
			trayDAO.insertTray(trayVO);
		}

	}
	@Scheduled(fixedRate = 600000)	// 테스트용 1분에 한번씩	
	public void trayUpdatePerDay() {
		// end_date 가 현재날짜보다 뒤에있는 생육중인 Tray를 random 값으로 매일 성장
	
		// Tray 생육정보를 매일 update
		
		
		List<TrayVO> trayList = new ArrayList<>();
		trayList = trayDAO.getTrayListUnfinished();
		
		for(TrayVO vo : trayList) {
			
			double rand_growth = Math.random() ;
			double tray_growth = Double.parseDouble(vo.getTray_growth())+rand_growth;
			vo.setTray_growth(String.format("%.2f", tray_growth));
			trayDAO.updateTray(vo);
		}
		
	}
	


}
