package com.yg.biz.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yg.biz.member.MemberVO;
import com.yg.biz.order.OrderDetailVO;
import com.yg.biz.order.OrderService;
import com.yg.biz.order.OrderVO;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;
	
	public OrderServiceImpl() {
		System.out.println("===> OrderService 객체 생성");
	}

	@Override
	public int getOrderNo(){
		System.out.println("===> orderService getOrderNo 호출");
		return orderDAO.getOrderNo();
	}
	
	public void updateOrder(OrderDetailVO orderDetailVO){
		System.out.println("===> orderService updateOrder 호출");
		orderDAO.updateOrder(orderDetailVO);
	}
	
	@Override
	public List<OrderDetailVO> getOrderList(OrderVO orderVO) {
		System.out.println("===> orderService getOrderList 호출");
		return orderDAO.getOrderList(orderVO);
	}

	@Override
	public List<OrderVO> getConfirmList(OrderVO orderVO) {
		System.out.println("===> orderService getConfirmList 호출");
		return orderDAO.getConfirmList(orderVO);
	}

	@Override
	public List<OrderVO> getMemberOrderList(MemberVO memberVO) {
		System.out.println("==> orderService getMemberOrderList 호출");
		return orderDAO.getMemberOrderList(memberVO);
	}
	
	@Override
	public List<OrderDetailVO> getOrderDetail(OrderVO orderVO){
		System.out.println("==> orderService getOrderDetail 호출");
		return orderDAO.getOrderDetail(orderVO);
		
	}
	
	@Override
	public void insertOrder(OrderDetailVO orderDetailVO){
		System.out.println("===> insertOrder 메서드 호출");
		orderDAO.insertOrder(orderDetailVO);
	}
	
	public void insertOrderProduct(OrderDetailVO orderDetailVO){
		System.out.println("===> insertOrderProduct 메서드 호출");
		orderDAO.insertOrderProduct(orderDetailVO);
	}
	
	

}
