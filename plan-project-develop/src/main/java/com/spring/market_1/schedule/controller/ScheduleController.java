package com.spring.market_1.schedule.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.ObjectController;
import com.spring.market_1.member.service.MemberService;
import com.spring.market_1.schedule.dto.ScheduleDTO;
import com.spring.market_1.schedule.service.ScheduleService;

@Controller("scheduleController")
public class ScheduleController implements ObjectController{

	@Autowired
    private ScheduleService scheduleService;
	
	@Autowired
    private ScheduleDTO scheduleDTO;
	
	
	@Override
	public ModelAndView ListObjects() throws Exception {
		
		return null;
	}
	/* 캘린더 일정보기 */
	@RequestMapping(value="/schedule/ListObjects.do", method=RequestMethod.GET)
	public ModelAndView ListObjects(ModelAndView mav,HttpServletRequest request) throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri); 
		
		String viewpage="Myshedule";
		List<ScheduleDTO> schedule=null;
		try {
			schedule = scheduleService.ListObjects();
			request.setAttribute("scheduleList", schedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.setViewName(viewpage);
		return mav;
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
	
	
	/* 페이지 불러오기*/
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
