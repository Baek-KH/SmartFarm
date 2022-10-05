package com.smartFarm.mes.controller.employee;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.commons.ScriptAlertUtils;
import com.smartFarm.mes.dao.employee.EmployeeDAO;
import com.smartFarm.mes.vo.employee.EmployeeVO;

@Controller
@SessionAttributes("Employee")
public class logController {
	
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	// signIn 
	@RequestMapping(value = "/signIn.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String signInCheck(HttpServletResponse res, EmployeeVO vo, Model model) throws Exception {
		
		System.out.println("==> signIn check");
		EmployeeVO employee = employeeDAO.getEmployee(vo.getEmp_id());
		PrintWriter out = new PrintWriter(System.out);
		
		if(employee.getEmp_id()!=null) {
			if(vo.getEmp_pw().equalsIgnoreCase(employee.getEmp_pw())) {
				model.addAttribute("singIn", employee);				
			} else {
				ScriptAlertUtils.alertAndBackPage(res, "비밀번호가 일치하지 않습니다.");
			}
		} else {
			ScriptAlertUtils.alertAndBackPage(res, "아이디가 없습니다.");
		}
		return "index";
		
	}

	
	@RequestMapping(value = "/signOut.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
		
	}
	
	
}
