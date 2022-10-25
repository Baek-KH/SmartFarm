package com.smartFarm.mes.controller.forward;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.forward.ForwardDAO;
import com.smartFarm.mes.dao.stock.StockDAO;
import com.smartFarm.mes.vo.forward.ForwardVO;
import com.smartFarm.mes.vo.stock.StockVO;


@Controller
@SessionAttributes("forward")
public class ForwardController {

		StockDAO stockDAO = new StockDAO();

	@RequestMapping("/getForwardList.do")
	public String getForwardList(
			ForwardVO vo, ForwardDAO forwardDAO, Model model) {
		    System.out.println("11111 컨트롤러 리스트");
	
		List<ForwardVO> forwardList = forwardDAO.getForwardList();	
		List<StockVO> stockList = stockDAO.getStockList();
			   
		model.addAttribute("StockList", stockList);   
		model.addAttribute("ForwardList",forwardList );
		return "forward";
	}

	@RequestMapping("/getForward.do")
	public String getForward(ForwardVO vo, ForwardDAO forwardDAO, Model model) {
		model.addAttribute("forward", forwardDAO.getForward(vo));
		return "getForward";
	}

	@RequestMapping("/updateForward.do")
	public String updateForward(ForwardVO vo, ForwardDAO forwardDAO) {
		ForwardVO forwardVO = new ForwardVO();
		forwardVO = forwardDAO.getForward(vo);
		StockVO stockVO = stockDAO.getStock(forwardVO.getPip_name());
		int qty = stockVO.getStock_qty()-Integer.parseInt(forwardVO.getForward_qty());
		stockVO.setStock_qty(qty);
		stockDAO.updateStock(stockVO);
		
		forwardDAO.updateForward(vo);
		return "redirect:/getForwardList.do";
	}

	@RequestMapping("/insertForward.do")
	public String insertForward(ForwardVO vo, ForwardDAO forwardDAO) {

		forwardDAO.insertForward(vo);
		return "redirect:/getForwardList.do";
	}

	@RequestMapping("/deleteForward.do")
	public String deleteForward(
	        @RequestParam(value="forward_id", defaultValue="", required=false) String forward_id
	        , ForwardDAO forwardDAO) {
		forwardDAO.deleteForward(forward_id);
		return "redirect:/getForwardList.do";
	}
}
