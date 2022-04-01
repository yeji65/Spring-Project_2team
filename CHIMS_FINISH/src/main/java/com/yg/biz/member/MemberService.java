package com.yg.biz.member;

import java.util.List;

public interface MemberService {
	
	public MemberVO getMember(MemberVO vo);
	public void insertMember(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void deleteMember(MemberVO vo);
	public List<MemberVO> getMemberList(MemberVO vo);
}
