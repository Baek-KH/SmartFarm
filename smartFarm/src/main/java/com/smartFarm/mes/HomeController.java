package com.smartFarm.mes;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartFarm.mes.dao.stock.StockHistoryDAO;
import com.smartFarm.mes.vo.stock.ProductRateVO;

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
	@RequestMapping("/signIn")
	public String login() {
		return "signIn";
	}
	@RequestMapping("/statusList")
	public String statusList() {
		return "statusList";
	}
	@RequestMapping("/index")
	public String index(Model model) {
		
		StockHistoryDAO stockHistoryDAO = new StockHistoryDAO();
		List<ProductRateVO> productRateList = stockHistoryDAO.productRateList();
		ProductRateVO productRateVO = stockHistoryDAO.getProductRate();
	
		model.addAttribute("productRateVO", productRateVO);
		model.addAttribute("productRateList", productRateList);
		
		return "index";
	}
	@RequestMapping("/insertEmployee")
	public String insertEmployee() {
		return "insertEmployee";
	}


}
