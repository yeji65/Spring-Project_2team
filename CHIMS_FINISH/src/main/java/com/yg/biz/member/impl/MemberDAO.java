package com.yg.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yg.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberDAO() {
		System.out.println("===> MemberDAO 객체 생성");
	}
	
	public void insertMember(MemberVO vo){
		System.out.println("===> mybatis로 insertMember 호출 " + vo.toString());
		mybatis.insert("MemberDAO.insertMember",vo);
	}
	
	public void updateMember(MemberVO vo){
		System.out.println("===> mybatis로 updateMember 호출 " + vo.toString());
		
		mybatis.update("MemberDAO.updateMember",vo);
	}
	
	public void deleteMember(MemberVO vo){
		System.out.println("===> mybatis로 deleteMember 호출 " + vo.toString());
		mybatis.update("MemberDAO.deleteMember",vo);
	}
	
	public MemberVO getMember(MemberVO vo){
		System.out.println("===> mybatis로 getMember 호출 " + vo.toString());
		return (MemberVO)mybatis.selectOne("MemberDAO.getMember",vo);
	}
	
	public List<MemberVO> getMemberList(MemberVO vo){
		System.out.println("===> mybatis로 getMemberList 호출 " + vo.toString());
		
		return mybatis.selectList("MemberDAO.getMemberList",vo);		
	}

}
