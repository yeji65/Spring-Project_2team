package com.yg.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yg.biz.member.MemberService;
import com.yg.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		
		return this.memberDAO.getMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		
		return this.memberDAO.getMemberList(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		this.memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		this.memberDAO.updateMember(vo);
		
	}

	@Override
	public void deleteMember(MemberVO vo) {
		this.memberDAO.deleteMember(vo);
	}

}
