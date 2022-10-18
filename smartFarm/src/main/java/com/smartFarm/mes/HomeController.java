package com.smartFarm.mes;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartFarm.mes.dao.stock.StockDAO;
import com.smartFarm.mes.dao.stock.StockHistoryDAO;
import com.smartFarm.mes.vo.stock.ProductRateVO;
import com.smartFarm.mes.vo.stock.StockVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate );
//
//		return "home.jsp";
//	}

	@RequestMapping("/signUp")
	public String main() {	
		return "signUp";
	}
	@RequestMapping("/insertProduct")
    public String insertProduct() {  
        return "insertProduct";
    }

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

}
