package com.smartFarm.mes.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.employee.EmployeeDAO;
import com.smartFarm.mes.vo.employee.EmployeeVO;


@Controller
@SessionAttributes("employee")
public class employeeController {



//	@ModelAttribute("conditionMap")
//	public Map<String, String> searchConditionMap(){
//		Map<String,	String> conditionMap = new HashMap()<>();
//		conditionMap.put("����", "TITLE");
//		conditionMap.put("����", "CONTENT");
//		conditionMap.put("�ۼ���", "WRITER");
//
//		return conditionMap;
//
//	}

//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(
//			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
//			EmployeeVO vo, EmployeeDAO EmployeeDAO, Model model) {
//
//
//		model.addAttribute("boardList", EmployeeDAO.getBoardList(vo));
//		return "getBoardList.jsp";
//	}

//
	@RequestMapping("/getEmployee.do")
	public String getBoard(EmployeeVO vo, EmployeeDAO EmployeeDAO, Model model) {
//		model.addAttribute("board", EmployeeDAO.getBoard(vo));
		return "getBoard.jsp";
	}

	@RequestMapping("/updateEmployee.do")
	public String updateBoard(@ModelAttribute("employee") EmployeeVO vo, EmployeeDAO EmployeeDAO) {
//		EmployeeDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/insertEmployee.do")
	public String insertBoard(EmployeeVO vo, EmployeeDAO EmployeeDAO , Model model) {

		System.out.println("insertDO 진입");
		System.out.println(vo.toString());
		
		model.addAttribute("vo",vo);
//		EmployeeDAO.insertBoard(vo);
		return "NewFile";
	}

	@RequestMapping("/deleteEmployee.do")
	public String deleteBoard(EmployeeVO vo, EmployeeDAO EmployeeDAO) {
//		EmployeeDAO.deleteBoard(vo);
		return "getBoardList.do";
	}



}
