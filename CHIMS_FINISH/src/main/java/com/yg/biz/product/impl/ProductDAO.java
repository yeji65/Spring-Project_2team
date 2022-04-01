package com.yg.biz.product.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yg.biz.member.MemberVO;
import com.yg.biz.order.OrderDetailVO;
import com.yg.biz.product.ProductVO;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public ProductDAO() {
		System.out.println("===> ProductDAO 객체 생성");
	}
	
	public void insertProduct(ProductVO vo){
		System.out.println("===> Mybatis로 insertProduct() 기능 처리 " + vo.toString());
		mybatis.insert("ProductDAO.insertProduct", vo);
	}
	
	public void updateProduct(ProductVO vo){
		System.out.println("===> Mybatis로 updateProduct() 기능 처리 " + vo.toString());
		
		mybatis.update("ProductDAO.updateProduct", vo);	
	}
	
	public void updateDeptProduct(OrderDetailVO vo){
		System.out.println("===> Mybatis로 updateDeptProduct() 기능 처리" + vo.toString());
		
		mybatis.insert("ProductDAO.updateDeptProduct", vo);
	}
	
	public void insertDeptProduct(OrderDetailVO vo){
		System.out.println("===> Mybatis로 insertDeptProduct() 기능 처리 " + vo.toString());
		
		mybatis.insert("ProductDAO.insertDeptProduct", vo);
	}
	
	public OrderDetailVO getDeptProduct(OrderDetailVO vo){
		System.out.println("===> Mybatis로 getDeptProduct() 기능 처리 " + vo.toString());
		
		return mybatis.selectOne("ProductDAO.getDeptProduct",vo);
	}
	
	public void deleteProduct(ProductVO vo){
		System.out.println("===> Mybatis로 deleteProduct() 기능 처리" + vo.toString());
		mybatis.delete("ProductDAO.deleteProduct", vo);
	}
	
	public ProductVO getProduct(ProductVO vo){
		System.out.println("===> Mybatis로 getProduct() 기능 처리 " + vo.toString());
		return (ProductVO)mybatis.selectOne("ProductDAO.getProduct",vo);
	}
	
	public ProductVO getMemberProduct(OrderDetailVO vo){
		System.out.println("===> Mybatis로 getMemberProduct() 기능 처리 " + vo.toString());
		return (ProductVO)mybatis.selectOne("ProductDAO.getMemberProduct",vo);		
	}
	
	/*public List<ProductVO> getProductList(ProductVO vo){
		System.out.println("===> Mybatis로 getProductList() 기능 처리");
		return mybatis.selectList("ProductDAO.getProductList", vo);
	}*/
	
	public List<ProductVO> getAdminProductList(){
		System.out.println("===> Mybatis로 getAdminProductList() 기능 처리");
		return mybatis.selectList("ProductDAO.getAdminProductList");
	}
	public List<ProductVO> getMemberProductList(MemberVO vo){
		System.out.println("===> Mybatis로 getMemberProductList() 기능 처리 " + vo.toString());
		return mybatis.selectList("ProductDAO.getMemberProductList", vo);
	}

}
