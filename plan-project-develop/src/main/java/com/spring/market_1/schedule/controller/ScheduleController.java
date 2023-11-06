package com.spring.market_1.schedule.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.ObjectController;
@Controller("ScheduleController")
public class ScheduleController implements ObjectController{

	@Override
	public ModelAndView ListObjects() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView SelectObjects() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView AddObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView RemoveObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView ModObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView UpdateObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView SearchObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView Form() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = {"/schedule/Myschedule.do",
},method = RequestMethod.GET)
public ModelAndView Form(@RequestParam(value = "type", required = false) String type, HttpServletRequest request) throws Exception {
	ModelAndView mav = new ModelAndView();

	String uri = request.getRequestURI();
	System.out.println(uri); ///plan/schedule/Myschedule.do 
	

	if(uri.endsWith("Myschedule.do")) {
		mav.setViewName("/schedule/Myschedule");
		
	}else if(uri.endsWith("LoginForm.do")) {
		mav.setViewName("/member/LoginForm");
	}
	
	
	return mav;
}
}
