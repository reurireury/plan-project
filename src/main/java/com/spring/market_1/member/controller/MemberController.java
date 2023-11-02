package com.spring.market_1.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.ObjectController;
import com.spring.market_1.member.dto.MemberDTO;
import com.spring.market_1.member.service.MemberService;



@Controller("memberController")
public class MemberController implements ObjectController
{

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

	@Override
	public ModelAndView Form() throws Exception {
		
		return null;
	}
	
}
