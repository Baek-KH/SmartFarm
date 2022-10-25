package com.smartFarm.mes.controller.buyers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.buyer.BuyerDAO;
import com.smartFarm.mes.vo.buyer.BuyerVO;


@Controller
@SessionAttributes("Buyer")
public class BuyerController {


	// getBuyer
	@RequestMapping(value = "/getBuyer.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getBuyer(BuyerVO vo, BuyerDAO buyerDAO, Model model) {

		System.out.println("getBuyer 진입");
		BuyerVO buyerVO = buyerDAO.getBuyer(vo.getBuyer_id());
		model.addAttribute("buyerVO",buyerVO );
		return "buyerDetail";
	}
	
	// getBuyerName
	@RequestMapping(value = "/getBuyerName.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getBuyerName(@RequestParam(value = "buyer_name") String buyer_name,BuyerDAO buyerDAO, Model model) {
		
		System.out.println("getBuyerName 진입");
		BuyerVO buyerVO = buyerDAO.getBuyer(buyer_name);
		model.addAttribute("buyerVO",buyerVO );
		return "getBuyer";
	}

	// insert
	@RequestMapping(value = "/insertBuyer.do", method = RequestMethod.POST)
	public String insertBuyer(BuyerVO vo, BuyerDAO buyerDAO , Model model) {

		System.out.println("insertBuyer 진입");
		model.addAttribute("vo",vo);
		buyerDAO.insertBuyer(vo);
		return "redirect:/getBuyerList.do";
	}

	
	
	
	// update
	@RequestMapping(value = "/updateBuyer.do" , method = RequestMethod.POST)
	public String updateBuyer(BuyerVO vo, BuyerDAO BuyerDAO, Model model) {

		System.out.println("updateBuyer 진입");
		BuyerDAO.updateBuyer(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getBuyerList.do";
	}

	// delete
	@RequestMapping("/deleteBuyer.do")
	public String deleteBuyer(BuyerVO vo, BuyerDAO BuyerDAO) {
		System.out.println("deleteBuyer 진입");
		BuyerDAO.deleteBuyer(vo);
		return "redirect:/getBuyerList.do";
	}



	// List
	@RequestMapping("/getBuyerList.do")
	public String getBuyerList(BuyerDAO buyerDAO, Model model) {

		System.out.println("getBuyerList 진입");

		List<BuyerVO> buyerList = buyerDAO.getBuyerList();
		model.addAttribute("BuyerList", buyerList);
		return "buyer";
	}

	// ListSearch 미구현
//	@RequestMapping(value = "/getBuyerListSearch.do")
//	public String getBuyerListSearch(
//			@RequestParam(value="field", defaultValue="", required=false) String field,
//			@RequestParam(value="query", defaultValue="", required=false) String query,
//			BuyerDAO buyerDAO, Model model) {
//
//		System.out.println("getBuyerList 진입");
//
//		List<BuyerVO> buyerList = new ArrayList<>();
//
//		if (field != null & query !=null) {
//
//			buyerList = buyerDAO.getBuyerListSearch(field, query);
//		} else  {
//			buyerList  =	buyerDAO.getBuyerList();
//		}
//
//
//		model.addAttribute("BuyerList", buyerList);
//		return "buyerList";
//	}



}
