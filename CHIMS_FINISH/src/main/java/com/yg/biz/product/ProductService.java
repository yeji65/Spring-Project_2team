package com.yg.biz.product;

import java.util.List;

import com.yg.biz.member.MemberVO;
import com.yg.biz.order.OrderDetailVO;

public interface ProductService {
	// CRUD
	
	void insertProduct(ProductVO vo);
	
	void updateProduct(ProductVO vo);
	
	void deleteProduct(ProductVO vo);
	
	ProductVO getProduct(ProductVO vo);
	
	ProductVO getMemberProduct(OrderDetailVO vo);
	
	OrderDetailVO getDeptProduct(OrderDetailVO vo);
	
	List<ProductVO> getAdminProductList();
	
	List<ProductVO> getMemberProductList(MemberVO vo);
	
	void insertDeptProduct(OrderDetailVO orderDetailVO);

	void updateDeptProduct(OrderDetailVO orderDetailVO);
	
}
