package com.yg.biz.order.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yg.biz.member.MemberVO;
import com.yg.biz.order.OrderDetailVO;
import com.yg.biz.order.OrderVO;

@Repository("orderDAO")
public class OrderDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public OrderDAO() {
		System.out.println("===> OrderDAO 객체 생성");
	}
	
	public int getOrderNo(){
		System.out.println("===> Mybatis로 getOrderNo() 기능 처리");
		return mybatis.selectOne("OrderDAO.getOrderNo");
	}
	
	public void updateOrder(OrderDetailVO orderDetailVO){
		System.out.println("===> Mybatis로 updateOrder() 기능 처리 " +  orderDetailVO.toString());
		mybatis.update("OrderDAO.updateOrder",orderDetailVO);
	}
	
	public List<OrderDetailVO> getOrderList(OrderVO orderVO){
		System.out.println("===> Mybatis로 getOrderList() 기능 처리 " + orderVO.toString());
		return mybatis.selectList("OrderDAO.getOrderList", orderVO);
	}
	
	public List<OrderVO> getConfirmList(OrderVO orderVO){
		System.out.println("===> Mybatis로 getConfirmList() 기능 처리 " + orderVO.toString());
		return mybatis.selectList("OrderDAO.getConfirmList", orderVO);
	}
	
	public List<OrderVO> getMemberOrderList(MemberVO memberVO) {
		System.out.println("==> MyBatis로 getMemberOrderList() 기능 처리 " + memberVO.toString());
		return mybatis.selectList("OrderDAO.getMemberOrderList", memberVO);
	}
	
	public List<OrderDetailVO> getOrderDetail(OrderVO orderVO){
		System.out.println("==> MyBatis로 getOrderDetail() 기능 처리 " + orderVO.toString());
		return mybatis.selectList("OrderDAO.getOrderDetail",orderVO);
	}
	
	public void insertOrder(OrderDetailVO orderDetailVO){
		System.out.println("=== MyBatis로 insertOrder() 기능 처리 - " + orderDetailVO.toString());
		mybatis.insert("OrderDAO.insertOrder",orderDetailVO);		
	}
	public void insertOrderProduct(OrderDetailVO orderDetailVO){
		System.out.println("=== MyBatis로 insertOrderProduct() 기능 처리 - " + orderDetailVO.toString());
		mybatis.insert("OrderDAO.insertOrderProduct",orderDetailVO);
		
	}
	

}
