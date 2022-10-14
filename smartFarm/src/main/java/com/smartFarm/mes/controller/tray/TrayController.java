package com.smartFarm.mes.controller.tray;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.tray.TrayDAO;
import com.smartFarm.mes.vo.tray.TrayVO;

@Controller
@SessionAttributes("tray")

public class TrayController {

	// getTray
	@RequestMapping(value = "/getTray.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getTray(@RequestParam(value = "line_id") String line_id, TrayDAO trayDAO, Model model) {

		System.out.println("getTray 진입");
		TrayVO trayVO = trayDAO.getTray(line_id);
		model.addAttribute("trayVO", trayVO);
		return "tray";
	}

	// insert
	@RequestMapping(value = "/insertTray.do", method = RequestMethod.POST)
	public String insertTray(TrayVO vo, TrayDAO trayDAO, Model model) {

		System.out.println("insertTray 진입");
		System.out.println(vo.toString());

		model.addAttribute("vo", vo);
		trayDAO.insertTray(vo);
		return "redirect:/getTrayList.do";

	}

	// List
	@RequestMapping(value = "/getTrayList.do")
	public String getTrayList(TrayDAO trayDAO, Model model) {

		System.out.println("getTrayList 진입");

		List<TrayVO> trayList = trayDAO.getTrayList();
		model.addAttribute("TrayList", trayList);
		return "trayList";
	}

	// ListSearch
	@RequestMapping(value = "/getTrayListSearch.do")
	public String getTrayListSearch(
			@RequestParam(value = "query", defaultValue = "", required = false) String query, TrayDAO trayDAO,
			Model model) {

		System.out.println("getTrayList 진입");

		List<TrayVO> trayList = new ArrayList<>();

		if (query != null) {

			trayList = trayDAO.getTrayListSearch("line_id", query);
		} else {
			trayList = trayDAO.getTrayList();
		}

		model.addAttribute("TrayList", trayList);
		return "trayList";
	}

}
