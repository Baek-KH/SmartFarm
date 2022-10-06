package com.smartFarm.mes.controller.collectdata;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.smartFarm.mes.dao.collectdata.CollectDataDAO;
import com.smartFarm.mes.dao.product.ProductDAOSpring;
import com.smartFarm.mes.vo.collectdata.CollectDataVO;
import com.smartFarm.mes.vo.product.ProductVO;

@Controller
@SessionAttributes("collectData")
public class CollectDataController {
	
	
	// 검색조건설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,	String> conditionMap = new HashMap<>();
		conditionMap.put("제품아이디", "PRO_ID");
		conditionMap.put("제품이름", "PRO_NAME");
		conditionMap.put("제품수량", "PRO_QTY");
		
		return conditionMap;
		
	}

	@RequestMapping("/getCollectDataList.do") 
	public String getCollectDataList(
			@RequestParam(value="searchCondition", defaultValue="PRO_ID", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,	
			CollectDataVO vo, CollectDataDAO collectDataDAO, Model model) {
		    System.out.println("11111 컨트롤러 리스트");
		
		model.addAttribute("collectDataList", collectDataDAO.getCollectDataList(vo));
		return "getCollectDataList";
	}
	
	@RequestMapping("/getCollectData.do") 
	public String getCollectData(CollectDataVO vo, CollectDataDAO collectDataDAO, Model model) {
		model.addAttribute("collectData", collectDataDAO.getCollectData(vo));
		return "getCollectData";
	}
	
	
	
	//111
	public String deleteCollectData( CollectDataDAO collectDataDAO , Model model) {
	    
	    ProductDAOSpring productDAO = new ProductDAOSpring();
	    
	    // 제일 최근 꺼 하나만 가지고 오는 제일 최근 productVO 1건 
	    ProductVO productVO = productDAO.getProduct(null)
	    // 제일 최근 꺼 하나만 가지고 오는 BoardVO 1건 
	    String BoardVO = "";
	    
	    CollectDataVO collectDataVO = new CollectDataVO();
	    collectDataVO.setPro_date(productVO.getPro_date());
	    collectDataVO.setPro_date(productVO.getPro_date());
	    collectDataVO.setPro_date(productVO.getPro_date());
	    collectDataVO.setPro_date(BoardVO.getWriter());
	    
	            
	            
	    CollectDataVO vo =  collectDataDAO.getCollectData(null);
	    collectDataDAO.insertCollectData(collectDataVO);
      
        return "getCollectDataList";
    }  
	
	
	
}
