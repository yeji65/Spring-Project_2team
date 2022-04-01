package com.yg.view.member;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yg.biz.member.MemberService;
import com.yg.biz.member.MemberVO;
import com.yg.biz.product.ProductVO;

@Controller
@SessionAttributes("member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("===> MemberController 객체 생성");
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login(MemberVO vo){
		System.out.println("===> login.do get");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String getMember(MemberVO vo, HttpSession session,Model model){
		System.out.println("===> 로그인 인증처리 " + vo.toString());
		
		if(vo.getMember_id() == null || vo.getMember_id().equals("")){
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		
		MemberVO member = memberService.getMember(vo);
		
		if(member != null){
			model.addAttribute(member);
			vo.setDept_no(member.getDept_no());
			
			session.setAttribute("member_id", member.getMember_id());
			session.setAttribute("member_name", member.getMember_name());
			session.setAttribute("member_role", member.getMember_role());
			session.setAttribute("dept_no", member.getDept_no());
			
			
			System.out.println(member.toString());
			if(member.getMember_role().equals("admin")){				
				if(member.getMember_pwd().equals(vo.getMember_pwd()))
					return "adminMain.do";
				else
					return "login.jsp";
			}
			else
				if(member.getMember_pwd().equals(vo.getMember_pwd()))
					return "memberMain.do";
				else
					return "login.jsp";
		}else{
			return "login.jsp";
		}	
	}
	
	@RequestMapping(value="adminMemberList.do")
	public String getMemberList(MemberVO memberVO,Model model){
		System.out.println("===> MemberController getMemberList 호출");
		
		model.addAttribute("memberList",memberService.getMemberList(memberVO));
		
		return "adminMemberList.jsp";
	}
	
	@RequestMapping(value="adminMemberInsert.do",method=RequestMethod.GET)
	public String memberInsertView(MemberVO memberVO,Model model){
		System.out.println("===> MemberController memberInsert get 호출");

		return "adminMemberInsert.jsp";
	}
	
	@RequestMapping(value="adminMemberInsert.do",method=RequestMethod.POST)
	public String memberInsert(MemberVO memberVO,Model model){
		System.out.println("===> MemberController memberInsert post 호출");
		
		memberService.insertMember(memberVO);
		
		return "adminMemberList.do";
	}
	
	@RequestMapping(value="adminMemberUpdate.do",method=RequestMethod.GET)
	public String memberUpdateView(MemberVO memberVO, HttpSession session, Model model){
		System.out.println("===> MemberController memberUpdate get 호출");
		
		memberVO.setMember_role((String) session.getAttribute("member_role"));
		
		System.out.println(memberVO.toString());
		
		model.addAttribute("member",memberService.getMember(memberVO));
		
		return "adminMemberUpdate.jsp";
	}
	
	@RequestMapping(value="adminMemberUpdate.do",method=RequestMethod.POST)
	public String adminmemberUpdate(MemberVO memberVO,Model model, HttpSession session){
		System.out.println("===> MemberController adminMemberUpdate post 호출");
		System.out.println(memberVO.toString());
		
		memberVO.setMember_role((String) session.getAttribute("member_role"));

		memberService.updateMember(memberVO);
		
		return "adminMemberList.do";
	}
	
	@RequestMapping(value="adminMemberDelete.do")
	public String adminMemberDelete(MemberVO memberVO){
		System.out.println("===> MemberController adminMemberDelete 호출 " + memberVO.toString());
		memberService.deleteMember(memberVO);
		return "adminMemberList.do";
	}
	
	@RequestMapping(value="memberUpdate.do",method=RequestMethod.POST)
	public String memberUpdate(MemberVO memberVO,Model model, HttpSession session){
		System.out.println("===> MemberController memberUpdate post 호출 " + memberVO.toString());
		
		memberVO.setMember_role((String) session.getAttribute("member_role"));
		memberService.updateMember(memberVO);
		session.setAttribute("member_name", memberVO.getMember_name());
		return "memberMain.do";
	}
	
	
	
	@RequestMapping(value="memberMypage.do",method = RequestMethod.GET)
	public String memberMypage(MemberVO memberVO,Model model,HttpSession session){
		System.out.println("===> memberController memberMypage 호출");
		
		memberVO.setMember_id((String)session.getAttribute("member_id"));
		model.addAttribute("member",memberService.getMember(memberVO));
		
		return "memberMypage.jsp";
	}

}
