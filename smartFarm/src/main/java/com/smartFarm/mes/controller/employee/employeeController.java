package com.smartFarm.mes.controller.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.employee.EmployeeDAO;
import com.smartFarm.mes.vo.employee.EmployeeVO;


@Controller
@SessionAttributes("employee")
public class EmployeeController {


	// getEmployee
	@RequestMapping(value = "/getEmployee.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getEmployee(@RequestParam(value = "emp_id") String emp_id,EmployeeDAO employeeDAO, Model model) {

		System.out.println("getEmployee 진입");
		EmployeeVO employeeVO = employeeDAO.getEmployee(emp_id);
		model.addAttribute("employeeVO",employeeVO );
		return "employee";
	}

	// insert
	@RequestMapping(value = "/insertEmployee.do", method = RequestMethod.POST)
	public String insertEmployee(EmployeeVO vo, EmployeeDAO employeeDAO , Model model) {

		System.out.println("insertEmployee 진입");
		model.addAttribute("vo",vo);
		employeeDAO.insertEmployee(vo);
		return "redirect:/getEmployeeList.do";
	}

	// update
	@RequestMapping(value = "/updateEmployee.do" , method = RequestMethod.POST)
//	public String updateEmployee(@ModelAttribute("employeeVO") EmployeeVO vo, EmployeeDAO EmployeeDAO, Model model) {
	public String updateEmployee(EmployeeVO vo, EmployeeDAO EmployeeDAO, Model model) {

		System.out.println("updateEmployee 진입");
		EmployeeDAO.updateEmployee(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getEmployeeList.do";
	}

	// delete
	@RequestMapping("/deleteEmployee.do")
	public String deleteEmployee(EmployeeVO vo, EmployeeDAO EmployeeDAO) {
		System.out.println("deleteEmployee 진입");
		System.out.println(vo.toString());

		EmployeeDAO.deleteEmployee(vo);
		return "redirect:/getEmployeeList.do";
	}



	// List
	@RequestMapping("/getEmployeeList.do")
	public String getEmployeeList(EmployeeDAO employeeDAO, Model model) {

		System.out.println("getEmployeeList 진입");

		List<EmployeeVO> employeeList = employeeDAO.getEmployeeList();
		model.addAttribute("EmployeeList", employeeList);
		return "employeeList";
	}

	// ListSearch
	@RequestMapping(value = "/getEmployeeListSearch.do")
	public String getEmployeeListSearch(
			@RequestParam(value="field", defaultValue="", required=false) String field,
			@RequestParam(value="query", defaultValue="", required=false) String query,
			EmployeeDAO employeeDAO, Model model) {

		System.out.println("getEmployeeList 진입");

		List<EmployeeVO> employeeList = new ArrayList<>();

		if (field != null & query !=null) {

			employeeList = employeeDAO.getEmployeeListSearch(field, query);
		} else  {
			employeeList  =	employeeDAO.getEmployeeList();
		}


		model.addAttribute("EmployeeList", employeeList);
		return "employeeList";
	}



}
