package com.smartFarm.mes.controller.employee;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.employee.EmployeeDAO;
import com.smartFarm.mes.vo.employee.EmployeeVO;


@Controller
@SessionAttributes("employee")
public class employeeController {

	
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

	@RequestMapping(value = "/insertEmployee.do", method = RequestMethod.POST)
	public String insertEmployee(EmployeeVO vo, EmployeeDAO employeeDAO , Model model) {

		System.out.println("insertDO 진입");
		
		model.addAttribute("vo",vo);
		employeeDAO.insertEmployee(vo);
		return "/deleteEmployee.do";
	}

	@RequestMapping(value = "/getEmployeeList.do")
	public String getEmployeeList(EmployeeDAO employeeDAO, Model model) {

		System.out.println("getEmployeeList 진입");
		
		List<EmployeeVO> employeeList = employeeDAO.getEmployeeList();
		model.addAttribute("EmployeeList", employeeList);
		return "employeeList";
	}
	
	@RequestMapping("/deleteEmployee.do")
	public String deleteBoard(EmployeeVO vo, EmployeeDAO EmployeeDAO) {
//		EmployeeDAO.deleteBoard(vo);
		return "getBoardList.do";
	}



}
