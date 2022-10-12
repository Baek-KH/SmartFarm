package com.smartFarm.mes.controller.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.stock.StockDAO;
import com.smartFarm.mes.vo.stock.StockVO;


@Controller
@SessionAttributes("stock")
public class StockController {

	
	// Read
    
 // insert
    @RequestMapping(value = "/insertStock.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String insertStock(StockVO vo, StockDAO stockDAO , Model model) {

        System.out.println("insertStock 진입");
        System.out.println(vo.toString());

        model.addAttribute("vo",vo);
        stockDAO.insertStock(vo);
        return "redirect:/getStockList.do";

    }
    
	// stock 아이디 최신값 조회
	@RequestMapping(value = "/getStock.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getStock(@RequestParam(value = "stock_id") String stock_id,StockDAO stockDAO, Model model) {

		System.out.println("getStock 진입");

		StockVO stockVO = stockDAO.getStock(stock_id);
		model.addAttribute("stockVO",stockVO );
		return "stock";
	}


	// update
	@RequestMapping(value = "/updateStock.do" , method = RequestMethod.POST)
	public String updateStock(StockVO vo, StockDAO StockDAO, Model model) {

		System.out.println("updateStock 진입");
		StockDAO.updateStock(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getStockList.do";
	}

	// List
	@RequestMapping(value = "/getStockList.do")
	public String getStockList(StockDAO stockDAO, Model model) {

		System.out.println("getStockList 진입");

		List<StockVO> stockList = stockDAO.getStockList();
		model.addAttribute("StockList", stockList);
		return "stockStock";
	}

	// ListSearch
    @RequestMapping(value = "/getStockListSearch.do")
    public String getStockListSearch(
            @RequestParam(value="field", defaultValue="", required=false) String field,
            @RequestParam(value="query", defaultValue="", required=false) String query,
            StockDAO stockDAO, Model model) {

        System.out.println("getStockList 진입");

        List<StockVO> stockList = new ArrayList<>();

        if (field != null & query !=null) {

            stockList = stockDAO.getStockListSearch(field, query);
        } else  {
            stockList = stockDAO.getStockList();
        }


        model.addAttribute("StockList", stockList);
        return "stockList";
    }


}
