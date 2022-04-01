package com.yg.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yg.biz.member.MemberVO;
import com.yg.biz.order.OrderDetailVO;
import com.yg.biz.product.ProductService;
import com.yg.biz.product.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public ProductServiceImpl() {}

	@Override
	public void insertProduct(ProductVO vo) {
		this.productDAO.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		this.productDAO.updateProduct(vo);
	}

	@Override
	public void deleteProduct(ProductVO vo) {
		this.productDAO.deleteProduct(vo);
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		return productDAO.getProduct(vo);
	}
	
	@Override
	public ProductVO getMemberProduct(OrderDetailVO vo){
		return productDAO.getMemberProduct(vo);
	}
	
	@Override
	public OrderDetailVO getDeptProduct(OrderDetailVO orderDetailVO){
		return productDAO.getDeptProduct(orderDetailVO);
	}

	
	@Override
	public List<ProductVO> getAdminProductList() {
		return productDAO.getAdminProductList();
	}

	@Override
	public List<ProductVO> getMemberProductList(MemberVO vo) {

		return productDAO.getMemberProductList(vo);
	}
	
	@Override
	public void insertDeptProduct(OrderDetailVO orderDetailVO){
		
		productDAO.insertDeptProduct(orderDetailVO);
	}

	@Override
	public void updateDeptProduct(OrderDetailVO orderDetailVO){
		
		productDAO.updateDeptProduct(orderDetailVO);
	}

}
