package com.smartFarm.mes.controller.buyers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.buyer.OrdersDAO;
import com.smartFarm.mes.vo.buyer.OrdersVO;


@Controller
@SessionAttributes("orders")
public class OrdersController {


	// getOrders
	@RequestMapping(value = "/getOrders.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public String getOrders(@RequestParam(value = "orders_id") String orders_id,OrdersDAO ordersDAO, Model model) {

		System.out.println("getOrders 진입");
		OrdersVO ordersVO = ordersDAO.getOrders(orders_id);
		model.addAttribute("ordersVO",ordersVO );
		return "orders";
	}

	// insert
	@RequestMapping(value = "/insertOrders.do", method = RequestMethod.POST)
	public String insertOrders(OrdersVO vo, OrdersDAO ordersDAO , Model model) {

		System.out.println("insertOrders 진입");
		model.addAttribute("vo",vo);
		ordersDAO.insertOrders(vo);
		return "redirect:/getOrdersList.do";
	}

	// update
	@RequestMapping(value = "/updateOrders.do" , method = RequestMethod.POST)
//	public String updateOrders(@ModelAttribute("ordersVO") OrdersVO vo, OrdersDAO OrdersDAO, Model model) {
	public String updateOrders(OrdersVO vo, OrdersDAO OrdersDAO, Model model) {

		System.out.println("updateOrders 진입");
		OrdersDAO.updateOrders(vo);
		model.addAttribute("vo",vo);
		return "redirect:/getOrdersList.do";
	}


	// List
	@RequestMapping("/getOrdersList.do")
	public String getOrdersList(OrdersDAO ordersDAO, Model model) {

		System.out.println("getOrdersList 진입");

		List<OrdersVO> ordersList = ordersDAO.getOrdersList();
		model.addAttribute("OrdersList", ordersList);
		return "orders";
	}

//	// ListSearch
//	@RequestMapping(value = "/getOrdersListSearch.do")
//	public String getOrdersListSearch(
//			@RequestParam(value="field", defaultValue="", required=false) String field,
//			@RequestParam(value="query", defaultValue="", required=false) String query,
//			OrdersDAO ordersDAO, Model model) {
//
//		System.out.println("getOrdersList 진입");
//
//		List<OrdersVO> ordersList = new ArrayList<>();
//
//		if (field != null & query !=null) {
//
//			ordersList = ordersDAO.getOrdersListSearch(field, query);
//		} else  {
//			ordersList  =	ordersDAO.getOrdersList();
//		}
//
//
//		model.addAttribute("OrdersList", ordersList);
//		return "ordersList";
//	}



}
