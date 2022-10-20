package com.smartFarm.mes.controller.employee;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.commons.ScriptAlertUtils;
import com.smartFarm.mes.dao.employee.AttendenceDAO;
import com.smartFarm.mes.dao.employee.EmployeeDAO;
import com.smartFarm.mes.vo.employee.AttendenceVO;
import com.smartFarm.mes.vo.employee.EmployeeVO;

@Controller
@SessionAttributes("signIn")
public class LogController {


	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private AttendenceDAO attendenceDAO;

	// signIn
	@RequestMapping(value = "/signIn.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String signInCheck(HttpServletResponse res, HttpServletRequest req, EmployeeVO vo, Model model) throws Exception {

		System.out.println("==> signIn check");
		HttpSession session = req.getSession();
		session.invalidate();
		
		EmployeeVO employee = employeeDAO.getEmployee(vo.getEmp_id());
		PrintWriter out = new PrintWriter(System.out);
		session = req.getSession();
//		session 제한 시간 잠금
//		session.setMaxInactiveInterval(1800);
		
		
		if(employee.getEmp_id()!=null) {
			if(vo.getEmp_pw().equalsIgnoreCase(employee.getEmp_pw())) {
				model.addAttribute("signIn", employee);
				AttendenceVO attendenceVO = attendenceDAO.getAttendence(vo.getEmp_id());
				session.setAttribute("attendence", attendenceVO );
				model.addAttribute("attendence", attendenceVO);
			} else {
				ScriptAlertUtils.alertAndBackPage(res, "비밀번호가 일치하지 않습니다.");
			}
		} else {
			ScriptAlertUtils.alertAndBackPage(res, "아이디가 없습니다.");
		}
		return "redirect:/index";

	}


	@RequestMapping(value = "/signOut.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "signIn";

	}


}
