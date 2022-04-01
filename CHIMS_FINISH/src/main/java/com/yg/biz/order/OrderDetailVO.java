package com.yg.biz.order;

import java.util.Date;

public class OrderDetailVO {

	private int order_no;
	private Date order_date;
	private Date confirm_date;
	private String order_status;
	private String product_category;
	private int dept_product_no;
	private String product_code;
	private String product_name;
	private int dept_no;
	private int order_product_cnt;
	private String order_member_id;
	private String order_member_name;
	
	public OrderDetailVO(){
		System.out.println("===> OrderDetailVO 객체 생성");
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getConfirm_date() {
		return confirm_date;
	}

	public void setConfirm_date(Date confirm_date) {
		this.confirm_date = confirm_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public int getOrder_product_cnt() {
		return order_product_cnt;
	}

	public void setOrder_product_cnt(int order_product_cnt) {
		this.order_product_cnt = order_product_cnt;
	}

	public String getOrder_member_id() {
		return order_member_id;
	}

	public void setOrder_member_id(String order_member_id) {
		this.order_member_id = order_member_id;
	}

	public String getOrder_member_name() {
		return order_member_name;
	}

	public void setOrder_member_name(String order_member_name) {
		this.order_member_name = order_member_name;
	}

	

	@Override
	public String toString() {
		return "OrderDetailVO [order_no=" + order_no + ", order_date=" + order_date + ", confirm_date=" + confirm_date
				+ ", order_status=" + order_status + ", product_category=" + product_category + ", dept_product_no="
				+ dept_product_no + ", product_code=" + product_code + ", product_name=" + product_name + ", dept_no="
				+ dept_no + ", order_product_cnt=" + order_product_cnt + ", order_member_id=" + order_member_id
				+ ", order_member_name=" + order_member_name + "]";
	}

	public int getDept_product_no() {
		return dept_product_no;
	}

	public void setDept_product_no(int dept_product_no) {
		this.dept_product_no = dept_product_no;
	}
	
	
}
