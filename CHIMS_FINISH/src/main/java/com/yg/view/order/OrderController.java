package com.yg.view.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yg.biz.member.MemberVO;
import com.yg.biz.order.OrderDetailVO;
import com.yg.biz.order.OrderService;
import com.yg.biz.order.OrderVO;
import com.yg.biz.product.ProductService;
import com.yg.biz.product.ProductVO;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;

	public OrderController() {
		System.out.println("===> OrderController 객체 생성");
	}

	
	@RequestMapping(value = "adminOrderList.do")
	public String adminOrderList(OrderVO orderVO, Model model) {
		System.out.println("===> adminOrderList.do 실행");

		List<OrderDetailVO> orderList = new ArrayList<OrderDetailVO>();
		
		for(OrderDetailVO vo : orderService.getOrderList(orderVO)){
			if(vo.getOrder_status().equals("member_waiting")){
				orderList.add(vo);
			}
		}
		
		model.addAttribute("orderList", orderList);

		return "adminOrderList.jsp";
	}
	
	@RequestMapping(value="adminConfirm.do", method=RequestMethod.GET)
	public String adminConfirm(OrderDetailVO orderDetailVO){
		System.out.println("===> adminConfirm.do get 실행");
		
		System.out.println(orderDetailVO.toString());
		
		// order 상태 변경
		orderService.updateOrder(orderDetailVO);
		
		return "adminOrderList.do";
	}
	
	@RequestMapping(value="memberConfirm.do",method=RequestMethod.GET)
	public String memberConfirm(OrderDetailVO orderDetailVO,HttpSession session){
		System.out.println("===> memberConfirm.do get 실행 " + orderDetailVO.toString());
		
		// order_status 변경
		orderService.updateOrder(orderDetailVO);
		
		// 전체 재고 변경하기
		ProductVO productVO = new ProductVO();
		productVO.setProduct_code(orderDetailVO.getProduct_code());
		
		productVO = productService.getProduct(productVO);
		if(productVO.getProduct_etc()==null){
			productVO.setProduct_etc("");
		}
		
		productVO.setProduct_cnt(productVO.getProduct_cnt() - orderDetailVO.getOrder_product_cnt());
//		productService.updateProduct(productVO);
		System.out.println("===> productVO " + productVO.toString());
		
		productService.updateProduct(productVO);
		
		// 부서의 물품 재고 증가
		// 만약 부서의 물품이 없다면 물품을 추가 , 있다면 수정
		if(productService.getDeptProduct(orderDetailVO) == null){
			// 부서의 물품 추가
			System.out.println("===> 부서에 물품을 추가 " + orderDetailVO);
			productService.insertDeptProduct(orderDetailVO);
		}else{
			// 부서의 물품 갯수 수정
			System.out.println("===> 부서에 물품 갯수를 수정");
			int current_product_cnt = productService.getDeptProduct(orderDetailVO).getOrder_product_cnt();
			orderDetailVO.setOrder_product_cnt(current_product_cnt+orderDetailVO.getOrder_product_cnt());
			productService.updateDeptProduct(orderDetailVO);
		}
//		productService.updateDeptProduct(orderDetailVO);
		
		
		return "memberMain.do";
	}
	
	@RequestMapping(value="updateDeptProduct")
	public String updateDeptProduct(){
		
		return "memberMain.do";
	}

	@RequestMapping(value = "adminConfirmList.do")
	public String adminConfirmList(OrderVO orderVO,OrderDetailVO orderDetailVO, Model model) {
		System.out.println("===> adminConfirmList.do 실행 " + orderVO);
		
		
		model.addAttribute("orderList", orderService.getConfirmList(orderVO));

		return "adminConfirmList.jsp";
	}

	@RequestMapping(value = "memberOrder.do", method = RequestMethod.GET)
	public String memberOrder(OrderVO orderVO,ProductVO productVO,Model model) {
		System.out.println("===> memberOrder.do get 실행");
		
		List<ProductVO> pList = productService.getAdminProductList();
		for(ProductVO p : pList){
			System.out.println(p.toString());
		}
		
		model.addAttribute("pList",pList);
		System.out.println("==========");
		return "memberOrder.jsp";
	}

	@RequestMapping(value = "memberOrder.do", method = RequestMethod.POST)
	public String memberOrderView(OrderDetailVO orderDetailVO,OrderVO orderVO) {
		System.out.println("===> memberOrder.do post 실행");
		
		// order_no 데이터 가져오기
		System.out.println(orderService.getOrderNo());
		orderDetailVO.setOrder_no(orderService.getOrderNo()+1);
		orderDetailVO.setOrder_status("member_waiting");
		// order 추가
		System.out.println(orderVO.toString());
		orderService.insertOrder(orderDetailVO);
		
		// order_product 추가
		System.out.println(orderDetailVO.toString());
//		System.out.println(orderVO.getOrder_no());
		
		
		orderService.insertOrderProduct(orderDetailVO);
		return "memberOrderList.do";
	}

	@RequestMapping(value = "memberOrderList.do")
	public String memberOrderList(MemberVO memberVO, HttpSession session, Model model) {
		System.out.println("===> memberOrderList.do 실행");
		memberVO.setMember_id((String) session.getAttribute("member_id"));
		model.addAttribute("memberOrderList", orderService.getMemberOrderList(memberVO));
		
		return "memberOrderList.jsp";
	}
	
	
	
	@RequestMapping(value = "adminOrderDetail.do",method =RequestMethod.GET)
	public String adminOrderDetail(OrderVO orderVO, HttpSession session,Model model){
		System.out.println("===> adminOrderDetail.do  get 실행 ");
		
		List<OrderDetailVO> orderDetailList = orderService.getOrderDetail(orderVO);
		
		for(OrderDetailVO odl : orderDetailList){
			System.out.println(odl.toString());
		}
		
		model.addAttribute("adminOrderDetail",orderService.getOrderDetail(orderVO));
		return "adminOrderDetail.jsp";
	}
	
	@RequestMapping(value = "memberOrderDetail.do",method =RequestMethod.GET)
	public String memberOrderDetail(OrderVO orderVO, HttpSession session, Model model){
		System.out.println("===> memberOrderDetail.do  get 실행");
		
		model.addAttribute("memberOrderDetail",orderService.getOrderDetail(orderVO));
		
		return "memberOrderDetail.jsp";
	}
	
}
