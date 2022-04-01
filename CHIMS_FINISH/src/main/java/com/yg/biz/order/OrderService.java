package com.yg.biz.order;

import java.util.List;

import com.yg.biz.member.MemberVO;

public interface OrderService {
	
	public int getOrderNo();
	
	public void updateOrder(OrderDetailVO orderDetailVO);
	
	public List<OrderDetailVO> getOrderList(OrderVO orderVO);
	
	public List<OrderVO> getConfirmList(OrderVO orderVO);
	
	public List<OrderVO> getMemberOrderList(MemberVO memberVO);
	
	public List<OrderDetailVO> getOrderDetail(OrderVO orderVO);
	
	public void insertOrder(OrderDetailVO orderDetailVO);
	public void insertOrderProduct(OrderDetailVO orderDetailVO);
	
	
}
