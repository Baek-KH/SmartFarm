package com.smartFarm.mes.controller.stock;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.stock.StockDAO;
import com.smartFarm.mes.dao.stock.StockHistoryDAO;
import com.smartFarm.mes.vo.stock.StockHistoryVO;
import com.smartFarm.mes.vo.stock.StockVO;


@Controller
@SessionAttributes("stockHistory")
public class StockHistoryController {

	

	
	// insert
	@RequestMapping(value = "/insertStockHistory.do" , method = RequestMethod.POST)
	public String insertStockHistory(StockHistoryVO vo, StockHistoryDAO StockHistoryDAO, Model model) {
		
		System.out.println("insertStockHistory 진입");
		System.out.println(vo.toString());
		StockHistoryDAO.insertStockHistory(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getStockHistoryList.do";
	}
	
	
	// stockHistory 아이디 최신값 조회
	@RequestMapping(value = "/getStockHistory.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getStockHistory(@RequestParam(value = "stockHistory_id") String stockHistory_id,StockHistoryDAO stockHistoryDAO, Model model) {

		System.out.println("getStockHistory 진입");

		StockHistoryVO stockHistoryVO = stockHistoryDAO.getStockHistory(stockHistory_id);
		model.addAttribute("stockHistoryVO",stockHistoryVO );
		return "stockHistory";
	}


	// update
	@RequestMapping(value = "/updateStockHistory.do" , method = RequestMethod.POST)
	public String updateStockHistory(StockHistoryVO vo, StockHistoryDAO StockHistoryDAO, Model model) {

		System.out.println("updateStockHistory 진입");
		StockHistoryDAO.updateStockHistory(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getStockHistoryList.do";
	}
	
	
	// List
	@RequestMapping(value = "/getStockHistoryList.do")
	public String getStockHistoryList(StockHistoryDAO stockHistoryDAO,StockDAO stockDAO, Model model) {

		System.out.println("getStockHistoryList 진입");

		List<StockVO> stockList = stockDAO.getStockList();
		model.addAttribute("StockList", stockList);
		List<StockHistoryVO> stockHistoryListIn = stockHistoryDAO.getStockHistoryListIn();
		model.addAttribute("StockHistoryListIn", stockHistoryListIn);
		List<StockHistoryVO> stockHistoryListOut = stockHistoryDAO.getStockHistoryListOut();
		model.addAttribute("StockHistoryListOut", stockHistoryListOut);
		return "stockHistoryList";
	}
	
//	// ListIn
//		@RequestMapping(value = "/getStockHistoryList.do")
//		public String getStockHistoryListIn(StockHistoryDAO stockHistoryDAO, Model model) {
//
//			System.out.println("getStockHistoryList 진입");
//
//			List<StockHistoryVO> stockHistoryListIn = stockHistoryDAO.getStockHistoryList();
//			model.addAttribute("StockHistoryListIn", stockHistoryListIn);
//			return "stockHistoryList";
//		}
//
//	// ListOut
//		@RequestMapping(value = "/getStockHistoryList.do")
//		public String getStockHistoryListOut(StockHistoryDAO stockHistoryDAO, Model model) {
//
//			System.out.println("getStockHistoryList 진입");
//
//			List<StockHistoryVO> stockHistoryListOut = stockHistoryDAO.getStockHistoryList();
//			model.addAttribute("StockHistoryListOut", stockHistoryListOut);
//			return "stockHistoryList";
//		}

}
