package com.spring.market_1.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.ObjectController;
import com.spring.market_1.member.dto.MemberDTO;
import com.spring.market_1.member.service.MemberService;

@Controller("memberController")
public class MemberController implements ObjectController
{
	/* @Autowired 필요한 의존 객체타입(생성자,setter,필드)에 맞춰서 해당하는 빈을 찾아 주입 */
	@Autowired
    private MemberService memberService;
	
	
	@Override
	public ModelAndView ListObjects() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView SelectObjects() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView AddObject() throws Exception {
		
		return null;
	}
	/*회원가입*/
	/* @ModelAttribute form의 데이터 처리할 때 사용 html의 태그명과 dto 일치한 경우 dto에 자동반영 */
	@RequestMapping(value = "/member/AddObject.do", method = RequestMethod.POST)
	public ModelAndView AddObject(@ModelAttribute("member") MemberDTO member, HttpServletRequest request,
	        HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		System.out.println(id);
		
		memberService.AddObject(member);
		
		
		return null;
	}


	@Override
	public ModelAndView RemoveObject() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView ModObject() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView UpdateObject() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView SearchObject() throws Exception {
		
		return null;
	}

	//로그인폼 및 회원가입폼으로 이동을 위한
	@Override
	public ModelAndView Form() throws Exception {
		
		return null;
	}
	
	@RequestMapping(value = {
		        "/member/JoinForm.do",
		        "/member/LoginForm.do"
		    },method = RequestMethod.GET)
	public ModelAndView Form(@RequestParam(value = "type", required = false) String type, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
	
		String uri = request.getRequestURI();
		System.out.println(uri); ///plan/member/JoinForm.do 
		
		if(uri.endsWith("JoinForm.do")) {
			mav.setViewName("/member/JoinForm");
			
		}else if(uri.endsWith("LoginForm.do")) {
			mav.setViewName("/member/LoginForm");
		}
		
		
		
		return mav;
	}
	
}
