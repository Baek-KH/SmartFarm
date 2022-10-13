package com.smartFarm.mes.controller.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.commons.ScriptAlertUtils;
import com.smartFarm.mes.dao.employee.AttendenceDAO;
import com.smartFarm.mes.vo.employee.AttendenceVO;
import com.smartFarm.mes.vo.employee.EmployeeVO;


@Controller
@SessionAttributes("attendence")
public class AttendenceController {
	// regular
	// 출근, 퇴근, 조회, 검색



	// getAttendence
	@RequestMapping(value = "/getAttendence.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getAttendence(HttpServletRequest req,AttendenceDAO attendenceDAO, Model model) {

		System.out.println("getAttendence 진입");

		HttpSession session = req.getSession();
		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("signIn");

		AttendenceVO attendenceVO = attendenceDAO.getAttendence(employeeVO.getEmp_id());
		model.addAttribute("attendence",attendenceVO );
		return "attendence";
	}

	// insert - 출근등록
	@RequestMapping(value = "/insertAttendence.do", method = RequestMethod.GET)
	public String insertAttendence(HttpServletRequest req, AttendenceDAO attendenceDAO , Model model) {

		System.out.println("insertAttendence 진입");

		HttpSession session = req.getSession();
		EmployeeVO vo = (EmployeeVO) session.getAttribute("signIn");

		AttendenceVO attendenceVO = new AttendenceVO();
		attendenceVO.setEmp_id(vo.getEmp_id());
		attendenceVO.setEmp_name(vo.getEmp_name());		
		attendenceVO.setAtt_work_on(new Date());
		attendenceVO.setAtt_work_date(new Date());

		attendenceDAO.insertAttendence(attendenceVO);

		model.addAttribute("attendence", attendenceVO);

		return "redirect:/getAttendenceList.do";
	}

	// List - regular
	@RequestMapping("/getAttendenceList.do")
	public String getAttendenceList(HttpServletRequest req, AttendenceDAO attendenceDAO, Model model) {

		System.out.println("getAttendenceList 진입");

		HttpSession session = req.getSession();
		EmployeeVO vo = (EmployeeVO) session.getAttribute("signIn");

		List<AttendenceVO> attendenceList = attendenceDAO.getAttendenceList(vo);
		model.addAttribute("AttendenceList", attendenceList);
		return "myPage";
	}

	// ListSearch
		@RequestMapping(value = "/getAttendenceListSearch.do")
		public String getAttendenceListSearch(
				@RequestParam(value="field", defaultValue="", required=false) String field,
				@RequestParam(value="query", defaultValue="", required=false) String query,
				HttpServletRequest req,
				AttendenceDAO attendenceDAO, Model model) {

			System.out.println("getAttendenceList 진입");

			HttpSession session = req.getSession();
			EmployeeVO vo = (EmployeeVO) session.getAttribute("signIn");

			List<AttendenceVO> attendenceList = new ArrayList<>();

			if (field != null & query !=null) {

				attendenceList = attendenceDAO.getAttendenceListSearch(vo,field, query);
			} else  {
				attendenceList = attendenceDAO.getAttendenceList(vo);
			}


			model.addAttribute("AttendenceList", attendenceList);
			return "myPage";
		}

	// update - 퇴근
	@RequestMapping(value = "/updateAttendence.do" )
	public String updateAttendence(HttpServletRequest req, AttendenceDAO AttendenceDAO, Model model) {

		System.out.println("updateAttendence 진입");

		HttpSession session = req.getSession();
		AttendenceVO vo = (AttendenceVO) session.getAttribute("attendence");
		System.out.println(vo.toString());
		vo.setAtt_work_off(new Date());
		AttendenceDAO.updateAttendenceOff(vo);
		model.addAttribute("attendence",vo);

		return "redirect:/getAttendenceList.do";
	}


	// admin
		// 사원 근태 조회
		// 사원 근태 검색
		// 사번, 년, 월, 일
		// 사원 근태 수정

	// List - admin
		@RequestMapping("/getAttendenceListAdmin.do")
		public String getAttendenceListAdmin(HttpServletRequest req,HttpServletResponse res,
			AttendenceDAO attendenceDAO, Model model) throws IOException {

			System.out.println("getAttendenceList 진입");

			HttpSession session = req.getSession();
			EmployeeVO vo = (EmployeeVO) session.getAttribute("signIn");

			if(vo.getEmp_admin().equals("admin")) {
				List<AttendenceVO> attendenceList = attendenceDAO.getAttendenceListAdmin();
				model.addAttribute("AttendenceList", attendenceList);
			} else {
				ScriptAlertUtils.alertAndBackPage(res, "관리자 권한이 필요합니다.");
			}

			return "attendenceListAdmin";
		}

	// ListSearch
		@RequestMapping(value = "/getAttendenceListSearchAdmin.do")
		public String getAttendenceListSearchAdmin(
			@RequestParam(value="field", defaultValue="", required=false) String field,
			@RequestParam(value="query", defaultValue="", required=false) String query,
			HttpServletRequest req,HttpServletResponse res,
			AttendenceDAO attendenceDAO, Model model) throws IOException {

			System.out.println("getAttendenceList 진입");

			HttpSession session = req.getSession();
			EmployeeVO vo = (EmployeeVO) session.getAttribute("signIn");

			if(vo.getEmp_admin().equals("admin")) {
				List<AttendenceVO> attendenceList = new ArrayList<>();

				if (field != null & query !=null) {

					attendenceList = attendenceDAO.getAttendenceListSearchAdmin(field, query);
				} else  {
					attendenceList = attendenceDAO.getAttendenceListAdmin();
				}
				model.addAttribute("AttendenceList", attendenceList);
			} else {
				ScriptAlertUtils.alertAndBackPage(res, "관리자 권한이 필요합니다.");
			}

				return "attendenceList";
			}

		// update - admin
		@RequestMapping(value = "/updateAttendenceAdmin.do" , method = RequestMethod.POST)
		public String updateAttendenceAdmin(HttpServletRequest req, HttpServletResponse res,
				AttendenceVO attendenceVO ,AttendenceDAO AttendenceDAO, Model model) throws IOException {

			System.out.println("updateAttendence 진입");

			HttpSession session = req.getSession();
			EmployeeVO vo = (EmployeeVO) session.getAttribute("signIn");

			if(vo.getEmp_admin().equals("admin")) {
				AttendenceDAO.updateAttendenceAdmin(attendenceVO);

			} else {
				ScriptAlertUtils.alertAndBackPage(res, "관리자 권한이 필요합니다.");
			}


			return "redirect:/getAttendenceListAdmin.do";
		}
}
