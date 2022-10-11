package com.smartFarm.mes.controller.line;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.line.StatusDAO;
import com.smartFarm.mes.vo.line.StatusVO;


@Controller
@SessionAttributes("status")

public class StatusController {


	// getStatus
	@RequestMapping(value = "/getStatus.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getStatus(@RequestParam(value = "line_id") String line_id,StatusDAO statusDAO, Model model) {

		System.out.println("getStatus 진입");
		StatusVO statusVO = statusDAO.getStatus(line_id);
		model.addAttribute("statusVO",statusVO );
		return "status";
	}

	// insert
	@RequestMapping(value = "/insertStatus.do", method = RequestMethod.POST)
	public String insertStatus(StatusVO vo, StatusDAO statusDAO , Model model) {

		System.out.println("insertStatus 진입");
		System.out.println(vo.toString());

		model.addAttribute("vo",vo);
		statusDAO.insertStatus(vo);
		return "redirect:/getStatusList.do";

	}


	// List
	@RequestMapping(value = "/getStatusList.do")
	public String getStatusList(StatusDAO statusDAO, Model model) {

		System.out.println("getStatusList 진입");

		List<StatusVO> statusList = statusDAO.getStatusList();
		model.addAttribute("StatusList", statusList);
		return "statusList";
	}

	// ListSearch
	@RequestMapping(value = "/getStatusListSearch.do")
	public String getStatusListSearch(
			@RequestParam(value="field", defaultValue="", required=false) String field,
			@RequestParam(value="query", defaultValue="", required=false) String query,
			StatusDAO statusDAO, Model model) {

		System.out.println("getStatusList 진입");

		List<StatusVO> statusList = new ArrayList<>();

		if (field != null & query !=null) {

			statusList = statusDAO.getStatusListSearch(field, query);
		} else  {
			statusList = statusDAO.getStatusList();
		}


		model.addAttribute("StatusList", statusList);
		return "statusList";
	}




}
