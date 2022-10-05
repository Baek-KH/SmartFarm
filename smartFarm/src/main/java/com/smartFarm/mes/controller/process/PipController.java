package com.smartFarm.mes.controller.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.employee.EmployeeDAO;
import com.smartFarm.mes.dao.process.PipDAO;
import com.smartFarm.mes.vo.employee.EmployeeVO;
import com.smartFarm.mes.vo.process.PipVO;


@Controller
@SessionAttributes("pip")
public class PipController {

	@Autowired
	PipDAO pipDAO;
	
	@RequestMapping("/getPip.do")
	public String getBoard(PipVO vo, PipDAO PipDAO, Model model) {
//		model.addAttribute("pip", PipDAO.getPip(vo));
		return "getPip.jsp";
	}

	@RequestMapping("/updatePip.do")
	public String updateBoard(@ModelAttribute("Pip") PipVO vo, PipDAO PipDAO) {
//		PipDAO.updateBoard(vo);
		return "getPipList.do";
	}

	@RequestMapping("/insertPip.do")
	public String insertBoard(PipVO vo, PipDAO PipDAO , Model model) {

		System.out.println("insertDO 진입");
		System.out.println(vo.toString());
		
		model.addAttribute("vo",vo);
//		pipDAO.insertBoard(vo);
		return "NewFile";
	}

	@RequestMapping("/deletePip.do")
	public String deleteBoard(PipVO vo, PipDAO PipDAO) {
//		EmployeeDAO.deleteBoard(vo);
		return "getPipList.do";
	}

}