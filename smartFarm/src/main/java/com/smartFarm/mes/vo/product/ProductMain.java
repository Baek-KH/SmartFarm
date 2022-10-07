package com.smartFarm.mes.vo.product;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
	
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService) container.getBean("productServie");
		
		ProductVO vo = new ProductVO();
		vo.setPro_id("JdbcTemplate을 구현 : 아이디입니다!!");
		vo.setPip_name("상추");
		vo.setPro_qty(123);
		productService.insertProduct(vo);
		
		List<ProductVO> productList = productService.getProductList(vo);
		for(ProductVO product:productList) {
			System.out.println(product.toString());
		}
		container.close();
	}

}
