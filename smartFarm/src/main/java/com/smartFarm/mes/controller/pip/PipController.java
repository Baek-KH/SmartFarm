package com.smartFarm.mes.controller.pip;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.smartFarm.mes.dao.pip.PipDAO;
import com.smartFarm.mes.vo.pip.PipVO;


@Controller
@SessionAttributes("pip")
public class PipController {
		
	// 1. get
	@RequestMapping(value = "/getPipList.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getPip(@RequestParam(value = "pip_name") String pip_name, PipDAO pipDAO, Model model) {
		
		System.out.println("> 1컨트롤");
		
		PipVO pipVO = pipDAO.getPip(pip_name);
		model.addAttribute("pipVO", pipVO);
		return "pip";
	}
		
	// 2. insert
	@RequestMapping(value = "/insertPip.do", method = RequestMethod.POST)
	public String insertPip(PipVO vo, PipDAO pipDAO , Model model) {
		
		System.out.println("> 2컨트롤");
		
		model.addAttribute("vo",vo);
		pipDAO.insertPip(vo);
		return "redirect:/getPipList.do";
	}
	
	// 3. update
	@RequestMapping(value = "/updatePip.do" , method = RequestMethod.POST)
	public String updatePip(PipVO vo, PipDAO PipDAO, Model model) {
	
		System.out.println("> 3컨트롤");
		
		PipDAO.updatePip(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getPipList.do";
	}
	
	//4. delete
	@RequestMapping("/deletePip.do") 
	public String deletePip(PipVO vo, PipDAO pipDAO) {
		
		System.out.println("> 4컨트롤");
		System.out.println(vo.toString());
		
		pipDAO.deletePip(vo);
		return "getPipList.do";
	}	
	
	// 5. List
	@RequestMapping("/getPipList.do")
	public String getPipList(PipDAO pipDAO, Model model) {

		System.out.println("> 5컨트롤");
		
		List<PipVO> pipList = pipDAO.getPipList();
		model.addAttribute("PipList", pipList);
		return "pipList";
	}
	
//	// 6. 검색조건설정
//	@ModelAttribute("conditionMap")
//	public Map<String, String> searchConditionMap(){
//		Map<String,	String> conditionMap = new HashMap<>();
//		conditionMap.put("작물번호", "PIP_NO");
//		conditionMap.put("작물이름", "PIP_NAME");
//		
//		return conditionMap;
//	}
	
	// 6. Search
	@RequestMapping(value = "/getPipListSearch.do")
	public String getPipListSearch(
			@RequestParam(value="field", defaultValue="", required=false) String field,
			@RequestParam(value="query", defaultValue="", required=false) String query,	   
			PipDAO pipDAO, Model model) {
		
		System.out.println("> 6컨트롤");
		
		List<PipVO> pipList = new ArrayList<PipVO>();
				
		if (field != null & query !=null) {
			
			pipList = pipDAO.getPipListSearch(field, query);
		} else  {
			pipList  =	pipDAO.getPipList();
		}
		
		
		model.addAttribute("PipList", pipList);
		return "pipList";
	}
	
}