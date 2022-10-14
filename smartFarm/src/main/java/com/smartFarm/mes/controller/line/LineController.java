package com.smartFarm.mes.controller.line;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.line.LineDAO;
import com.smartFarm.mes.vo.line.LineVO;


@Controller
@SessionAttributes("line")
public class LineController {

	// Only Update & Read

	// Read
	// line 아이디 최신값 조회
	@RequestMapping(value = "/getLine.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getLine(@RequestParam(value = "line_id") String line_id,LineDAO lineDAO, Model model) {

		System.out.println("getLine 진입");

		LineVO lineVO = lineDAO.getLine(line_id);
		model.addAttribute("lineVO",lineVO );
		return "line";
	}


	// update
	@RequestMapping(value = "/updateLine.do" , method = RequestMethod.POST)
	public String updateLine(LineVO vo, LineDAO LineDAO, Model model) {

		System.out.println("updateLine 진입");
		LineDAO.updateLine(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getLineList.do";
	}
	
	// update
	@RequestMapping(value = "/updateLineDetail.do" , method = RequestMethod.GET)
		public String updateLineDetail(
				@RequestParam(value="field", defaultValue="", required=false) String field,
				@RequestParam(value="query", defaultValue="", required=false) String query,
				LineVO vo ,LineDAO LineDAO, Model model) {

			System.out.println("updateLineDetail 진입");
			LineDAO.updateLineDetail(vo, field, query);
			model.addAttribute("vo",vo);
			return "redirect:/getLineSettingList.do";
		}
	
	
	
	// List
	@RequestMapping(value = "/getLineList.do")
	public String getLineList(LineDAO lineDAO, Model model) {

		System.out.println("getLineList 진입");

		List<LineVO> lineList = lineDAO.getLineList();
		model.addAttribute("LineList", lineList);
		return "lineStatus";
	}
	// SettingList
		@RequestMapping(value = "/getLineSettingList.do")
		public String getLineSettingList(LineDAO lineDAO, Model model) {

			System.out.println("getLineSettingList 진입");

			List<LineVO> lineList = lineDAO.getLineList();
			model.addAttribute("LineList", lineList);
			return "lineSetting";
		}
	


}
