package com.smartFarm.mes.controller.attendence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.employee.AttendenceDAO;
import com.smartFarm.mes.vo.employee.AttendenceVO;


@Controller
@SessionAttributes("attendence")
public class AttendenceController {

	
	// getAttendence
	@RequestMapping(value = "/getAttendence.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getAttendence(@RequestParam(value = "emp_id") String emp_id,AttendenceDAO attendenceDAO, Model model) {
		
		System.out.println("getAttendence 진입");
		AttendenceVO attendenceVO = attendenceDAO.getAttendence(emp_id);
		model.addAttribute("attendenceVO",attendenceVO );
		return "attendence";
	}
	
	// insert
	@RequestMapping(value = "/insertAttendence.do", method = RequestMethod.POST)
	public String insertAttendence(AttendenceVO vo, AttendenceDAO attendenceDAO , Model model) {
		
		System.out.println("insertAttendence 진입");
		model.addAttribute("vo",vo);
		attendenceDAO.insertAttendence(vo);
		return "redirect:/getAttendenceList.do";
	}
	
	// update
	@RequestMapping(value = "/updateAttendence.do" , method = RequestMethod.POST)
//	public String updateAttendence(@ModelAttribute("attendenceVO") AttendenceVO vo, AttendenceDAO AttendenceDAO, Model model) {
	public String updateAttendence(AttendenceVO vo, AttendenceDAO AttendenceDAO, Model model) {
	
		System.out.println("updateAttendence 진입");
		AttendenceDAO.updateAttendence(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getAttendenceList.do";
	}

	// delete
	@RequestMapping("/deleteAttendence.do")
	public String deleteAttendence(AttendenceVO vo, AttendenceDAO AttendenceDAO) {
		System.out.println("deleteAttendence 진입");
		System.out.println(vo.toString());
		
		AttendenceDAO.deleteAttendence(vo);
		return "redirect:/getAttendenceList.do";
	}
	
		
	
	// List
	@RequestMapping("/getAttendenceList.do")
	public String getAttendenceList(AttendenceDAO attendenceDAO, Model model) {

		System.out.println("getAttendenceList 진입");
		
		List<AttendenceVO> attendenceList = attendenceDAO.getAttendenceList();
		model.addAttribute("AttendenceList", attendenceList);
		return "attendenceList";
	}
	
	// ListSearch
	@RequestMapping(value = "/getAttendenceListSearch.do")
	public String getAttendenceListSearch(
			@RequestParam(value="field", defaultValue="", required=false) String field,
			@RequestParam(value="query", defaultValue="", required=false) String query,	   
			AttendenceDAO attendenceDAO, Model model) {
		
		System.out.println("getAttendenceList 진입");
		
		List<AttendenceVO> attendenceList = new ArrayList<AttendenceVO>();
				
		if (field != null & query !=null) {
			
			attendenceList = attendenceDAO.getAttendenceListSearch(field, query);
		} else  {
			attendenceList  =	attendenceDAO.getAttendenceList();
		}
		
		
		model.addAttribute("AttendenceList", attendenceList);
		return "attendenceList";
	}



}
