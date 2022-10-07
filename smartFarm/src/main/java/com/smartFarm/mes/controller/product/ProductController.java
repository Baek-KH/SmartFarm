package com.smartFarm.mes.controller.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.product.ProductDAO;
import com.smartFarm.mes.vo.product.ProductVO;


@Controller
@SessionAttributes("product")
public class ProductController {
	
	
	// 검색조건설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,	String> conditionMap = new HashMap<>();
		conditionMap.put("제품아이디", "PRO_ID");
		conditionMap.put("제품이름", "PRO_NAME");
		conditionMap.put("제품수량", "PRO_QTY");
		
		return conditionMap;
		
	}

	@RequestMapping("/getProductList.do") 
	public String getProductList(
			@RequestParam(value="searchCondition", defaultValue="PRO_ID", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,	
			ProductVO vo, ProductDAO productDAO, Model model) {
		    System.out.println("11111 컨트롤러 리스트");
		
		model.addAttribute("productList", productDAO.getProductList(vo));
		return "getProductList";
	}
	
	@RequestMapping("/getProduct.do") 
	public String getProduct(ProductVO vo, ProductDAO productDAO, Model model) {
		model.addAttribute("product", productDAO.getProduct(vo));
		return "getProduct";
	}
	
	@RequestMapping("/updateProduct.do") 
	public String updateProduct(@ModelAttribute("product") ProductVO vo, ProductDAO productDAO) {
	   
		productDAO.updateProduct(vo);
		return "getProductList";
	}
	
	@RequestMapping("/insertProduct.do") 
	public String insertProduct(ProductVO vo, ProductDAO productDAO) {
		
		productDAO.insertProduct(vo);
		return "getProductList";
	}
	
	@RequestMapping("/deleteProduct.do") 
	public String deleteProduct(
	        @RequestParam(value="pro_id", defaultValue="", required=false) String pro_id 
	        , ProductDAO productDAO) {
		productDAO.deleteProduct(pro_id);
		return "getProductList";
	}	
}
