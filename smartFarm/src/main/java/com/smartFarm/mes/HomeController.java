package com.smartFarm.mes;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartFarm.mes.dao.line.LineDAO;
import com.smartFarm.mes.dao.line.StatusDAO;
import com.smartFarm.mes.dao.stock.StockDAO;
import com.smartFarm.mes.dao.stock.StockHistoryDAO;
import com.smartFarm.mes.vo.line.StatusVO;
import com.smartFarm.mes.vo.stock.ProductRateVO;
import com.smartFarm.mes.vo.stock.StockVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@RequestMapping("/")
	public String signIn() {
		return "signIn";
	}
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
	
	@RequestMapping("/statusList")
	public String statusList() {
		return "statusList";
	}
	@RequestMapping("/index")
	public String index(Model model) {
		
		StockHistoryDAO stockHistoryDAO = new StockHistoryDAO();
		StockDAO stockDAO = new StockDAO();
		
		List<ProductRateVO> productRateList = stockHistoryDAO.productRateList();
		ProductRateVO productRateVO = stockHistoryDAO.getProductRate();
		
		List<StockVO> stockList = stockDAO.getStockList();
		
		model.addAttribute("StockList", stockList);
		model.addAttribute("productRateVO", productRateVO);
		model.addAttribute("productRateList", productRateList);
		
		return "index";
	}
	@RequestMapping("/insertEmployee")
	public String insertEmployee() {
		return "insertEmployee";
	}
	@RequestMapping("/orders")
	public String orders() {
		return "orders";
	}

	@RequestMapping(value = "/report.do")
	public String getReport(LineDAO lineDAO,StatusDAO statusDAO, Model model) {

		System.out.println("getReport 진입");
		
		List<StatusVO> statusList = statusDAO.getStatusListLimit();
		model.addAttribute("StatusList", statusList);
		return "report";
		
		
	}
	
}
