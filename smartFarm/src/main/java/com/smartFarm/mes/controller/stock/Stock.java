package com.smartFarm.mes.controller.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("stock")
public class Stock {



//	// Read
//	// line 아이디 최신값 조회
//	@RequestMapping(value = "/getLine.do" , method = {RequestMethod.GET, RequestMethod.POST})
//	public String getLine(@RequestParam(value = "line_id") String line_id,LineDAO lineDAO, Model model) {
//
//		System.out.println("getLine 진입");
//
//		LineVO lineVO = lineDAO.getLine(line_id);
//		model.addAttribute("lineVO",lineVO );
//		return "line";
//	}
//
//
//	// update
//	@RequestMapping(value = "/updateLine.do" , method = RequestMethod.POST)
////	public String updateLine(@ModelAttribute("lineVO") LineVO vo, LineDAO LineDAO, Model model) {
//	public String updateLine(LineVO vo, LineDAO LineDAO, Model model) {
//
//		System.out.println("updateLine 진입");
//		LineDAO.updateLine(vo);
//		model.addAttribute("vo",vo);
//		return "redirect:/getLineList.do";
//	}
//
//	// List
//	@RequestMapping(value = "/getLineList.do")
//	public String getLineList(LineDAO lineDAO, Model model) {
//
//		System.out.println("getLineList 진입");
//
//		List<LineVO> lineList = lineDAO.getLineList();
//		model.addAttribute("LineList", lineList);
//		return "lineStatus";
//	}
//



}
