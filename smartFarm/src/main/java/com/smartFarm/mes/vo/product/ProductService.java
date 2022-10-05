package com.smartFarm.mes.vo.product;

import java.util.List;

public interface ProductService {

	void insertProduct(ProductVO vo);
	void deleteProduct(ProductVO vo);
	void updateProduct(ProductVO vo);
	ProductVO getProduct(ProductVO vo);
	List<ProductVO> getProductList (ProductVO vo);
}
