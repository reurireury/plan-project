package com.spring.market_1.schedule.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.ObjectController;
import com.spring.market_1.member.dto.MemberDTO;
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
	public JSONArray  ListObjects(HttpServletRequest request) throws Exception {
	    String uri = request.getRequestURI();
	    System.out.println(uri); 

	    List<ScheduleDTO> scheduleList = scheduleService.ListObjects();
	    
	    
	    JSONArray jsonArray = new JSONArray();
	 
	    
	    for (ScheduleDTO schedule : scheduleList) {
			Map<String, Object> oneReserve = new HashMap<>();
			  
				oneReserve.put("title", schedule.getTitle()); //map에 담은 후
				System.out.println("원리버스"+oneReserve);
				System.out.println("스케줄타이틀"+schedule.getTitle());
				
				oneReserve.put("start1", schedule.getStart1());
				oneReserve.put("end1", schedule.getEnd1());
				JSONObject jsonObj = new JSONObject(oneReserve); //obj에 담고
				jsonArray.add(jsonObj); //obj를 array에 담는다.
				
				System.out.println("원리버스: " + oneReserve);
		        System.out.println("스케줄타이틀: " + schedule.getTitle());
		        System.out.println("JSON 객체: " + jsonObj);

		 }
	    return jsonArray;
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
